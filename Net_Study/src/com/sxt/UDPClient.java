package com.sxt;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author fly
 * @date 2019/5/30
 */
public class UDPClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送方启动中...");
        //1.使用DatagramSocket指定端口，创建发送端。
        DatagramSocket client = new DatagramSocket(8888);
        //2.准备数据，一定转成字节数组。
        String str = "UDP测试";
        byte[] data = str.getBytes();
        //3.封装成DatagramPacket包裹，需要指定目的地。
        DatagramPacket packet = new DatagramPacket(data,0,data.length,
                new InetSocketAddress("localhost",9999));
        //4.发送包裹。send(DatagramPacket p)
        client.send(packet);
        //5.释放资源。
        client.close();
    }
}
