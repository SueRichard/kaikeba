package com.hllg.chap4.section6.expressNetVersion.Client;

import com.hllg.chap4.section6.expressNetVersion.entity.Express;
import com.hllg.chap4.section6.expressNetVersion.util.MsgUtils;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/08  Mon  07:44
 * 所有的方法都交给服务器调用，只收取服务端的结果
 */
public class ExpressClient {
    private Socket socket;

    public ExpressClient() {
        try {
            socket = new Socket("localhost", 19799);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeSocket() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isFull() throws IOException {
        MsgUtils.sendCmd(socket, MsgUtils.CMD_CHECK_FULL);
        return MsgUtils.receiveBoolean(socket);
    }

    /**
     * 客户端不直接添加，向服务器发送指令，让服务器添加
     *
     * @param e
     * @return
     */
    public Express addExpress(Express e) throws IOException, ClassNotFoundException {
        MsgUtils.sendCmd(socket, MsgUtils.CMD_ADD);
        MsgUtils.sendExpress(socket, e);
        return MsgUtils.receiveExpress(socket);
    }

    public Express findByNum(String oldNum) throws IOException, ClassNotFoundException {
        MsgUtils.sendCmd(socket, MsgUtils.CMD_FIND_NUMBER);
        MsgUtils.sendString(socket, oldNum);
        return MsgUtils.receiveExpress(socket);
    }

    public Express update(Express oldExpress,Express newExpress) throws IOException, ClassNotFoundException {
        MsgUtils.sendCmd(socket, MsgUtils.CMD_UPDATE);
        MsgUtils.sendExpress(socket,oldExpress);
        MsgUtils.sendExpress(socket, newExpress);
        return MsgUtils.receiveExpress(socket);
    }

    public boolean delete(String num) throws IOException {
        MsgUtils.sendCmd(socket, MsgUtils.CMD_DELETE);
        MsgUtils.sendString(socket,num);
        return MsgUtils.receiveBoolean(socket);
    }

    public List<Express> query() throws IOException, ClassNotFoundException {
        MsgUtils.sendCmd(socket, MsgUtils.CMD_QUERY_ALL);
        return MsgUtils.receiveList(socket);
    }

    public boolean pickExpress(int code) throws IOException {
        MsgUtils.sendCmd(socket, MsgUtils.CMD_PICK);
        MsgUtils.sendInt(socket,code);
        return MsgUtils.receiveBoolean(socket);
    }
}
