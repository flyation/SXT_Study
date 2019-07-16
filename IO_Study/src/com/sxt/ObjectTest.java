package com.sxt;

import java.io.*;

/**
 * 数据流
 * 需实现Serializable
 * @author fly
 * @date 2019/7/16
 */
public class ObjectTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //写出
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("xuliehua.ser")));
        //序列化
        oos.writeUTF("数据流");
        oos.writeInt(123456);
        oos.writeChar('c');
        oos.writeBoolean(true);
        oos.writeObject(new Employee("fly",19,3000));
        oos.flush();
        oos.close();

        //读入
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("xuliehua.ser")));
        //反序列化
        String o1 = ois.readUTF();
        int o2 = ois.readInt();
        char o3 = ois.readChar();
        boolean o4 = ois.readBoolean();
        Object o5 = ois.readObject();
        ois.close();

        System.out.println(o1);
        if (o5 instanceof Employee){
            Employee emp = (Employee)o5;
            System.out.println(emp);
        }
    }
}
