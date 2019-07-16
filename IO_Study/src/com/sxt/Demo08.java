package com.sxt;

import java.io.*;

/**
 * 文件字符输出流
 * 流操作步骤:
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author fly
 * @date 2019/7/15
 */
public class Demo08 {
    public static void main(String[] args) {
        //1.创建源
        File dest = new File("tt.txt");

        //2.选择流
        Writer wt = null;
        try {
            wt = new FileWriter(dest,true);

            //3.操作
            String msg = "\tI/O is not difficult\n添加中文\n";
            char[] datas = msg.toCharArray();
            wt.write(datas);
            wt.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放
            try {
                if (wt != null) {
                    wt.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
