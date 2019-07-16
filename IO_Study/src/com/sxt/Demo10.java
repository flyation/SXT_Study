package com.sxt;

import java.io.*;

/**
 * 字节数组输出流
 * 流操作步骤:
 * 1.创建源:内部维护
 * 2.选择流:不关联源
 * 3.操作
 * 4.释放资源:不需要
 * @author fly
 * @date 2019/7/15
 */
public class Demo10 {
    public static void main(String[] args) {
        //1.创建源
        byte[] dest = null;

        //2.选择流()新增方法
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();

            //3.操作
            String str = "show me the code.";
            byte[] datas = str.getBytes();
            baos.write(datas);
            baos.flush();

            dest = baos.toByteArray();//新增的方法：获取数据
            System.out.println(new String(dest,0,baos.size())+"==>"+dest.length);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
