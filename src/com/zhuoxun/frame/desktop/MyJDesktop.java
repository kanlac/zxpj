package com.zhuoxun.frame.desktop;

import javax.swing.*;
import java.awt.*;

public class MyJDesktop extends JDesktopPane {
    private Image img = null;

    public MyJDesktop() {
        try {
            img = new ImageIcon(this.getClass().getResource("dark_linen-1024x1024.png")).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        if (img == null) {
            super.paintComponent(g);
        } else {
            Graphics2D graphics = (Graphics2D)g;

            double mWidth = img.getWidth(null);
            double mHeight = img.getHeight(null);

            double width = getWidth() / mWidth;
            double height = getHeight() / mHeight;

            graphics.scale(width, height);
            graphics.drawImage(img, 0, 0, this);
        }
    }
}
