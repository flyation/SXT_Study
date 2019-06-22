package com.fly;

import java.io.File;

/**
 * @program: av47103781p123
 * @description: 采用递归打印目录树
 * @author: fly
 * @create: 2019-05-20 10:02
 **/
public class PrintFileTree {
    public static void main(String[] args) {
        File file = new File("E:\\TestDemo");
        printFileTree(file,0);
    }

    public static String reExt(File file,String extName){
        StringBuilder orgName = new StringBuilder(file.getAbsolutePath());
        System.out.println("#file.getAbsolutePath(): "+file.getAbsolutePath());
        int index = orgName.lastIndexOf(".");
        int length = orgName.length();
        orgName.delete(index+1,length);
        orgName.append(extName);
        String newName = new String(orgName);
        System.out.println("#newName: "+newName);
        return newName;
    }

    public static void printFileTree(File file, int level){
        if (file.isFile()){
//            file.renameTo(new File(reExt(file,"xyz")));
            System.out.println("#renameTo:"+file.getAbsolutePath());
        }
        for (int i=0;i<level;i++){
            System.out.print("*");
        }
        System.out.println(file.getName());
        if (file.isDirectory()){
           File[] files = file.listFiles();
           for (File tmp:files){
               printFileTree(tmp,level+1);
           }
        }
    }
}