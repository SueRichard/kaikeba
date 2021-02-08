package com.hllg.chap4.section6.expressNetVersion.Client;

import com.hllg.chap4.section6.expressNetVersion.entity.Express;
import com.hllg.chap4.section6.expressNetVersion.util.MsgUtil;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/08  Mon  07:44
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
        MsgUtil.sendCmd(socket, MsgUtil.CMD_CHECK_FULL);
        return MsgUtil.receiveBoolean(socket);
    }

    /**
     * 客户端不直接添加，向服务器发送指令，让服务器添加
     *
     * @param e
     * @return
     */
    public Express addExpress(Express e) throws IOException, ClassNotFoundException {
        MsgUtil.sendCmd(socket, MsgUtil.CMD_ADD);
        MsgUtil.sendExpress(socket, e);
        return MsgUtil.receiveExpress(socket);
    }

    public Express findByNum(String oldNum) throws IOException, ClassNotFoundException {
        MsgUtil.sendCmd(socket, MsgUtil.CMD_FIND_NUMBER);
        MsgUtil.sendString(socket, oldNum);
        return MsgUtil.receiveExpress(socket);
    }

    public Express update(Express oldExpress,Express newExpress) throws IOException, ClassNotFoundException {
        MsgUtil.sendCmd(socket, MsgUtil.CMD_UPDATE);
        MsgUtil.sendExpress(socket,oldExpress);
        MsgUtil.sendExpress(socket, newExpress);
        return MsgUtil.receiveExpress(socket);
    }

    public boolean delete(String num) throws IOException {
        MsgUtil.sendCmd(socket,MsgUtil.CMD_DELETE);
        MsgUtil.sendString(socket,num);
        return MsgUtil.receiveBoolean(socket);
    }

    public List<Express> query() throws IOException, ClassNotFoundException {
        MsgUtil.sendCmd(socket,MsgUtil.CMD_QUERY_ALL);
        return MsgUtil.receiveList(socket);
    }

    public boolean pickExpress(int code) throws IOException {
        MsgUtil.sendCmd(socket,MsgUtil.CMD_PICK);
        MsgUtil.sendInt(socket,code);
        return MsgUtil.receiveBoolean(socket);
    }
}
