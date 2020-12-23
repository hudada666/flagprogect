package abc.httpposttool.poiUtil;

import abc.httpposttool.entity.ComponentDetails;
import abc.httpposttool.entity.FlagDetails;
import abc.httpposttool.entity.TransactionDetails;
import abc.httpposttool.service.ComponentService;
import abc.httpposttool.service.FlagService;
import abc.httpposttool.service.TranService;
import abc.httpposttool.vo.CreateList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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


    public void ingsertList(List list, String tranTime, String compTime, String usingTime){

        for (int i = 0; i < list.size(); i++){
            CreateList createList = (CreateList)list.get(i);
            transactionDetails.setTransactionCode(createList.getTransactionCode());
            transactionDetails.setTransactionTime(tranTime);
            transactionDetails.setTransactionStuts(createList.getResponseCode());
            componentDetails.setComponentCode(createList.getComponentCode());
            componentDetails.setTransactionCode(createList.getTransactionCode());
            componentDetails.setComponentStuts(createList.getResponseCode());
            componentDetails.setComponentUseTime(usingTime);
            componentDetails.setComponentTime(compTime);
            flagDetails.setFlagCode(createList.getFlagCode());
            flagDetails.setFlagStuts(createList.getResponseCode());
            flagDetails.setFlagMsg(createList.getFlagMsg());
            flagDetails.setFlagUseTime(createList.getFlagData());
            flagDetails.setComponentCode(createList.getComponentCode());
            flagDetails.setTransactionCode(createList.getTransactionCode());

            componentService.tx(componentDetails);
            transactionService.tx(transactionDetails);
            flagService.tx(flagDetails);

        }

    }

}
