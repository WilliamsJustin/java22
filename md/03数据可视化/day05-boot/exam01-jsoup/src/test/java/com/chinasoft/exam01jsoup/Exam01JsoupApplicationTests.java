package com.chinasoft.exam01jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;

@SpringBootTest
class Exam01JsoupApplicationTests {

    @Test
    void getStockData() {
        String url = "http://www.baidu.com/";
        try {
            // 得到和设置 connection 对象
            Connection conn = Jsoup.connect(url)
                    .method(Connection.Method.GET)
                    .ignoreContentType(true);

            // 执行请求
            Connection.Response response = conn.execute();

            // 判断请求是否成功
            if (response.statusCode() == 200) {
                // 显示 contentType
                // 响应对象的输入流， 流就是 图片的字节
                String html = new String(response.bodyAsBytes(), "utf-8");
                // 读 bis的内容 到 buff里面， 然后将buff内容写入 fos
                System.out.println(html);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
