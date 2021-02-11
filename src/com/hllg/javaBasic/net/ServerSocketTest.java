package com.hllg.javaBasic.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/05  Fri  14:35
 */
public class ServerSocketTest {
    public static void main(String[] args) throws IOException {
        //注意交替执行
        //搭建服务器
        ServerSocket server = new ServerSocket(19797);
        System.out.println("服务器启动");
        //等待客户端的连接
        Socket socket = server.accept();
        System.out.println("一个客户端连接了");
        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        ps.println("欢迎！");
        //接受客户端的消息
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String answer = br.readLine();
        System.out.println("来自客户端的消息："+answer);
    }
}
