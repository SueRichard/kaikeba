package com.hllg.javaBasic.net.expressNetVersion.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/08  Mon  07:31
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(19799);
        System.out.println("服务器启动成功");
        while (true) {
            Socket accept = socket.accept();
            new Thread(new ExpressRunnable(accept)).start();
        }
    }
}
