package com.sxt;

import java.io.File;
import java.io.IOException;

/**
 * 创建目录
 * mkdir()确保上级目录存在，不存在则创建失败
 * mkdirs()上级目录可以不存在，不存在会被一同创建
 * @author fly
 * @date 2019/7/1
 */
public class Demo02 {
    public static void main(String[] args) throws IOException {
        String src = "IO_Study\\src" +
                "\\com\\sxt\\dir";
        File f = new File(src);
        File[] subNames = f.listFiles();
        File[] roots = f.listRoots();
        for (File root : roots) {
            System.out.println(root.getPath());
        }
    }

}
