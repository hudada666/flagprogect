package abc.httpposttool.compnents;

import abc.httpposttool.entity.ComponentDetails;
import abc.httpposttool.poiUtil.CommomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class BCompnent {

    @Autowired
    CommomUtil commomUtil;
    @Autowired
    ComponentDetails componentDetails;

    Logger logger = LoggerFactory.getLogger("BCompnent");
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    Map<String,String> appenMap = null;
    List compresultList = new LinkedList();

    public Map<String,Object> compFlow(Map<String,Object> dataContant) {
        long timeBegin=System.currentTimeMillis();
        appenMap = (Map<String, String>) dataContant.get("appenMap");
        compresultList = (List) dataContant.get("compresultList");;
        String compData = format.format(new Date());
        String flagCode = appenMap.get("B");
        String compCode = "B";
        String compRespose;
        if (appenMap.get(compCode) != null && !"".equals(appenMap.get(compCode))){
            Date data = new Date();
            if (flagCode == "1") {
                String msg = "桩点:交易码：" +  appenMap.get("strnCode") + " 组件：BCompnent" + " 装点信息：" + flagCode;
                logger.info("桩点:交易码：" +  appenMap.get("strnCode") + " 组件：BCompnent" + " 装点信息：" + flagCode);
                dataContant = commomUtil.addMethoe(dataContant, flagCode, data.toString(), compCode, msg);
            }

            if (flagCode == "2") {
                String msg = "桩点:交易码：" +  appenMap.get("strnCode") + " 组件：BCompnent" + " 装点信息：" + flagCode;
                logger.info("桩点:交易码：" +  appenMap.get("strnCode") + " 组件：BCompnent" + " 装点信息：" + flagCode);
                dataContant = commomUtil.addMethoe(dataContant, flagCode, data.toString(), compCode, msg);
            }

            if (flagCode == "3") {
                String msg = "桩点:交易码：" +  appenMap.get("strnCode") + " 组件：BCompnent" + " 装点信息：" + flagCode;
                logger.info("桩点:交易码：" +  appenMap.get("strnCode") + " 组件：BCompnent" + " 装点信息：" + flagCode);
                dataContant = commomUtil.addMethoe(dataContant, flagCode, data.toString(), compCode, msg);
            }

            if (flagCode == "4") {
                String msg = "桩点:交易码：" +  appenMap.get("strnCode") + " 组件：BCompnent" + " 装点信息：" + flagCode;
                logger.info("桩点:交易码：" +  appenMap.get("strnCode") + " 组件：BCompnent" + " 装点信息：" + flagCode);
                dataContant = commomUtil.addMethoe(dataContant, flagCode, data.toString(), compCode, msg);
            }


            if (flagCode == "5") {
                String msg = "桩点:交易码：" +  appenMap.get("strnCode") + " 组件：BCompnent" + " 装点信息：" + flagCode;
                logger.info("桩点:交易码：" +  appenMap.get("strnCode") + " 组件：BCompnent" + " 装点信息：" + flagCode);
                dataContant = commomUtil.addMethoe(dataContant, flagCode, data.toString(), compCode, msg);
            }
        }

        if(compCode == "B"){
            dataContant.put("flag", "0");
            compRespose = "0000";
        }else{
            dataContant.put("flag", "1");
            compRespose = "6666";

        }

        long timeEnd=System.currentTimeMillis();
        String useTime = String.valueOf(timeEnd - timeBegin);
        componentDetails.setComponentTime(compData);
        componentDetails.setComponentUseTime(useTime);
        componentDetails.setComponentStuts(compRespose);

        return dataContant;

    }
}
