package abc.httpposttool.poiUtil;

import abc.httpposttool.entity.ComponentDetails;
import abc.httpposttool.entity.FlagDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class CommomUtil {

    @Autowired
    FlagDetails createList;


    public Map<String,Object> addMethoe(Map<String,Object> dataContant, String compCode,
                                        String data, String flagCode, String msg){
        List resultList = (List) dataContant.get("resultList");
        createList = new FlagDetails();
        createList.setTransactionCode(dataContant.get("strnCode").toString());
        createList.setComponentCode(compCode);
        createList.setFlagUseTime(data);
        createList.setFlagMsg(msg);
        createList.setFlagStuts("");
        createList.setFlagCode(flagCode);


        resultList.add(createList);
        dataContant.put("resultList", resultList);

        return dataContant;
    }


}
