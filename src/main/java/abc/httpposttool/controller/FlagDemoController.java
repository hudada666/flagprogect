package abc.httpposttool.controller;

import abc.httpposttool.poiUtil.FinalResult;
import abc.httpposttool.service.ExcelService;
import abc.httpposttool.transaction.T1;
import abc.httpposttool.transaction.T2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/TRN0001")
public class FlagDemoController {
    Logger logger = LoggerFactory.getLogger("FlagDemoTest");
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    ExcelService excelService;
    @Autowired
    T1 t1;
    @Autowired
    T2 t2;
    @Autowired
    FinalResult finalResult;
    String trnData;

    @RequestMapping("/comp")
    @ResponseBody
    public void  coverTest(){
        logger.info("FlagDemoController开始执行。。。。。");
        try {
            Map<String,List> getExcelDate = excelService.selectData();
            Map<String,Object> dataContant = new LinkedHashMap<>();
            Map<String,String>  appenMap = new LinkedHashMap<>();
            List<String> compnentList = getExcelDate.get("compList");
            List<String> flagList = getExcelDate.get("flagList");
            List<String> resultList = new LinkedList<>();
            List<String> compresultList = new LinkedList<>();
            for (int i = 1; i < compnentList.size(); i++){
                appenMap.put(compnentList.get(i), flagList.get(i - 1));
            }
            String strnCode = compnentList.get(0);
            dataContant.put("strnCode", strnCode);
            dataContant.put("appenMap", appenMap);
            dataContant.put("resultList", resultList);
            dataContant.put("compresultList", compresultList);
            String compData = format.format(new Date());
            if("T1".equals(strnCode)){
                trnData = format.format(new Date());
                dataContant = t1.compFlow(dataContant);
            }

            if (("T2".equals(strnCode))) {
                trnData = format.format(new Date());
                dataContant = t2.compFlowTwo(dataContant);
            }
            dataContant.put("trnData", trnData);
            finalResult.ingsertList(dataContant);
            logger.info("dbTestOne开始结束");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


//    Logger logger = LoggerFactory.getLogger("FlagDemoTest");
//    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    String trnData = format.format(new Date());
//    @Autowired
//    DomeTestService domeTestService;
//    @Autowired
//    FinalResult finalResult;
//
//    @RequestMapping("/dbone/{trncode}/{comcode}/{flagcode}")
//    @ResponseBody
//    public String dbTestOne(@PathVariable String trncode, @PathVariable String comcode,  @PathVariable String flagcode){
//        logger.info("dbTestOne开始执行");
//        String compData = format.format(new Date());
//        long timeBegin=System.currentTimeMillis();
//        try {
//            List<CreateList> list = domeTestService.checkResult(flagcode, trncode, comcode, flagcode);
//            long timeEnd=System.currentTimeMillis();
//            String useTime = String.valueOf(timeEnd - timeBegin);
//            finalResult.ingsertList(list, trnData, compData, useTime);
//            logger.info("dbTestOne开始结束");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}
