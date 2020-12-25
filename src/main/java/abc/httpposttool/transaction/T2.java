package abc.httpposttool.transaction;

import abc.httpposttool.compnents.ACompnent;
import abc.httpposttool.compnents.BCompnent;
import abc.httpposttool.compnents.CCompnent;
import abc.httpposttool.compnents.DCompnent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class T2 {
    Logger logger = LoggerFactory.getLogger("T2");

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
    public Map<String,Object> compFlowTwo(Map<String,Object> dataContant){

        Set set = ((Map<String,String>)dataContant.get("appenMap")).keySet();
        if(set.contains("A")){
            flag = (String) (aCompnent.compFlow(dataContant)).get("flag");
        }

        if(flag == "0" ){
            if(set.contains("B")){
                flag = (String) (bCompnent.compFlow(dataContant)).get("flag");
            }
        }else{
            response = "6666";
        }


        if(flag == "0" ){
            if(set.contains("C")){
                flag = (String) (cCompnent.compFlow(dataContant)).get("flag");
            }
        }else{
            response = "6666";
        }

        if(flag == "0" ){
            if(set.contains("D")){
                flag = (String) (dCompnent.compFlow(dataContant)).get("flag");
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
