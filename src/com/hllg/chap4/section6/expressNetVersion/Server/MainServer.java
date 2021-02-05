package com.hllg.chap4.section6.expressNetVersion.Server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/05  Fri  15:59
 */
public class MainServer {
    public static void main(String[] args) throws IOException {
        int count = 0;
        ServerSocket server = new ServerSocket(19797);
        System.out.println("服务器启动完毕");
        //写到服务器那里？
        while (true) {
            Socket socket = server.accept();
            System.out.println("已连接一台客户端。");
            count++;
            new Thread("服务器线程："+count) {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+"启动完成");
                        OutputStream os = socket.getOutputStream();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
