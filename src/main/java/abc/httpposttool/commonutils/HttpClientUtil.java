package abc.httpposttool.commonutils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import abc.httpposttool.entity.ExcelEntity;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;


/**
 * auth:huzhonglin
 * data:2020.12.13
 */
@Component("httpClientUtil")
public class HttpClientUtil {


    public ExcelEntity postRequest(ExcelEntity entity) throws java.text.ParseException {
        //获取url
        String url = entity.getUrl();
        //uniqueld:年月日时分秒+6位随机数
        Map<String,String> appendMap1 = new LinkedHashMap<String,String>();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
        String data = format.format(new Date()).trim();
        int randomData = ((int)((Math.random()*9+1)*100000));
        entity.getPubInfoPre().put("uniqueld",data + randomData);

        //此处封装json数据
        JSONObject jsonDataPre = JSONObject.fromObject(entity.getPubInfoPre());
        JSONObject jsonDataPrv = JSONObject.fromObject(entity.getPrvInfo());
        JSONObject jsonDataAft = JSONObject.fromObject(entity.getPubInfoAft());
        String jsonStrHead = jsonDataPre.toString();
        String jsonStrPrv = jsonDataPrv.toString();
        String jsonStrTail = jsonDataAft.toString();
        String jsonStrMix = jsonStrHead.substring(0,jsonStrHead.length() - 1) + "," + "\"data\":" + "{" + "\"pets\":" +
                "{" + "\"flowdata\":" + jsonStrPrv + "," + "\"pub\":" + jsonStrTail + "}}}";
        entity.setReqTxt(jsonStrMix);
        JSONObject jsonStrFina=JSONObject.fromObject(jsonStrMix);
        //调用工具类中的方法，传入url以及json数据进行推送
        try {
            String bd = sendPut(url, jsonStrFina, "UTF-8");
            //JSONObject ob = JSONObject.fromObject(bd);; //获取对方返回的数据
            //String ss = ob.getString("data");
            entity.setRespTxt(bd);

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return entity;
    }
    /**
     * HttpClient 推送数据
     *
     * @param url 接口地址
     *       jsonData 传入的参数
     * @return String
     */
    public static String sendPut(String url, JSONObject putData, String encoding) throws ParseException, IOException {
        String result = "";
        //打印了一下我推送的json数据
        System.err.println(putData.toString());
        CloseableHttpResponse response = null;
        CloseableHttpClient client = HttpClients.createDefault();

        //向指定资源位置上传内容
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
        httpPost.setEntity(new StringEntity(putData.toString(), Charset.forName("UTF-8")));
        try {
            response = client.execute(httpPost);
            if(response.getStatusLine().getStatusCode() == 200){
                System.err.println("交易成功" );
                System.err.println("status:" + response.getStatusLine().getStatusCode());
                //通过response中的getEntity()方法获取返回值
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity, encoding);
                }
            }else{
                System.err.println("交易失败" );
                System.err.println("status:" + response.getStatusLine().getStatusCode());
                //通过response中的getEntity()方法获取返回值
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity, encoding);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            httpPost.abort();
            if (response != null) {
                response.close();
            }
            if(client != null){
                client.close();
            }
        }

        System.err.println("result:" + result);
        return result;
    }

}
