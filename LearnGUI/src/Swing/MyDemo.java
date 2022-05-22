package Swing;

import javax.swing.*;

/**
 * @Author LiuYunJie
 * @Date 2022/5/21 21:02
 **/
public class MyDemo {
    public static void main(String[] args) {
        JFrame frame = new MyFrame("GUI");

        // 关闭窗口的时候退出整个程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 窗口大小
        frame.setSize(400, 300);

        // 显示窗口
        frame.setVisible(true);
    }
}
