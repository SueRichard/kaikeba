package com.hllg.objectOriented.advanced;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/14  Sun  12:14
 * 使用系统API来描述局部内部类怎么使用，了解即可
 * 现在不用java做
 */
public class RealDemoInLocalInnerClass {
    public static void main(String[] args) {
        Frame f = new Frame("hl见面器");
        f.setVisible(true);
        f.setSize(400, 400);
        class MyWindowListener implements WindowListener {

            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("你想关我？不是想见我么？");
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        }
        MyWindowListener l = new MyWindowListener();
        f.addWindowListener(l);
    }
}
