package com.hllg.chap4.section6.expressNetVersion.util;

import com.hllg.chap4.section6.expressNetVersion.entity.Express;

import java.io.*;
import java.net.Socket;
import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/07  Sun  21:38
 */
public class MsgUtil {
    //命令
    public static final String CMD_ADD = "CMD_ADD";
    public static final String CMD_DELETE = "CMD_DELETE";
    public static final String CMD_UPDATE = "CMD_UPDATE";
    public static final String CMD_QUERY_ALL = "CMD_QUERY_ALL";
    public static final String CMD_SIZE = "CMD_SIZE";
    public static final String CMD_PICK = "CMD_PICK";
    public static final String CMD_CHECK_FULL = "CMD_CHECK_FULL";
    public static final String CMD_FIND_NUMBER = "CMD_FIND_NUMBER";

    //不需要实例化
    private MsgUtil() {
    }

    public static void sendCmd(Socket socket, String cmd) throws IOException {
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(cmd);
    }

    public static String receiveCmd(Socket socket) throws IOException {
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        return dis.readUTF();
    }

    public static void sendString(Socket socket, String string) throws IOException {
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(string);
    }

    public static String receiveString(Socket socket) throws IOException {
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        return dis.readUTF();
    }

    public static void sendExpress(Socket socket, Express express) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(express);
    }

    public static Express receiveExpress(Socket socket) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        return (Express) ois.readObject();
    }

    public static void sendBoolean(Socket socket, boolean flag) throws IOException {
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeBoolean(flag);
    }

    public static boolean receiveBoolean(Socket socket) throws IOException {
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        return dis.readBoolean();
    }

    public static void sendInt(Socket socket, int i) throws IOException {
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeInt(i);
    }

    public static int receiveInt(Socket socket) throws IOException {
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        return dis.readInt();
    }

    public static List<Express> receiveList(Socket socket) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        return (List<Express>) ois.readObject();
    }

    public static void sendList(Socket socket, List<Express> list) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(list);
    }
}
