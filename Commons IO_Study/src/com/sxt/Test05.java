package com.sxt;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * 拷贝
 * @author fly
 * @date 2019/7/17
 */
public class Test05 {
    public static void main(String[] args) throws IOException {
        //拷贝文件
//        FileUtils.copyFile(new File("3.png"),new File("33.png"));
        //拷贝文件到目录
//        FileUtils.copyFileToDirectory(new File("3.png"),new File("raf2"));
        //拷贝目录到目录
//        FileUtils.copyDirectoryToDirectory(new File("raf2"),new File("raf2"));
        //拷贝目录
//        FileUtils.copyDirectory(new File("raf2\\raf2"),new File("raf2"));
        //拷贝URL
//        FileUtils.copyURLToFile(
//                new URL("https://i1.hdslb.com/bfs/face/0bbf84a2bca94ddf4f7ebcd38a0e5a8282a5cfdc.jpg@68w_68h.webp"),
//                new File("jiji.png"));

        String baidu = IOUtils.toString(new URL("https://www.baidu.com/"),"UTF-8");
        System.out.println(baidu);
    }
}




