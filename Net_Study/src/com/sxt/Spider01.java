package com.sxt;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author fly
 * @date 2019/5/30
 */
public class Spider01 {
    public static void main(String[] args) throws Exception {
        //获取URL
        URL url = new URL("https://www.jd.com");
        //下载资源
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        String msg = null;
        while (null!=(msg=br.readLine())){
            System.out.println(msg);
        }
        br.close();
    }
}
