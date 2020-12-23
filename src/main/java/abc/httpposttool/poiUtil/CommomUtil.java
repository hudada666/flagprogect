package abc.httpposttool.poiUtil;

import abc.httpposttool.service.DomeTestService;
import abc.httpposttool.vo.CreateList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class CommomUtil {

    @Autowired
    CreateList createList;

   public List<CreateList>  commonList(String trncode, String comcode,
                                       String flagcode, String msg, String resCode, String flagData){
       //定义list，存放每次经过的装点信息
       List<CreateList> list = new LinkedList();

       createList.setTransactionCode(trncode);
       createList.setComponentCode(comcode);
       createList.setFlagCode(flagcode);
       createList.setFlagMsg(msg);
       createList.setResponseCode(resCode);
       createList.setFlagData(flagData);
       list.add(createList);

       return list;
   }

}
