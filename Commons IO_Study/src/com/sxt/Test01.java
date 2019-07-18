package com.sxt;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * 统计大小
 * @author fly
 * @date 2019/7/17
 */
public class Test01 {
    public static void main(String[] args) {
        //统计文件大小
        File f = new File("E:\\RRShareDownload\\切尔诺贝利第102季\\切尔诺贝利.Chernobyl.S01E02.中英字幕.WEB.720P-人人影视.mp4");
        long size = FileUtils.sizeOf(f);
        System.out.println("size = " + size);

        //统计目录大小
        f = new File("Collection_Study");
        size = FileUtils.sizeOf(f);
        System.out.println("size = " + size);

    }
}
