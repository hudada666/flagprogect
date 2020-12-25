package abc.httpposttool.poiUtil;

import abc.httpposttool.entity.ComponentDetails;
import abc.httpposttool.entity.FlagDetails;
import abc.httpposttool.entity.TransactionDetails;
import abc.httpposttool.service.ComponentService;
import abc.httpposttool.service.FlagService;
import abc.httpposttool.service.TranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class FinalResult {

    @Autowired
    TransactionDetails transactionDetails;
    @Autowired
    ComponentDetails componentDetails;
    @Autowired
    FlagDetails flagDetails;
    @Autowired
    ComponentService componentService;
    @Autowired
    TranService transactionService;
    @Autowired
    FlagService flagService;


    public void ingsertList(Map<String,Object> dataContant){

        List resultList = (List) dataContant.get("resultList");
        List compresultList = (List) dataContant.get("compresultList");
        for (int i = 0; i < resultList.size(); i++){
            flagDetails = (FlagDetails) resultList.get(i);
            componentDetails = (ComponentDetails) compresultList.get(i);
            transactionDetails.setTransactionCode(dataContant.get("strnCode").toString());
            transactionDetails.setTransactionTime(dataContant.get("trnData").toString());
            transactionDetails.setTransactionStuts(dataContant.get("responseCode").toString());
            componentDetails.setComponentCode(flagDetails.getComponentCode());
            componentDetails.setTransactionCode(flagDetails.getTransactionCode());
            componentDetails.setComponentStuts(componentDetails.getComponentStuts());
            componentDetails.setComponentUseTime(componentDetails.getComponentUseTime());
            componentDetails.setComponentTime(componentDetails.getComponentTime());
            flagDetails.setFlagCode(flagDetails.getFlagCode());
            flagDetails.setFlagStuts("");
            flagDetails.setFlagMsg(flagDetails.getFlagMsg());
            flagDetails.setFlagUseTime(flagDetails.getFlagUseTime());
            flagDetails.setComponentCode(flagDetails.getComponentCode());
            flagDetails.setTransactionCode(flagDetails.getTransactionCode());
            if(dataContant.get("responseCode").toString() != null && !"".equals(dataContant.get("responseCode").toString())){
                flagService.tx(flagDetails);
                if(componentDetails.getComponentStuts() != null &&
                        !"".equals(componentDetails.getComponentStuts())){
                    componentService.tx(componentDetails);
                }
            }

        }

        if(dataContant.get("responseCode").toString() != null && !"".equals(dataContant.get("responseCode").toString())){
            transactionDetails.setTransactionCode(dataContant.get("strnCode").toString());
            transactionDetails.setTransactionTime(dataContant.get("trnData").toString());
            transactionDetails.setTransactionStuts(dataContant.get("responseCode").toString());
            transactionService.tx(transactionDetails);
        }


    }

}
