package com.sxt;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.net.URL;

/**
 * 数据流
 * @author fly
 * @date 2019/7/16
 */
public class DataTest {
    public static void main(String[] args) throws IOException {
        //写出
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
        //操作数据类型+数据
        dos.writeUTF("数据流");
        dos.writeInt(123456);
        dos.writeChar('c');
        dos.writeBoolean(true);
        dos.flush();
        byte[] datas = baos.toByteArray();

        //读入
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        //按顺序读
        String d1 = dis.readUTF();
        int d2 = dis.readInt();
        char d3 = dis.readChar();
        boolean d4 = dis.readBoolean();

        System.out.println(d2);
    }
}
