package com.sxt;

import java.io.File;

/**
 * 打印文件目录（静态方法）
 * @author fly
 * @date 2019/7/1
 */
public class PrintTree {
    public static void printTree(File f, int deep){
        for (int i = 0; i < deep; i++) {
            System.out.print("*");
        }
        System.out.println(f.getName());
        if (f==null || !f.exists()){    //递归头
            return;
        }else if (f.isDirectory()){
            for (File file : f.listFiles()) {   //递归体
                printTree(file,deep+1);
            }
        }
    }

    public static void main(String[] args) {
        File f = new File("Collection_Study");
        printTree(f,0);
    }
}

