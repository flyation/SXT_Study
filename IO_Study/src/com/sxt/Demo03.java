package com.sxt;

import java.io.UnsupportedEncodingException;

/**
 * 编码/解码
 * @author fly
 * @date 2019/7/2
 */
public class Demo03 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "晚上吃啥";
        byte[] bytes = msg.getBytes("gbk");
        System.out.println(bytes.length);
        String s = new String(bytes,"GBK");
        System.out.println(s);
    }

}
