package com.sxt;

import java.io.*;

/**
 * 打印流PrintStream、PrintWriter
 * @author fly
 * @date 2019/7/16
 */
public class PrintTest {
    public static void main(String[] args) throws IOException {
        //PrintStream
        PrintStream psout = System.out;
        psout.println("123456");

        PrintStream ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("ps.txt")),true);
        ps.println("enter");
        ps.println("打印流PrintStream");

        //重定向输出端
        System.setOut(ps);
        System.out.println("setOut changed!");

        //重定向回控制台
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
        System.out.println("setOut back!");

        ps.close();

        //PrintWriter
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pw.txt")),true);
        pw.println("enter");
        pw.println("打印流PrintWriter");
    }
}
