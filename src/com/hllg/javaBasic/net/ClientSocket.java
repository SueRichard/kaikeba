package com.hllg.javaBasic.net;

import java.io.*;
import java.net.Socket;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/05  Fri  14:35
 */
public class ClientSocket {
    public static void main(String[] args) throws IOException {
        //注意交替执行
        //客户端
        Socket socket = new Socket("localhost", 19797);
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String msg = br.readLine();
        System.out.println("来自服务器的消息：" + msg);
        //向服务器传送消息
        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        ps.println("你在干嘛？");
    }
}
