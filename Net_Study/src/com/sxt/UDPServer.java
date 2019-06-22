package com.sxt;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author fly
 * @date 2019/5/30
 */
public class UDPServer {
    public static void main(String[] args) throws Exception {
        System.out.println("接收方启动中...");
        //1.使用DatagramSocket指定端口，创建接收端。
        DatagramSocket server = new DatagramSocket(9999);
        //2.准备容器，封装成DatagramPacket包裹。
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        //3.阻塞式接收包裹。receive(DatagramPacket p)
        server.receive(packet);
        //4.分析数据
        byte[] data = packet.getData();
        System.out.println(new String(data,0,packet.getLength()));
        //5.释放资源
        server.close();
    }
}
