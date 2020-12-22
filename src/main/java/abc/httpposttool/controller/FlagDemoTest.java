package abc.httpposttool.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/trn")
public class FlagDemoTest {

    Logger logger = LoggerFactory.getLogger("FlagDemoTest");

    @RequestMapping("/dbone")
    @ResponseBody
    public String dbTestOne(){
        logger.info("dbTestOne旗子开始执行");
        //旗子信息
        String msg;

        tranService.getQuery(1);
        logger.info("dbTestOne旗子开始结束");
        return null;
    }

    @RequestMapping("/dbtwo")
    @ResponseBody
    public String dbTestTwo(){
        logger.info("dbTestTwo旗子开始执行");
        ompService.getQuery(1);
        logger.info("dbTestTwo旗子开始执行");
        return null;
    }

    @RequestMapping("/dbthree")
    @ResponseBody
    public String dbTestThree(){
        logger.info("dbTestThree旗子开始执行");
        flagService.getQuery(1);
        logger.info("dbTestThree旗子开始执行");
        return null;
    }

    @RequestMapping("/dbfour")
    @ResponseBody
    public String dbTestFour(){
        logger.info("dbTestFour旗子开始执行");
        flagService.getQuery(1);
        logger.info("dbTestFour旗子开始执行");
        return null;
    }

    @RequestMapping("/dbfive")
    @ResponseBody
    public String dbTestFour(){
        logger.info("dbTestFive旗子开始执行");
        flagService.getQuery(1);
        logger.info("dbTestFive旗子开始执行");
        return null;
    }

}
