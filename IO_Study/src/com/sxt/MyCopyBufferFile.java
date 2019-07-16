package com.sxt;

import java.io.*;

/**
 * 文件中转(字节缓冲流)BufferedInputStream/BufferedOutputStream
 * try-with-resourses
 * @author fly
 * @date 2019/7/16
 */
public class MyCopyBufferFile {
    public static void myCopy(String srcPath,String destPath){
        //try-with-resourse,声明放在try的括号内
        try(InputStream is = new BufferedInputStream(new FileInputStream(srcPath));
            OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath))) {
            byte[] flush = new byte[1024];  //缓冲容器
            int len = -1;                   //接收长度
            while ((len=is.read(flush)) != -1){
                os.write(flush,0,len);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        myCopy("ccc.mp4","ccc_copy.mp4");
    }
}
