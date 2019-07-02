package com.sxt;

import java.io.File;

/**
 * 统计文件目录大小（对象方法）
 * @author fly
 * @date 2019/7/1
 */
public class CountTree {
    private File file;
    public long length;

    public CountTree(String path) {
        this.file = new File(path);
        this.countTree(file);
    }

    public void countTree(File f){
        if (f!=null && f.exists()){    //递归头
            if (f.isFile()){
                length += f.length();
            }else if (f.isDirectory()){
                for (File file : f.listFiles()) {   //递归体
                    countTree(file);
                }
            }
        }
    }

    public static void main(String[] args) {
        String path = "GoF23_Study";
        CountTree dir = new CountTree(path);
        System.out.println(dir.length);
    }
}

