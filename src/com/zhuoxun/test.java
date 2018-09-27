package com.zhuoxun;

import com.zhuoxun.frame.Welcome;
import com.zhuoxun.service.ManagerService;
import com.zhuoxun.service.impl.ManagerServiceImpl;
import com.zhuoxun.frame.Home;

import javax.swing.*;

import static com.zhuoxun.frame.Home.createAndShowGUI;

public class test {
    public static void main(String[] args) {

        /*** 1. run from start ***/

//        Welcome l = new Welcome();

        /*** 2. run directly to Home view ***/

        javax.swing.SwingUtilities.invokeLater((new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        }));
    }
}
