package abc.httpposttool.transaction;

import abc.httpposttool.compnents.ACompnent;
import abc.httpposttool.compnents.BCompnent;
import abc.httpposttool.compnents.CCompnent;
import abc.httpposttool.compnents.DCompnent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class T1 {

    Logger logger = LoggerFactory.getLogger("T1");

    @Autowired
    ACompnent aCompnent;
    @Autowired
    BCompnent bCompnent;
    @Autowired
    CCompnent cCompnent;
    @Autowired
    DCompnent dCompnent;
    String flag;
    String response;
    public Map<String,Object>  compFlow(Map<String,Object> dataContant) {

        Set it = ((Map<String,String>)dataContant.get("appenMap")).keySet();
        if(it.contains("A")){
            flag = (aCompnent.compFlow(dataContant)).get("flag").toString();
        }

        if(flag == "0" ){
            if(it.contains("B")){
                flag = (bCompnent.compFlow(dataContant)).get("flag").toString();
            }
        }else{
            response = "6666";
        }


        if(flag == "0" ){
            if(it.contains("C")){
                flag = (cCompnent.compFlow(dataContant)).get("flag").toString();
            }
        }else{
            response = "6666";
        }

        if(flag == "0" ){
            if(it.contains("D")){
                flag = (dCompnent.compFlow(dataContant)).get("flag").toString();
            }
        }else{
            response = "6666";
        }

        if(flag == "0" ){
            response = "0000";
        }else{
            response = "6666";
        }

        dataContant.put("responseCode", response);

        return dataContant;
    }
}
