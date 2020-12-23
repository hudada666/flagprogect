package abc.httpposttool.service;

import abc.httpposttool.poiUtil.CommomUtil;
import abc.httpposttool.vo.CreateList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DomeTestService {

    Logger logger = LoggerFactory.getLogger("DomeTestService");
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    @Autowired
    CommomUtil commomUtil;

    public List<CreateList> checkResult(String strOne, String trncode, String comcode, String flagcode) throws Exception{
        String flagData = format.format(new Date());
        String msg = "交易码：" + trncode + "组件ID：" + comcode +  "旗子ID：" + flagcode;
        logger.info(msg);
        logger.info("传入参数" + strOne);
        String returnStr;
        if (strOne == "flag0001") {
            returnStr = "0000";
        }else if(strOne == ""){
            returnStr = "unknow";
        }else{
            returnStr = "6666";
        }
        List<CreateList> list = commomUtil.commonList(trncode, comcode, flagcode, msg, returnStr, flagData);
        return list;
    }

}
