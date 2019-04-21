package top.karlo.springbeandemo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;

/**
 * 功能描述：
 *  http请求发送， spring的RestTemplate  apache的HttpClients  hutool
 * @author Karlo
 * @date 2019/4/18 10:02
 */
public class Test1 {
    public static void main(String[] args) {
        httpTest1();

    }

    private static void httpTest1(){
        //apache httpclient工具类，
        HttpClient client = HttpClients.createDefault();
        //创建一个get请求
        HttpGet httpGet = new HttpGet("http://localhost:8080/test");
        //创建一个post请求
        HttpPost httpPost = new HttpPost("http://localhost:8080/test");
        try {
            //发送请求，获取响应
            HttpResponse response = client.execute(httpPost);
            //获取响应状态码
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.printf("返回状态码：%s \n",statusCode);
            //获取响应报文
            HttpEntity entity = response.getEntity();
            //使用工具类处理响应报文 转换成string
            String s = EntityUtils.toString(entity);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void httpTest2(){
        RestTemplate restTemplate = new RestTemplate();
        HttpRequest request = new HttpRequest() {
            @Override
            public HttpHeaders getHeaders() {
                return null;
            }

            @Override
            public String getMethodValue() {
                return null;
            }

            @Override
            public URI getURI() {
                return null;
            }
        };
        TestResponseBody responseBody = restTemplate.postForObject("http://localhost:8080/regist",request, TestResponseBody.class, new HashMap<>());

    }

}

class TestResponseBody{
    private String test;
}
