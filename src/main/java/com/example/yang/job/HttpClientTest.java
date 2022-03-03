package com.example.yang.job;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HttpClientTest {
    //    @Scheduled(cron = "0 * * * * *")
    public void test() {
        System.out.println("11111111111");
    }

//    @Scheduled(cron = "* * * * * *")
    /**
     * post请求测试
     */
    public void getList() {
        // 获得http客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建post请求
        HttpPost httpPost = new HttpPost("http://yycode.com.cn:8030/linkage/list");

        // 请求参数
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pageNum", "1");
        jsonObject.put("pageSize", "10");
        StringEntity jsonEntity = new StringEntity(jsonObject.toString(), "UTF-8");
        jsonEntity.setContentType(new BasicHeader("Content-Type", "application/json; charset=utf-8"));
        jsonEntity.setContentEncoding(Consts.UTF_8.name());
        httpPost.setEntity(jsonEntity);

        //响应模型
        CloseableHttpResponse response = null;
        try {
            // 发起请求
            response = httpClient.execute(httpPost);

            // 获取响应实体
            HttpEntity entity = response.getEntity();
            String string = EntityUtils.toString(entity, "utf-8");
            System.out.println(string);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

