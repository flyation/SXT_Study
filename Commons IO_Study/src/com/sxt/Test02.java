package com.sxt;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.util.Collection;

/**
 * 列出子孙级
 * @author fly
 * @date 2019/7/17
 */
public class Test02 {
    public static void main(String[] args) {
        Collection<File> lf = FileUtils.listFiles(new File("Collection_Study"),
                FileFilterUtils.and(new SuffixFileFilter("java"),EmptyFileFilter.NOT_EMPTY),
                DirectoryFileFilter.INSTANCE);
        for (File f : lf) {
            System.out.println(f);
        }

    }
}
