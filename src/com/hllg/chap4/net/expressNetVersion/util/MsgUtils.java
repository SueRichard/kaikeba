package com.hllg.chap4.net.expressNetVersion.util;

import com.hllg.chap4.net.expressNetVersion.entity.Express;

import java.io.*;
import java.net.Socket;
import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/07  Sun  21:38
 * 抽象出需要发送接受的方法等待调用
 */
public class MsgUtils {
    /**
     * 命令常量
     */
    public static final String CMD_ADD = "CMD_ADD";
    public static final String CMD_DELETE = "CMD_DELETE";
    public static final String CMD_UPDATE = "CMD_UPDATE";
    public static final String CMD_QUERY_ALL = "CMD_QUERY_ALL";
    public static final String CMD_SIZE = "CMD_SIZE";//暂未使用，验证在添加方法里包含了
    public static final String CMD_PICK = "CMD_PICK";
    public static final String CMD_CHECK_FULL = "CMD_CHECK_FULL";
    public static final String CMD_FIND_NUMBER = "CMD_FIND_NUMBER";

    private MsgUtils() {
        //不需要实例化
    }

    /**
     * 发送一个命令
     *
     * @param socket
     * @param cmd
     * @throws IOException
     */
    public static void sendCmd(Socket socket, String cmd) throws IOException {
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(cmd);
    }

    /**
     * 接受命令
     *
     * @param socket
     * @return
     * @throws IOException
     */
    public static String receiveCmd(Socket socket) throws IOException {
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        return dis.readUTF();
    }

    /**
     * 发送一个字符串
     *
     * @param socket
     * @param string
     * @throws IOException
     */
    public static void sendString(Socket socket, String string) throws IOException {
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(string);
    }

    /**
     * 接受一个字符串
     *
     * @param socket
     * @return
     * @throws IOException
     */
    public static String receiveString(Socket socket) throws IOException {
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        return dis.readUTF();
    }

    /**
     * 发送一个express实体
     *
     * @param socket
     * @param express
     * @throws IOException
     */
    public static void sendExpress(Socket socket, Express express) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(express);
    }

    /**
     * 接受一个express实体
     *
     * @param socket
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Express receiveExpress(Socket socket) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        return (Express) ois.readObject();
    }

    /**
     * 发送一个布尔值
     *
     * @param socket
     * @param flag
     * @throws IOException
     */
    public static void sendBoolean(Socket socket, boolean flag) throws IOException {
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeBoolean(flag);
    }

    /**
     * 接受一个布尔值
     *
     * @param socket
     * @return
     * @throws IOException
     */
    public static boolean receiveBoolean(Socket socket) throws IOException {
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        return dis.readBoolean();
    }

    /**
     * 发送一个整数
     *
     * @param socket
     * @param i
     * @throws IOException
     */
    public static void sendInt(Socket socket, int i) throws IOException {
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeInt(i);
    }

    /**
     * 接受一个整数
     *
     * @param socket
     * @return
     * @throws IOException
     */
    public static int receiveInt(Socket socket) throws IOException {
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        return dis.readInt();
    }

    /**
     * 接受一个集合，指定为express的
     *
     * @param socket
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static List<Express> receiveList(Socket socket) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        return (List<Express>) ois.readObject();
    }

    /**
     * 发送一个集合，指定为express
     *
     * @param socket
     * @param list
     * @throws IOException
     */
    public static void sendList(Socket socket, List<Express> list) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(list);
    }
}
