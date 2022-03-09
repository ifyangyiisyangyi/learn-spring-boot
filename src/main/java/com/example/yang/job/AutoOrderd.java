package com.example.yang.job;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;

@Slf4j
public class AutoOrderd {
    public String Authorization = this.setAuthorization();

    /**
     * 获取token
     * @return
     */
    public String setAuthorization() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\t\"email\": \"117645743@qq.com\",\n\t\"password\": \"a12345678\"\n}");
        Request request = new Request.Builder()
                .url("https://dev-api.infwaves.com/v0.1/user/login?g-app-version=1.0.2&g-platform=android&g_os_version=1.0.12&g_device_id=4dfc6f833aa285e5&g_device_model=NOH-AN00&g_device_brand=HUAWEI&g_signal=wifi&cou=US&lan=EN&cur=USD&tz=GMT+08:00")
                .method("POST", body)
                .addHeader("Cookie", "temp_user_id=1637229444-5350-8961-2140")
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject jsonObject = JSON.parseObject(response.body().string());
            String Authorization = jsonObject.getJSONObject("data").get("token_type").toString() + " " +  jsonObject.getJSONObject("data").get("access_token").toString();
            return Authorization;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * 创建订单
     */
    public String placeOrder() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n    \"device_type\": 4,\n    \"coupon_code\": \"\",\n    \"pay_type\": 3,\n    \"email\": \"117645743@qq.com\",\n    \"shipping_method\": 1,\n    \"store_id\": \"1\",\n    \"product_list\": [\n        {\n            \"spu_id\": \"6786018836688\",\n            \"quantity\": 1,\n            \"sku_id\": \"Test 10012107299628 7777\"\n        }\n    ],\n    \"shipping_address\": {\n        \"city_name\": \"Abbeville\",\n        \"country_id\": 233,\n        \"state_id\": 1456,\n        \"country_name\": \"United States\",\n        \"phone_number\": \"1234567890\",\n        \"other_info\": \"\",\n        \"zip_code\": \"20001\",\n        \"address_id\": 319,\n        \"state_name\": \"Alabama\",\n        \"city_id\": 110968,\n        \"address_line1\": \"Susanna\",\n        \"first_name\": \"you\",\n        \"phone_code\": \"1\",\n        \"is_default\": 1,\n        \"last_name\": \"Skis\",\n        \"address_line2\": \"Abandon\",\n        \"country_code\": \"US\",\n        \"state_code\": \"AL\"\n    }\n}");
        Request request = new Request.Builder()
                .url("https://dev-api.infwaves.com/v0.3/order/create_order?cou=US&cur=USD&g_app_version=1.2.0&g_device_brand=iPhone&g_device_id=A036EE8A-7382-4913-8A95-2515653A8340&g_device_model=iPhone8,4&g_os_version=14.4.2&g_platform=ios&g_signal=wifi&lan=EN&tz=GMT+8")
                .method("POST", body)
                .addHeader("Host", "dev-api.infwaves.com")
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "temp_user_id=1645683487914-3556-7428-4D40")
                .addHeader("User-Agent", "Commense/1.2.0 (com.infwaves.commense; build:8; iOS 14.4.2) Alamofire/5.4.4")
                .addHeader("Authorization", this.Authorization)
                .addHeader("Accept-Language", "zh-Hans-CN;q=1.0, en-CN;q=0.9")
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject jsonObject = JSON.parseObject(response.body().string());
            String orderId = jsonObject.getJSONObject("data").get("order_id").toString();
            if(response.isSuccessful()){
                log.info("下单成功，订单号是：" + orderId);
            }
            return orderId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取支付信息
     */
    public String getPayInfo() throws IOException {
        String order_id = placeOrder();
        String payId = "";
        Boolean mark = true;
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://dev-api.infwaves.com/v0.2/pay/get_pay_info?pay_type=2&order_id=" + order_id + "&cou=US&cur=USD&g_app_version=1.0.18&g_device_brand=iPhone&g_device_id=A036EE8A-7382-4913-8A95-2515653A8340&g_device_model=iPhone8,4&g_os_version=14.4.2&g_platform=ios&g_signal=wifi&lan=EN&tz=GMT+8")
                .method("GET", null)
                .addHeader("Authorization", Authorization)
                .addHeader("Cookie", "temp_user_id=1640574927821-5DFB-59E9-4BE7")
                .addHeader("User-Agent", "EasyShop/1.0.16 (com.infwaves.commense; build:112; iOS 14.4.2) Alamofire/5.4.4")
                .build();
        while (mark){
            Response response = client.newCall(request).execute();
            JSONObject jsonObject = JSON.parseObject(response.body().string());
            if (jsonObject.getJSONObject("data").get("pay_channel").toString() == "3") {
                mark = false;
            }
            payId = jsonObject.getJSONObject("data").get("pay_id").toString();
            log.info("支付单号:" + payId);
            return payId;
        }
        return null;
    }

    /**
     * 生成cko token
     */
    public String getCkoToken() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n    \"type\": \"card\",\n    \"number\": \"4485141520544212\",\n    \"expiry_month\": 2,\n    \"expiry_year\": 2025,\n    \"cvv\": \"100\"\n}");
        Request request = new Request.Builder()
                .url("https://api.sandbox.checkout.com/tokens")
                .method("POST", body)
                .addHeader("Authorization", "pk_test_ae2e5251-3ef0-4585-bfe6-86020c44efca")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        JSONObject jsonObject = JSON.parseObject(response.body().string());
        String token = jsonObject.getString("token");
        return token;
    }

    /**
     * 支付
     */
    public void pay() throws IOException{
        String pay_id = getPayInfo();
        String token = getCkoToken();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n    \"pay_id\": \"" + pay_id + "\",\n    \"cko_token\": \"" + token + "\"\n}");
        Request request = new Request.Builder()
                .url("https://dev-api.infwaves.com/v0.2/pay/cko_checkout?g-app-version=1.0.2&g-platform=android&g_os_version=1.0.12&g_device_id=4dfc6f833aa285e5&g_device_model=NOH-AN00&g_device_brand=HUAWEI&g_signal=wifi&cou=US&lan=EN&cur=USD&tz=GMT+08:00")
                .method("POST", body)
                .addHeader("Authorization", "Bearer ZDA2YJRLOGYTYTKXMC0ZYME5LTLHNTKTZWQ2ZTAZMTZHYMQW")
                .addHeader("Cookie", "temp_user_id=1637229444-5350-8961-2140")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            cko_review(pay_id);
        }
    }

    /**
     * 3ds处理
     */
    public void cko_review(String pay_id) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n    \"pay_id\": \"" + pay_id + "\",\n    \"cko_3ds_res\": 1,\n    \"cko_sid\": \"sid_xica6w4roiweroiijhphty4n54\"\n}");
        Request request = new Request.Builder()
                .url("https://dev-api.infwaves.com/v0.2/pay/cko_retrieve?g-app-version=1.0.2&g-platform=android&g_os_version=1.0.12&g_device_id=4dfc6f833aa285e5&g_device_model=NOH-AN00&g_device_brand=HUAWEI&g_signal=wifi&cou=US&lan=EN&cur=USD&tz=GMT+08:00")
                .method("POST", body)
                .addHeader("Authorization", Authorization)
                .addHeader("Cookie", "temp_user_id=1637229444-5350-8961-2140")
                .addHeader("g-app-version", "1.0.2")
                .addHeader("g-platform", "android")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        log.info(response.body().string());
    }

}
