package com.sxt;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author fly
 * @date 2019/5/30
 */
public class Spider02 {
    public static void main(String[] args) throws Exception {
        //获取URL
        URL url = new URL("https://www.dianping.com");
        //模拟浏览器访问
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
        //下载资源
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
        String msg = null;
        while (null!=(msg=br.readLine())){
            System.out.println(msg);
        }
        br.close();
    }
}
