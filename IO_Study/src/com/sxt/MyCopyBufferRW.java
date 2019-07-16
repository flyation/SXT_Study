package com.sxt;

import java.io.*;

/**
 * 文件中转(字符缓冲流)BufferedReader/BufferedWriter
 * try-with-resourses
 * @author fly
 * @date 2019/7/16
 */
public class MyCopyBufferRW {
    public static void myCopy(String srcPath,String destPath){
        //try-with-resourse,声明放在try的括号内
        try(BufferedReader br = new BufferedReader(new FileReader(srcPath));
            BufferedWriter bw = new BufferedWriter(new FileWriter(destPath))) {
            String line = null;
            while ((line=br.readLine()) != null){
                //逐行写出
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        myCopy("8.txt","8_c.txt");
    }
}
