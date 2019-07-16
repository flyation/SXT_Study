package com.sxt;

import java.io.*;

/**
 * 文件中转(文件字节、字节数组输入输出流)
 * 流操作步骤:
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author fly
 * @date 2019/7/15
 */
public class MyCopyByteArrayIO {
    public static void main(String[] args) {
        byte[] pic = file2ByteArray("3.png");
        System.out.println(pic.length);
        byteArray2File(pic,"3copy.png");
    }

    /**
     * 图片读取到字节数组
     * 图片到程序FileInputStream
     * 程序到字节数组ByteArrayOutputStream
     */
    public static byte[] file2ByteArray(String srcPath) {
        //1.创建源
        File src = new File(srcPath);

        //2.选择流
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            is = new FileInputStream(src);
            baos = new ByteArrayOutputStream();

            //3.操作(分段读取)
            byte[] flush = new byte[1024];  //缓冲容器
            int len = -1;                   //接收长度
            while ((len = is.read(flush)) != -1) {//文件（硬盘）==>程序
                baos.write(flush, 0, len);    //程序==>字节数组（内存）
            }
            baos.flush();
            return baos.toByteArray();
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            try {
                if (is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 字节数组写出到图片
     * 字节数组到程序ByteArrayInputStream
     * 程序到图片FileOutputStream
     */
    public static void byteArray2File(byte[]datas,String destPath) {
        //1.创建源
        File dest = new File(destPath);

        //2.选择流
        ByteArrayInputStream bais = null;
        OutputStream os = null;
        try {
            bais = new ByteArrayInputStream(datas);
            os = new FileOutputStream(dest);

            //3.操作(分段读取)
            byte[] flush = new byte[1024];  //缓冲容器
            int len = -1;                   //接收长度
            while ((len = bais.read(flush)) != -1) {//字节数组（内存）==>程序
                os.write(flush,0,len);          //程序==>文件（硬盘）
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            try {
                if (os != null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
