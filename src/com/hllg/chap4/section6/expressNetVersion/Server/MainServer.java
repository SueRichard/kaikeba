package com.hllg.chap4.section6.expressNetVersion.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/05  Fri  15:59
 */
public class MainServer {
    private static final String LOCATION = "src/com/hllg/chap4/section6/expressNetVersion/data.txt";

    public static void main(String[] args) throws IOException {
        int count = 0;
        ServerSocket server = new ServerSocket(19797);
        System.out.println("服务器启动完毕");
        //写到服务器那里？
        while (true) {
            Socket socket = server.accept();
            System.out.println("已连接一台客户端。");
            count++;
            new Thread("服务器线程：" + count) {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "启动完成");
                        OutputStream os = socket.getOutputStream();
                        BufferedReader br = new BufferedReader(new FileReader(LOCATION));
                        StringBuffer result = new StringBuffer();
                        while(true){
                            String temp = br.readLine();
                            if (temp==null){
                                break;
                            }
                            result.append(temp);
                        }
                        PrintWriter pw = new PrintWriter(os);
                        pw.println(result);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
