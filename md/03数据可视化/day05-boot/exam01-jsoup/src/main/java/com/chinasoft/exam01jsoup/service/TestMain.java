package com.chinasoft.exam01jsoup.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestMain {
    public static void main(String[] args) {
        System.out.println(get("http://api.waizaowang.com/doc/getWatchStockTimeKLine?type=1&code=000001,000002&export=0&token=登录歪枣网上获取token&fields=code,price,tdate"));
    }
 
    public static String get(String strUrl) {
        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.setConnectTimeout(10000);
            conn.setRequestMethod("GET");
            conn.setUseCaches(false);
            conn.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
            conn.disconnect();
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}