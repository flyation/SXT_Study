package com.sxt;

import java.io.*;

/**
 * 文件字节输出流
 * 流操作步骤:
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author fly
 * @date 2019/7/2
 */
public class Demo06 {
    public static void main(String[] args) {
        //1.创建源
        File f = new File("dest.txt");

        //2.选择流
        OutputStream os = null;
        try {
            os = new FileOutputStream(f,true);

            //3.操作
            String msg = "\tI/O is not difficult\n";
            byte[] datas = msg.getBytes();
            os.write(datas,0,datas.length);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
