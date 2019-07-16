package com.sxt;

import java.io.*;

/**
 * 文件中转(文件字节输入输出流)
 * 流操作步骤:
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author fly
 * @date 2019/7/2
 */
public class MyCopyFileIO {
    public static void myCopy(String srcPath,String destPath){
        //1.创建源
        File src = new File(srcPath);
        File dest = new File(destPath);

        //2.选择流
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);

            //3.操作(分段读取)
            byte[] flush = new byte[1024];  //缓冲容器
            int len = -1;                   //接收长度
            while ((len=is.read(flush)) != -1){
                os.write(flush,0,len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放(分别关闭,先打开的后关闭)
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        myCopy("5.png","ttt.png");
    }
}
