package com.hllg.chap4.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/05  Fri  15:23
 */
public class MultiThreadSocketTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 19797);
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String text = br.readLine();
        System.out.println("读取到服务器的数据：" + text);
    }
}
