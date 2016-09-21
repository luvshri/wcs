package com.saltyfish.framework.service;

import com.saltyfish.domain.entity.project.WaterConservationEntity;
import com.saltyfish.domain.entity.project.conservation.*;
import com.saltyfish.domain.entity.project.division.CanalEntity;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by weck on 16/9/20.
 */
@Service
public class ExcelService {
    private static String aqueductModelFilePath = "file/渡槽基本情况表.xls";
    private static String bridgeModelFilePath = "file/桥梁基本情况表.xls";
    private static String channelModelFilePath = "file/渠道基本情况表.xls";
    private static String culvertModelFilePath = "file/涵洞基本情况表.xls";
    private static String damModelFilePath = "file/塘坝基本情况表.xls";
    private static String deepWellsModelFilePath = "file/深水井基本情况表.xls";
    private static String dripIrrigationPipeModelFilePath = "file/管滴灌基本情况表.xls";
    private static String greateWellsModelFilePath = "file/大口井基本情况表.xls";
    private static String hydropowerModelFilePath = "file/水电站基本情况表";
    private static String pondModelFilePath = "file/水塘基本情况表";
    private static String pumpStationModelFilePath = "file/泵站基本情况表";
    private static String sluiceModelFilePath = "file/水闸基本情况表";
    private static String watercourseModelFilePath = "file/河道基本情况表";
    private static String waterWorksModelFilePath = "file/水厂基本情况表(饮水)";

    public void exportDripIrrigationPipe(WaterConservationEntity waterConservationEntity, HttpServletResponse httpServletResponse) {

    }

    /**
     * 导出深水井
     */
    public void exportDeepWells(WaterConservationEntity waterConservationEntity, HttpServletResponse httpServletResponse) throws IOException {
        DeepWellsEntity deepWellsEntity = waterConservationEntity.getProjectMark().getDeepWells();
        InputStream inputStream = new FileInputStream(new File(deepWellsModelFilePath));
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet1 = hssfWorkbook.getSheetAt(0);
        for (int i = 0; i < 7; i++) {
            HSSFRow row = sheet1.getRow(i);
            switch (i) {
                case 0:
                    HSSFCell cell1_1 = row.getCell(0);
                    cell1_1.setCellValue("编码：" + waterConservationEntity.getCode()
                            + "                街道/乡/镇: " + waterConservationEntity.getTown().getName()
                            + "  村: " + waterConservationEntity.getVillage().getName()
                            + "  组: " + waterConservationEntity.getGroup().getName());
                    break;
                case 2:
                    HSSFCell cell3_2 = row.getCell(1);
                    cell3_2.setCellValue(waterConservationEntity.getName());
                    HSSFCell cell3_4 = row.getCell(3);
                    cell3_4.setCellValue(deepWellsEntity.getIrrigateArea());
                    HSSFCell cell3_6 = row.getCell(5);
                    cell3_6.setCellValue(deepWellsEntity.getDeepPump());
                    break;
                case 3:
                    HSSFCell cell4_2 = row.getCell(1);
                    cell4_2.setCellValue(deepWellsEntity.getDiameter());
                    HSSFCell cell4_4 = row.getCell(3);
                    cell4_4.setCellValue(deepWellsEntity.getDepth());
                    HSSFCell cell4_6 = row.getCell(5);
                    cell4_6.setCellValue(deepWellsEntity.getMaterial());
                    break;
                case 4:
                    HSSFCell cell5_2 = row.getCell(1);
                    cell5_2.setCellValue(waterConservationEntity.getConstructUnit());
                    HSSFCell cell5_4 = row.getCell(3);
                    cell5_4.setCellValue(waterConservationEntity.getConstructTime());
                    HSSFCell cell5_6 = row.getCell(5);
                    cell5_6.setCellValue("经度:" + waterConservationEntity.getLocation().getLongitude() + "\n"
                            + "纬度：" + waterConservationEntity.getLocation().getLatitude());
                    break;
                case 5:
                    HSSFCell cell6_2 = row.getCell(1);
                    cell6_2.setCellValue(waterConservationEntity.getPropertyOwner());
                    HSSFCell cell6_4 = row.getCell(3);
                    cell6_4.setCellValue(waterConservationEntity.getManageModel());
                    HSSFCell cell6_6 = row.getCell(5);
                    cell6_6.setCellValue(waterConservationEntity.getManager());
                    break;
                case 6:
                    HSSFCell cell7_2 = row.getCell(1);
                    cell7_2.setCellValue(waterConservationEntity.getRemark());
                    break;
                default:
                    break;
            }
        }
        writeOut(httpServletResponse, hssfWorkbook);
    }


    /**
     * 导出塘坝
     */
    public void exportDam(WaterConservationEntity waterConservationEntity, HttpServletResponse httpServletResponse) throws IOException {
        DamEntity damEntity = waterConservationEntity.getProjectMark().getDam();
        InputStream inputStream = new FileInputStream(new File(damModelFilePath));
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet1 = hssfWorkbook.getSheetAt(0);
        for (int i = 0; i < 21; i++) {
            HSSFRow row = sheet1.getRow(i);
            HSSFCell cell = row.getCell(1);
            switch (i) {
                case 0:
                    cell = row.getCell(0);
                    cell.setCellValue("编码：" + waterConservationEntity.getCode()
                            + "                街道/乡/镇: " + waterConservationEntity.getTown().getName()
                            + "  村: " + waterConservationEntity.getVillage().getName()
                            + "  组: " + waterConservationEntity.getGroup().getName());
                    break;
                case 2:
                    cell.setCellValue(waterConservationEntity.getName());
                    break;
                case 3:
                    cell.setCellValue("经度:" + waterConservationEntity.getLocation().getLongitude() + "\n"
                            + "纬度：" + waterConservationEntity.getLocation().getLatitude());
                    break;
                case 4:
                    cell.setCellValue(damEntity.getIsRegistered());
                    break;
                case 5:
                    cell.setCellValue(damEntity.getFeatures());
                    break;
                case 6:
                    cell.setCellValue(damEntity.getMainFunctions());
                    break;
                case 7:
                    cell.setCellValue(damEntity.getIsAccountability());
                    break;
                case 8:
                    cell.setCellValue(damEntity.getFeeResources());
                    break;
                case 9:
                    cell.setCellValue(damEntity.getMaintainPersonFee());
                    break;
                case 10:
                    cell.setCellValue(damEntity.getIsCertificated());
                    break;
                case 11:
                    cell.setCellValue(waterConservationEntity.getSituation());
                    break;
                case 12:
                    cell.setCellValue(waterConservationEntity.getPropertyOwner());
                    break;
                case 13:
                    cell.setCellValue(waterConservationEntity.getManager());
                    break;
                case 14:
                    cell.setCellValue(damEntity.getDevelopment());
                    break;
                case 15:
                    cell.setCellValue(damEntity.getManageRageLine());
                    break;
                case 16:
                    cell.setCellValue(damEntity.getPondDamManageRageLine());
                    break;
                case 17:
                    cell.setCellValue(damEntity.getProtectRageManagement());
                    break;
                case 18:
                    cell.setCellValue(damEntity.getProtectGround());
                    break;
                case 19:
                    cell.setCellValue(damEntity.getTwoLinesBuilding());
                    break;
                case 20:
                    cell.setCellValue(damEntity.getSpecifiedMange());
                    break;
                default:
                    break;
            }
        }
        writeOut(httpServletResponse, hssfWorkbook);
    }


    /**
     * 导出涵洞
     */
    public void exportCulvert(WaterConservationEntity waterConservationEntity, HttpServletResponse httpServletResponse) throws IOException {
        CulvertEntity culvertEntity = waterConservationEntity.getProjectMark().getCulvert();
        InputStream inputStream = new FileInputStream(new File(culvertModelFilePath));
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet1 = hssfWorkbook.getSheetAt(0);
        HSSFRow row1 = sheet1.getRow(0);
        HSSFCell cell1_1 = row1.getCell(0);
        cell1_1.setCellValue("编码：" + waterConservationEntity.getCode()
                + "                街道/乡/镇: " + waterConservationEntity.getTown().getName()
                + "  村: " + waterConservationEntity.getVillage().getName()
                + "  组: " + waterConservationEntity.getGroup().getName());
        HSSFRow row3 = sheet1.getRow(2);
        HSSFCell cell3_2 = row3.getCell(1);
        cell3_2.setCellValue(waterConservationEntity.getName());
        HSSFCell cell3_4 = row3.getCell(3);
        cell3_4.setCellValue(culvertEntity.getWatercourseLocation());
        HSSFCell cell3_6 = row3.getCell(5);
        cell3_6.setCellValue(culvertEntity.getCulvertModel());
        HSSFRow row4 = sheet1.getRow(3);
        HSSFCell cell4_2 = row4.getCell(1);
        cell4_2.setCellValue(culvertEntity.getSectionSize());
        HSSFCell cell4_4 = row4.getCell(3);
        cell4_4.setCellValue(culvertEntity.getLength());
        HSSFCell cell4_6 = row4.getCell(5);
        cell4_6.setCellValue(culvertEntity.getHoleModel());
        HSSFRow row5 = sheet1.getRow(4);
        HSSFCell cell5_2 = row5.getCell(1);
        cell5_2.setCellValue(culvertEntity.getDoorMaterial());
        HSSFCell cell5_4 = row5.getCell(3);
        cell5_4.setCellValue(culvertEntity.getHoistModel());
        HSSFCell cell5_6 = row5.getCell(5);
        cell5_6.setCellValue(culvertEntity.getHoleMaterial());
        HSSFRow row6 = sheet1.getRow(5);
        HSSFCell cell6_2 = row6.getCell(1);
        cell6_2.setCellValue(waterConservationEntity.getConstructUnit());
        HSSFCell cell6_4 = row6.getCell(3);
        cell6_4.setCellValue(waterConservationEntity.getConstructTime());
        HSSFCell cell6_6 = row6.getCell(5);
        cell6_6.setCellValue("经度:" + waterConservationEntity.getLocation().getLongitude() + "\n"
                + "纬度：" + waterConservationEntity.getLocation().getLatitude());
        HSSFRow row7 = sheet1.getRow(6);
        HSSFCell cell7_2 = row7.getCell(1);
        cell7_2.setCellValue(waterConservationEntity.getPropertyOwner());
        HSSFCell cell7_4 = row7.getCell(3);
        cell7_4.setCellValue(waterConservationEntity.getManageModel());
        HSSFCell cell7_6 = row7.getCell(5);
        cell7_6.setCellValue(waterConservationEntity.getManager());
        HSSFRow row8 = sheet1.getRow(7);
        HSSFCell cell8_2 = row8.getCell(1);
        cell8_2.setCellValue(waterConservationEntity.getSituation());
        HSSFCell cell8_4 = row8.getCell(3);
        cell8_4.setCellValue(waterConservationEntity.getRemark());
        writeOut(httpServletResponse, hssfWorkbook);
    }

    /**
     * 导出渠道
     */
    public void exportChannel(WaterConservationEntity waterConservationEntity, HttpServletResponse httpServletResponse) throws IOException {
        ChannelEntity channelEntity = waterConservationEntity.getProjectMark().getChannel();
        InputStream inputStream = new FileInputStream(new File(channelModelFilePath));
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet1 = hssfWorkbook.getSheetAt(0);
        HSSFRow row1 = sheet1.getRow(0);
        HSSFCell cell1_1 = row1.getCell(0);
        cell1_1.setCellValue("编码：" + waterConservationEntity.getCode()
                + "                街道/乡/镇: " + waterConservationEntity.getTown().getName()
                + "  村: " + waterConservationEntity.getVillage().getName()
                + "  组: " + waterConservationEntity.getGroup().getName());
        HSSFRow row3 = sheet1.getRow(2);
        HSSFCell cell3_2 = row3.getCell(1);
        cell3_2.setCellValue(channelEntity.getHeadOrPumpStation());
        HSSFCell cell3_4 = row3.getCell(3);
        cell3_4.setCellValue(channelEntity.getBuildingMatchRate());
        HSSFCell cell3_6 = row3.getCell(5);
        cell3_6.setCellValue(waterConservationEntity.getConstructUnit());
        HSSFRow row4 = sheet1.getRow(3);
        HSSFCell cell4_2 = row4.getCell(1);
        cell4_2.setCellValue(channelEntity.getLength());
        HSSFCell cell4_4 = row4.getCell(3);
        cell4_4.setCellValue(channelEntity.getGoodConditionRate());
        HSSFCell cell4_6 = row4.getCell(5);
        cell4_6.setCellValue(waterConservationEntity.getConstructTime());
        HSSFRow row5 = sheet1.getRow(4);
        HSSFCell cell5_2 = row5.getCell(1);
        cell5_2.setCellValue(waterConservationEntity.getPropertyOwner());
        HSSFCell cell5_4 = row5.getCell(3);
        cell5_4.setCellValue(waterConservationEntity.getManageModel());
        HSSFCell cell5_6 = row5.getCell(5);
        cell5_6.setCellValue(waterConservationEntity.getManager());
        List<CanalEntity> canals = channelEntity.getCanals();
        for (CanalEntity canal : canals) {
            int i = 1;
            int rowNum = 6;
            HSSFRow row = sheet1.getRow(rowNum);
            for (int j = 0; j < 6; j++) {
                HSSFCell cell = row.getCell(j);
                switch (j) {
                    case 0:
                        cell.setCellValue(canal.getModel());
                        break;
                    case 1:
                        cell.setCellValue(canal.getLength());
                        break;
                    case 2:
                        cell.setCellValue(canal.getSectionSize());
                        break;
                    case 3:
                        cell.setCellValue(canal.getSeepageCanalLength());
                        break;
                    case 4:
                        cell.setCellValue(canal.getLiningSectionSize());
                        break;
                    case 5:
                        cell.setCellValue(canal.getLiningMaterial());
                        break;
                    default:
                        break;
                }
                i++;
                if (0 == i % 2) {
                    rowNum++;
                    HSSFRow hssfRow = sheet1.getRow(rowNum);
                    HSSFCell hssfCell = hssfRow.getCell(0);
                    hssfCell.setCellValue(".");
                }
                rowNum++;
            }
        }
        HSSFRow row19 = sheet1.getRow(18);
        HSSFCell cell19_2 = row19.getCell(1);
        cell19_2.setCellValue(channelEntity.getSumLength());
        HSSFCell cell19_3 = row19.getCell(2);
        cell19_3.setCellValue(channelEntity.getSumSectionSize());
        HSSFCell cell19_4 = row19.getCell(3);
        cell19_4.setCellValue(channelEntity.getSumSeepageCanalLength());
        HSSFCell cell19_5 = row19.getCell(4);
        cell19_5.setCellValue(channelEntity.getSumLiningSectionSize());
        HSSFRow row20 = sheet1.getRow(19);
        HSSFCell cell20_2 = row20.getCell(1);
        cell20_2.setCellValue(waterConservationEntity.getRemark());
        writeOut(httpServletResponse, hssfWorkbook);
    }

    /**
     * 导出桥梁
     */
    public void exportBridge(WaterConservationEntity waterConservationEntity, HttpServletResponse httpServletResponse) throws IOException {
        BridgeEntity bridgeEntity = waterConservationEntity.getProjectMark().getBridge();
        InputStream inputStream = new FileInputStream(new File(bridgeModelFilePath));
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet1 = hssfWorkbook.getSheetAt(0);
        HSSFRow row1 = sheet1.getRow(0);
        HSSFCell cell1_1 = row1.getCell(0);
        cell1_1.setCellValue("编码：" + waterConservationEntity.getCode()
                + "                街道/乡/镇: " + waterConservationEntity.getTown().getName()
                + "  村: " + waterConservationEntity.getVillage().getName()
                + "  组: " + waterConservationEntity.getGroup().getName());
        HSSFRow row3 = sheet1.getRow(2);
        HSSFCell cell3_2 = row3.getCell(1);
        cell3_2.setCellValue(waterConservationEntity.getName());
        HSSFCell cell3_4 = row3.getCell(3);
        cell3_4.setCellValue(bridgeEntity.getWatercourseLocation());
        HSSFCell cell3_6 = row3.getCell(5);
        cell3_6.setCellValue(bridgeEntity.getCrossCount());
        HSSFRow row4 = sheet1.getRow(3);
        HSSFCell cell4_2 = row4.getCell(1);
        cell4_2.setCellValue(bridgeEntity.getStructureAndMaterial());
        HSSFCell cell4_4 = row4.getCell(3);
        cell4_4.setCellValue(bridgeEntity.getLoadStandard());
        HSSFCell cell4_6 = row4.getCell(5);
        cell4_6.setCellValue(bridgeEntity.getCrossLength());
        HSSFRow row5 = sheet1.getRow(4);
        HSSFCell cell5_2 = row5.getCell(1);
        cell5_2.setCellValue(bridgeEntity.getWidth());
        HSSFCell cell5_4 = row5.getCell(3);
        cell5_4.setCellValue(bridgeEntity.getLength());
        HSSFCell cell5_6 = row5.getCell(5);
        cell5_6.setCellValue(waterConservationEntity.getSituation());
        HSSFRow row6 = sheet1.getRow(5);
        HSSFCell cell6_2 = row6.getCell(1);
        cell6_2.setCellValue(waterConservationEntity.getConstructUnit());
        HSSFCell cell6_4 = row6.getCell(3);
        cell6_4.setCellValue(waterConservationEntity.getConstructTime());
        HSSFCell cell6_6 = row6.getCell(5);
        cell6_6.setCellValue("经度:" + waterConservationEntity.getLocation().getLongitude() + "\n"
                + "纬度：" + waterConservationEntity.getLocation().getLatitude());
        HSSFRow row7 = sheet1.getRow(6);
        HSSFCell cell7_2 = row7.getCell(1);
        cell7_2.setCellValue(waterConservationEntity.getPropertyOwner());
        HSSFCell cell7_4 = row7.getCell(3);
        cell7_4.setCellValue(waterConservationEntity.getManageModel());
        HSSFCell cell7_6 = row7.getCell(5);
        cell7_6.setCellValue(waterConservationEntity.getManager());
        HSSFRow row8 = sheet1.getRow(7);
        HSSFCell cell8_2 = row8.getCell(1);
        cell8_2.setCellValue(waterConservationEntity.getRemark());
        writeOut(httpServletResponse, hssfWorkbook);
    }

    /**
     * 导出渡槽
     */
    public void exportAqueduct(WaterConservationEntity waterConservationEntity, HttpServletResponse httpServletResponse) throws IOException {
        AqueductEntity aqueductEntity = waterConservationEntity.getProjectMark().getAqueduct();
        InputStream inputStream = new FileInputStream(new File(aqueductModelFilePath));
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet1 = hssfWorkbook.getSheetAt(0);
        HSSFRow row1 = sheet1.getRow(0);
        HSSFCell cell1_1 = row1.getCell(0);
        cell1_1.setCellValue("编码：" + waterConservationEntity.getCode()
                + "                街道/乡/镇: " + waterConservationEntity.getTown().getName()
                + "  村: " + waterConservationEntity.getVillage().getName()
                + "  组: " + waterConservationEntity.getGroup().getName());
        HSSFRow row3 = sheet1.getRow(2);
        HSSFCell cell3_2 = row3.getCell(1);
        cell3_2.setCellValue(waterConservationEntity.getName());
        HSSFCell cell3_4 = row3.getCell(3);
        cell3_4.setCellValue(aqueductEntity.getCrossWatercourseLocation());
        HSSFCell cell3_6 = row3.getCell(5);
        cell3_6.setCellValue(aqueductEntity.getCrossCount());
        HSSFRow row4 = sheet1.getRow(3);
        HSSFCell cell4_2 = row4.getCell(1);
        cell4_2.setCellValue(aqueductEntity.getSectionSize());
        HSSFCell cell4_4 = row4.getCell(3);
        cell4_4.setCellValue(aqueductEntity.getStructureAndMaterial());
        HSSFCell cell4_6 = row4.getCell(5);
        cell4_6.setCellValue(aqueductEntity.getCrossLength());
        HSSFRow row5 = sheet1.getRow(4);
        HSSFCell cell5_2 = row5.getCell(1);
        cell5_2.setCellValue(waterConservationEntity.getConstructUnit());
        HSSFCell cell5_4 = row5.getCell(3);
        cell5_4.setCellValue(waterConservationEntity.getConstructTime());
        HSSFCell cell5_6 = row5.getCell(5);
        cell5_6.setCellValue("经度:" + waterConservationEntity.getLocation().getLongitude() + "\n"
                + "纬度：" + waterConservationEntity.getLocation().getLatitude());
        HSSFRow row6 = sheet1.getRow(5);
        HSSFCell cell6_2 = row6.getCell(1);
        cell6_2.setCellValue(waterConservationEntity.getPropertyOwner());
        HSSFCell cell6_4 = row6.getCell(3);
        cell6_4.setCellValue(waterConservationEntity.getManageModel());
        HSSFCell cell6_6 = row6.getCell(5);
        cell6_6.setCellValue(waterConservationEntity.getManager());
        HSSFRow row7 = sheet1.getRow(6);
        HSSFCell cell7_2 = row7.getCell(1);
        cell7_2.setCellValue(waterConservationEntity.getRemark());
        writeOut(httpServletResponse, hssfWorkbook);
    }

    private void writeOut(HttpServletResponse httpServletResponse, HSSFWorkbook hssfWorkbook) {
        try {
            OutputStream outputStream = httpServletResponse.getOutputStream();
            httpServletResponse.setContentType("application/vnd.ms-excel");
            httpServletResponse.setHeader("Content-disposition",
                    "attachment;filename=ducao_" + System.currentTimeMillis() + ".xls");
            httpServletResponse.setHeader("Cache-Control", "public");//HTTP 1.1
            httpServletResponse.setDateHeader("Expires", System.currentTimeMillis() + 10 * 24 * 60 * 60 * 1000000);   //在代理服务器端防止缓冲, nanoseconds
            httpServletResponse.setDateHeader("max-age", System.currentTimeMillis() + 10 * 24 * 60 * 60 * 1000000);
            hssfWorkbook.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
