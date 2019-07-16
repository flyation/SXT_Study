package com.sxt;

import java.io.*;

/**
 * 字节数组输入流
 * 分段读取
 * 流操作步骤:
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源：不需要
 * @author fly
 * @date 2019/7/15
 */
public class Demo09 {
    public static void main(String[] args){
        //1.创建源
        String str = "talk is cheap,";

        //2.选择流
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(str.getBytes());

            //3.操作
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len=is.read(flush)) != -1){
                String s = new String(flush);
                System.out.println(s);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
