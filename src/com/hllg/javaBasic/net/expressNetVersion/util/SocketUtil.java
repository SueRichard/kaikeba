package com.hllg.javaBasic.net.expressNetVersion.util;

import com.hllg.javaBasic.net.expressNetVersion.entity.Express;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/05  Fri  20:18
 */
public class SocketUtil {
    private static Socket socket;

    static {
        try {
            socket = new Socket("localhost", 19797);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SocketUtil() throws IOException {
    }

    public static List<Express> loadDate() {
        List<Express> list = Collections.synchronizedList(new ArrayList<>());

        try {
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String data = br.readLine();
            String[] all = data.split(" ");
            String[] specify = {};
            if (all.length > 1) {
                for (String s : all) {
                    specify = s.split(",");
                    Express e = new Express(specify[0], specify[1], Integer.parseInt(specify[2]), Integer.parseInt(specify[3]));
                    list.add(e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void submitDate(List<Express> list) {
        try {
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            StringBuffer data = new StringBuffer();
            for (Express e : list) {
                data.append(e.getNum()).append(",").append(e.getCompany()).append(",").append(e.getCode()).append(",").append(e.getLocation()).append(" ");
            }
            pw.println(data);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
