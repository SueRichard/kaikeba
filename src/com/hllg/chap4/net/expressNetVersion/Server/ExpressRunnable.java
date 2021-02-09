package com.hllg.chap4.net.expressNetVersion.Server;


import com.hllg.chap4.net.expressNetVersion.dao.ExpressDao;
import com.hllg.chap4.net.expressNetVersion.dao.impl.ExpressDaoImpl;
import com.hllg.chap4.net.expressNetVersion.entity.Express;
import com.hllg.chap4.net.expressNetVersion.util.MsgUtils;

import java.io.IOException;
import java.net.Socket;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/08  Mon  07:34
 * 任务
 * 通过循环来接受命令，然后用switch进入分支，具体方法由工具类MsgUtils完成
 */
public class ExpressRunnable implements Runnable {
    private Socket socket;
    //接口实现
    private ExpressDao expressDao = new ExpressDaoImpl();

    public ExpressRunnable(Socket accept) {
        this.socket = accept;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String receiveCmd = MsgUtils.receiveCmd(socket);
                //命令为空退出循环
                if (receiveCmd == null) break;
                switch (receiveCmd) {
                    case MsgUtils.CMD_ADD:
                        addExpress();
                        break;
                    case MsgUtils.CMD_CHECK_FULL:
                        checkFull();
                        break;
                    case MsgUtils.CMD_DELETE:
                        deleteByNum();
                        break;
                    case MsgUtils.CMD_FIND_NUMBER:
                        findByNum();
                        break;
                    case MsgUtils.CMD_UPDATE:
                        updateExpress();
                        break;
                    case MsgUtils.CMD_QUERY_ALL:
                        queryAll();
                        break;
                    case MsgUtils.CMD_PICK:
                        pickExpress();
                        break;
                    case MsgUtils.CMD_SIZE:
                        size();
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

    /**
     * 使用此方法请先接受值
     * 返回集合的大小
     *
     * @throws IOException
     */
    private void size() throws IOException {
        MsgUtils.sendInt(socket, expressDao.query().size());
    }

    /**
     * 使用此方法请先发送取件码（int）
     * 返回布尔值的结果
     *
     * @throws IOException
     */
    private void pickExpress() throws IOException {
        int code = MsgUtils.receiveInt(socket);
        MsgUtils.sendBoolean(socket, expressDao.pickExpress(code));
    }

    /**
     * 使用此方法请先接受List<>集合
     *
     * @throws IOException
     */
    private void queryAll() throws IOException {
        MsgUtils.sendList(socket, expressDao.query());
    }

    /**
     * 使用此方法请先传递旧和新的快递实体类
     * 返回实体类
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void updateExpress() throws IOException, ClassNotFoundException {
        Express oldExpress = MsgUtils.receiveExpress(socket);
        Express newExpress = MsgUtils.receiveExpress(socket);
        MsgUtils.sendExpress(socket, expressDao.update(oldExpress, newExpress));
    }

    /**
     * 使用此方法请先发送快递单号（String）
     * 返回快递实体类
     * 有返回，无为null
     *
     * @throws IOException
     */
    private void findByNum() throws IOException {
        String num = MsgUtils.receiveString(socket);
        MsgUtils.sendExpress(socket, expressDao.findByNum(num));
    }

    /**
     * 使用此方法请先发送快递单号（String）
     * 返回布尔值
     * 成功true，失败false
     *
     * @throws IOException
     */
    private void deleteByNum() throws IOException {
        String num = MsgUtils.receiveString(socket);
        MsgUtils.sendBoolean(socket, expressDao.delete(num));
    }

    /**
     * 使用此方法请接受布尔值
     * 集合存满true，否则false
     *
     * @throws IOException
     */
    private void checkFull() throws IOException {
        MsgUtils.sendBoolean(socket, expressDao.checkFull());
    }

    /**
     * 使用此方法请先发送快递实体
     * 返回快递实体类
     * 成功则为添加的实体，否则null
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void addExpress() throws IOException, ClassNotFoundException {
        Express express = MsgUtils.receiveExpress(socket);
        Express add = expressDao.add(express);
        MsgUtils.sendExpress(socket, add);
    }
}
