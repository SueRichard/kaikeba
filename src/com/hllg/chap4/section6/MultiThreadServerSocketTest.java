package com.hllg.chap4.section6;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/05  Fri  15:22
 */
public class MultiThreadServerSocketTest {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(19797);
        System.out.println("服务器启动完成");
        while (true) {
            Socket socket = server.accept();
            System.out.println("一个客户端连接");
            new Thread() {
                @Override
                public void run() {
                    try {
                        OutputStream os = socket.getOutputStream();
                        PrintWriter pw = new PrintWriter(os);
                        pw.println("你好呀，这是你要的数据。");
                        pw.flush();
                        pw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
