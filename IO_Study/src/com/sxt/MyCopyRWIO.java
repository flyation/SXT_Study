package com.sxt;

import java.io.*;

/**
 * 文件中转(文件字符输入输出流)
 * 流操作步骤:
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author fly
 * @date 2019/7/15
 */
public class MyCopyRWIO {
    public static void myCopy(String srcPath,String destPath){
        //1.创建源
        File src = new File(srcPath);
        File dest = new File(destPath);

        //2.选择流
        Reader rd = null;
        Writer wt = null;
        try {
            rd = new FileReader(src);
            wt = new FileWriter(dest);

            //3.操作(分段读取)
            char[] flush = new char[1024];  //缓冲容器
            int len = -1;                   //接收长度
            while ((len=rd.read(flush)) != -1){
                wt.write(flush);
            }
            wt.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放(分别关闭,先打开的后关闭)
            try {
                if (wt != null) {
                    wt.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (rd != null) {
                    rd.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        myCopy("5.png","t2.txt");
    }
}
