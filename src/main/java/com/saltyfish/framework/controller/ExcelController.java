package com.saltyfish.framework.controller;

import com.saltyfish.common.bean.Response;
import com.saltyfish.domain.entity.project.WaterConservationEntity;
import com.saltyfish.domain.repository.project.WaterConservationRepository;
import com.saltyfish.framework.service.AuthService;
import com.saltyfish.framework.service.ExcelService;
import com.saltyfish.framework.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by weck on 16/9/19.
 */
@RequestMapping("/excel")
@RestController
public class ExcelController {

    @Autowired
    private AuthService authService;

    @Autowired
    private ResponseService responseService;

    @Autowired
    private ExcelService excelService;

    @Autowired
    private WaterConservationRepository waterConservationRepository;

    /**
     * 导出工程
     *
     * @param userId              用户id
     * @param token               登录token
     * @param projectId           工程id
     * @param httpServletResponse 响应
     * @return 文件流
     */
    @RequestMapping("/exportProject")
    public Response exportProject(@RequestParam("userId") Integer userId,
                                  @RequestParam("token") String token,
                                  @RequestParam("projectId") Integer projectId,
                                  HttpServletResponse httpServletResponse) {
        Response response = new Response();
        try {
            if (!authService.checkLogin(userId, token)) {
                return responseService.notLogin(response);
//                return "未登录";
            } else if (!authService.checkUserProjectTownAccess(userId, projectId)) {
                return responseService.noAccess(response);
//                return "没有权限";
            } else {
                WaterConservationEntity waterConservationEntity = waterConservationRepository.findById(projectId);
                String category = waterConservationEntity.getCategory();
                switch (category) {
                    case "渡槽":
                        excelService.exportAqueduct(waterConservationEntity, httpServletResponse);
                        break;
                    case "桥梁":
                        excelService.exportBridge(waterConservationEntity, httpServletResponse);
                        break;
                    case "渠道":
                        excelService.exportChannel(waterConservationEntity, httpServletResponse);
                        break;
                    case "涵洞":
                        excelService.exportCulvert(waterConservationEntity, httpServletResponse);
                        break;
                    case "塘坝":
                        excelService.exportDam(waterConservationEntity, httpServletResponse);
                        break;
                    case "深水井":
                        excelService.exportDeepWells(waterConservationEntity, httpServletResponse);
                        break;
                    case "管滴灌":
                        excelService.exportDripIrrigationPipe(waterConservationEntity, httpServletResponse);
                        break;
                    case "大口井":
                        excelService.exportGreateWells(waterConservationEntity, httpServletResponse);
                        break;
                    case "水电站":
                        excelService.exportHydropower(waterConservationEntity, httpServletResponse);
                        break;
                    case "水塘":
                        excelService.exportPond(waterConservationEntity, httpServletResponse);
                        break;
                    case "泵站":
                        excelService.exportPumpStation(waterConservationEntity, httpServletResponse);
                        break;
                    case "水闸":
                        excelService.exportSluice(waterConservationEntity, httpServletResponse);
                        break;
                    case "河道":
                        excelService.exportWatercourse(waterConservationEntity, httpServletResponse);
                        break;
                    case "水厂":
                        excelService.exportWaterWorks(waterConservationEntity, httpServletResponse);
                        break;
                    default:
                        break;
                }
                return null;
            }
        } catch (Exception e) {
            return responseService.serverError(response);
//            return "服务器错误";
        }
    }
}
