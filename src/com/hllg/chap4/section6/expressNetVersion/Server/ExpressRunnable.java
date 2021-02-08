package com.hllg.chap4.section6.expressNetVersion.Server;


import com.hllg.chap4.section6.expressNetVersion.dao.ExpressDao;
import com.hllg.chap4.section6.expressNetVersion.dao.ExpressDaoImpl;
import com.hllg.chap4.section6.expressNetVersion.entity.Express;
import com.hllg.chap4.section6.expressNetVersion.util.MsgUtil;

import java.io.IOException;
import java.net.Socket;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/08  Mon  07:34
 */
public class ExpressRunnable implements Runnable {
    private Socket socket;
    private ExpressDao expressDao = new ExpressDaoImpl();

    public ExpressRunnable(Socket accept) {
        this.socket = accept;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String receiveCmd = MsgUtil.receiveCmd(socket);
                //命令为空退出循环
                if (receiveCmd == null) break;
                switch (receiveCmd) {
                    case MsgUtil.CMD_ADD:
                        addExpress();
                        break;
                    case MsgUtil.CMD_CHECK_FULL:
                        checkFull();
                        break;
                    case MsgUtil.CMD_DELETE:
                        deleteByNum();
                        break;
                    case MsgUtil.CMD_FIND_NUMBER:
                        findByNum();
                        break;
                    case MsgUtil.CMD_UPDATE:
                        updateExpress();
                        break;
                    case MsgUtil.CMD_QUERY_ALL:
                        queryAll();
                        break;
                    case MsgUtil.CMD_PICK:
                        pickExpress();
                        break;
                    default:
                        System.out.println("无此命令");
                }
            } catch (IOException | ClassNotFoundException e) {
                //e.printStackTrace();
                try {
                    //关闭socket
                    socket.close();
                } catch (IOException ioException) {
                    //ioException.printStackTrace();
                    break;
                }
            }
        }
    }

    private void pickExpress() throws IOException {
        int code = MsgUtil.receiveInt(socket);
        MsgUtil.sendBoolean(socket,expressDao.pickExpress(code));
    }

    private void queryAll() throws IOException {
        MsgUtil.sendList(socket, expressDao.query());
    }

    private void updateExpress() throws IOException, ClassNotFoundException {
        Express oldExpress = MsgUtil.receiveExpress(socket);
        Express newExpress = MsgUtil.receiveExpress(socket);
        MsgUtil.sendExpress(socket, expressDao.update(oldExpress, newExpress));
    }

    private void findByNum() throws IOException {
        String num = MsgUtil.receiveString(socket);
        MsgUtil.sendExpress(socket, expressDao.findByNum(num));
    }

    private void deleteByNum() throws IOException {
        String num = MsgUtil.receiveString(socket);
        MsgUtil.sendBoolean(socket, expressDao.delete(num));
    }

    private void checkFull() throws IOException {
        MsgUtil.sendBoolean(socket, expressDao.checkFull());
    }

    private void addExpress() throws IOException, ClassNotFoundException {
        Express express = MsgUtil.receiveExpress(socket);
        Express add = expressDao.add(express);
        MsgUtil.sendExpress(socket, add);
    }
}
