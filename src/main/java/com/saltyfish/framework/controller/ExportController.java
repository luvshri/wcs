package com.saltyfish.framework.controller;

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
@RequestMapping("/export")
@RestController
public class ExportController {

    @Autowired
    private AuthService authService;

    @Autowired
    private ResponseService responseService;

    @Autowired
    private ExcelService excelService;

    @Autowired
    private WaterConservationRepository waterConservationRepository;

    @RequestMapping("/exportProject")
    public String exportProject(@RequestParam("userId") Integer userId,
                                @RequestParam("token") String token,
                                @RequestParam("projectId") Integer projectId,
                                HttpServletResponse httpServletResponse) {
//        Response response = new Response();
        try {
            if (!authService.checkLogin(userId, token)) {
//                return responseService.notLogin(response);
                return "未登录";
            } else if (!authService.checkUserProjectTownAccess(userId, projectId)) {
//                return responseService.noAccess(response);
                return "没有权限";
            } else {
                WaterConservationEntity waterConservationEntity = waterConservationRepository.findById(projectId);
                String category = waterConservationEntity.getCategory();
                switch (category) {
                    case "渡槽":
                        excelService.exportAqueduct(waterConservationEntity, httpServletResponse);
                        break;
                    default:
                        break;
                }
                return null;
            }
        } catch (Exception e) {
//            return responseService.serverError(response);
            return "服务器错误";
        }
    }
}
