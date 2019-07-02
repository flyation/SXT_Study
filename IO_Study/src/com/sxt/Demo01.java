package com.sxt;

import java.io.File;
import java.io.IOException;

/**
 * 创建文件
 * @author fly
 * @date 2019/7/1
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        String src = "IO_Study\\src" +
                "\\com\\sxt\\0.png";
        File f = new File(src);
        System.out.println(f.getName());
        System.out.println(f.getPath());
        System.out.println(f.length());
        boolean b = f.createNewFile();
        System.out.println(b);
    }

}
