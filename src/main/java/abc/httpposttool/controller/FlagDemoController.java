package abc.httpposttool.controller;

import abc.httpposttool.entity.ComponentDetails;
import abc.httpposttool.entity.FlagDetails;
import abc.httpposttool.entity.TransactionDetails;
import abc.httpposttool.poiUtil.FinalResult;
import abc.httpposttool.service.DomeTestService;
import abc.httpposttool.vo.CreateList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/TRN0001")
public class FlagDemoController {

    Logger logger = LoggerFactory.getLogger("FlagDemoTest");
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String trnData = format.format(new Date());
    @Autowired
    DomeTestService domeTestService;
    @Autowired
    FinalResult finalResult;

    @RequestMapping("/dbone/{trncode}/{comcode}/{flagcode}")
    @ResponseBody
    public String dbTestOne(@PathVariable String trncode, @PathVariable String comcode,  @PathVariable String flagcode){
        logger.info("dbTestOne开始执行");
        String compData = format.format(new Date());
        long timeBegin=System.currentTimeMillis();
        try {
            List<CreateList> list = domeTestService.checkResult(flagcode, trncode, comcode, flagcode);
            long timeEnd=System.currentTimeMillis();
            String useTime = String.valueOf(timeEnd - timeBegin);
            finalResult.ingsertList(list, trnData, compData, useTime);
            logger.info("dbTestOne开始结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    @RequestMapping("/dbtwo/{trncode}/{comcode}/{flagcode}")
//    @ResponseBody
//    public String dbTestTwo(@PathVariable String trncode, @PathVariable String comcode,  @PathVariable String flagcode){
//        logger.info("dbTestOne开始执行");
//        Date begindata = new Date();
//        try {
//            List<CreateList> list = domeTestService.checkResult("A", trncode, comcode, flagcode);
//            Date enddata = new Date();
//            logger.info("dbTestOne开始结束");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}
