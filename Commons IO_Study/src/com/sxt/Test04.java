package com.sxt;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 写出内容
 * @author fly
 * @date 2019/7/17
 */
public class Test04 {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) throws IOException {
        String string="writestringtofile\n";

        FileUtils.writeStringToFile(new File("writeLines.txt"),string,"UTF-8",true);

        FileUtils.writeByteArrayToFile(new File("writeLines.txt"),string.getBytes("UTF-8"),true);


        List<String> list = Arrays.asList("aa","bb","cc","dd");
        FileUtils.writeLines(new File("writeLines.txt"),list,true);

    }
}




