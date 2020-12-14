package abc.httpposttool.commonutils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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

import javax.xml.crypto.Data;

/**
 * auth:huzhonglin
 * data:2020.12.13
 */
@Component("httpClientUtil")
public class HttpClientUtil {


    public String postRequest(String url, Map<String, String> param) throws java.text.ParseException {
        param.remove("1");
        Map<String,String> appendMap1 = new LinkedHashMap<String,String>();
        appendMap1.put("cityCode","19");
        appendMap1.put("channelCode","11");
        appendMap1.put("msgType","01");
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
        String data = format.format(new Date()).trim();
        int randomData = ((int)((Math.random()*9+1)*100000));
        appendMap1.put("uniqueld",data + randomData);
        param.remove("url");
        param.put("termid","190002s5Y");
        param.put("boeorgid","192994");
        param.put("opname","韩朦");
        param.put("opid","190002AO9");
        appendMap1.putAll(param);
        System.err.println(appendMap1.toString());
        //此处封装json数据
        JSONObject jsonData = JSONObject.fromObject(appendMap1); ;
        //调用工具类中的方法，传入url以及json数据进行推送
        try {
            String bd = sendPut(url, jsonData, "UTF-8");
            //JSONObject ob = JSONObject.fromObject(bd);; //获取对方返回的数据
            //String ss = ob.getString("data");
            return bd;

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return url;
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
        System.err.println(putData.toString());//打印了一下我推送的json数据
        CloseableHttpResponse response = null;
        CloseableHttpClient client = HttpClients.createDefault();

        //向指定资源位置上传内容
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
        httpPost.setEntity(new StringEntity(putData.toString(), Charset.forName("UTF-8")));
        try {
            response = client.execute(httpPost);
            System.err.println("status" + response.getStatusLine().getStatusCode());

            //通过response中的getEntity()方法获取返回值
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity, encoding);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            httpPost.abort();
            if (response != null) {
                EntityUtils.consumeQuietly(response.getEntity());
            }
        }

        System.err.println("result:" + result);
        return result;
    }

}
