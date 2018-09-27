package com.zhuoxun;

import com.zhuoxun.service.ManagerService;
import com.zhuoxun.service.impl.ManagerServiceImpl;
import com.zhuoxun.frame.Home;

import javax.swing.*;

public class test {
    public static void main(String[] args) {

//        Welcome l = new Welcome();

        javax.swing.SwingUtilities.invokeLater((new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        }));
    }

    private static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        Home frame = new Home();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
