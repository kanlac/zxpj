package com.zhuoxun;

import com.zhuoxun.service.ManagerService;
import com.zhuoxun.service.impl.ManagerServiceImpl;
import com.zhuoxun.frame.Home;

public class test {
    public static void main(String[] args) {
        ManagerService service = new ManagerServiceImpl();
        service.findAll();

        Home h = new Home();
//        Welcome l = new Welcome();
    }
}
