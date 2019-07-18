package com.sxt;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 读取内容
 * @author fly
 * @date 2019/7/17
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        String string = FileUtils.readFileToString(new File("孔乙己.txt"),"UTF-8");
//        System.out.println(kyj);

        byte[] bytes = FileUtils.readFileToByteArray(new File("孔乙己.txt"));
//        System.out.println(bytes.length);

        List<String> list = FileUtils.readLines(new File("孔乙己.txt"),"UTF-8");
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        LineIterator lineIterator = FileUtils.lineIterator(new File("孔乙己.txt"),"UTF-8");
        while (lineIterator.hasNext()){
            System.out.println(lineIterator.nextLine());
        }
    }
}
