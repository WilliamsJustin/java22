package com.chinasoft.utils;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author 中软zhang
 * @create 2023-08-08 15:29
 */
public class CheckCodeUtilTest {

    @Test
    public void outputVerifyImage() throws IOException {
        // 生成一个 图片文件
        FileOutputStream fos = new FileOutputStream("d:/tmp/aaa.jpg");
        // 调用 生成校验码的方法
        String code = CheckCodeUtil.outputVerifyImage(100, 50, fos, 4);
        System.out.println(code);
    }
}