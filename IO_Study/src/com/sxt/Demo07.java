package com.sxt;

import java.io.*;

/**
 * 文件字符输入流
 * 分段读取
 * 流操作步骤:
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author fly
 * @date 2019/7/15
 */
public class Demo07 {
    public static void main(String[] args){
        //1.创建源
        File src = new File("abc715.txt");

        //2.选择流
        Reader rd = null;
        try {
            rd = new FileReader(src);

            //3.操作
            char[] flush = new char[1024];
            int len = -1;
            while ((len=rd.read(flush)) != -1){
                System.out.println(flush);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.释放
            if (rd != null){
                try {
                    rd.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
