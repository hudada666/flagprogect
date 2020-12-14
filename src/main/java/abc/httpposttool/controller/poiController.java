package abc.httpposttool.controller;

import abc.httpposttool.commonutils.HttpClientUtil;
import abc.httpposttool.poiUtil.PoiUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class poiController {

    @RequestMapping("/poiTest")
    public void poiTest() {
        PoiUtil poiUtil = new PoiUtil();
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        String filePath = "D:\\intefaceTest.xlsx";
        try {
            //一个excel数据是一个List
            List<Map<String, String>> excelData = poiUtil.analyzeDemo(filePath);
            for (int i = 0; i < excelData.size(); i++) {
                //一个sheet页是List中的一个Map
                Map<String, String> sheetData = excelData.get(i);
                System.out.println(sheetData);
                //获取map中的键值，后面组装数据用
                /*for (Entry<String, String> vo : sheetData.entrySet()) {
                    System.out.println(vo.getKey() + "：" + vo.getValue());
                }*/
                System.out.println(excelData.get(i).get("url"));
                System.out.println(excelData.get(i).get("message"));
            }

            //接口返回
            List<String> returnMessage = new ArrayList<>();

            for (int interfaceNum = 0; interfaceNum < excelData.size(); interfaceNum++) {
                String interfaceReturn = httpClientUtil.postRequest(excelData.get(interfaceNum).get("url"),excelData.get(interfaceNum));
                returnMessage.add(interfaceReturn);
            }

            poiUtil.exportExcel(excelData, returnMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
