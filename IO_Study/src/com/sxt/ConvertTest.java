package com.sxt;

import java.io.*;
import java.net.URL;

/**
 * 转换流
 * @author fly
 * @date 2019/7/16
 */
public class ConvertTest {
    public static void main(String[] args) {
        try (BufferedReader br =
                     new BufferedReader(
                             new InputStreamReader(
                                     new URL("https://www.baidu.com").openStream(),"UTF-8"));
             BufferedWriter bw =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     new FileOutputStream("baidu.html"),"UTF-8"))){
        String line = null;
        while ((line=br.readLine()) != null){
            bw.write(line);
            bw.newLine();
        }
        bw.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
