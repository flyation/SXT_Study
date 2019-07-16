package com.sxt;

import java.io.*;

/**
 * 文件字节输入流
 * 分段读取
 * 流操作步骤:
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author fly
 * @date 2019/7/2
 */
public class Demo05 {
    public static void main(String[] args) {
        //1.创建源
        File f = new File("abc.txt");

        //2.选择流
        InputStream is = null;
        try {
            is = new FileInputStream(f);

            //3.操作
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len=is.read(flush)) != -1){
                String str = new String(flush,0,len);
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放
            try {
                if (is != null)
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
