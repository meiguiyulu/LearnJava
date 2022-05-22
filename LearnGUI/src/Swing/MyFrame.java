package Swing;

import javax.swing.*;

/**
 * @Author LiuYunJie
 * @Date 2022/5/22 19:06
 **/
public class MyFrame extends JFrame {

    public MyFrame(String title){
        super(title);
        /*
        设置容器
         */
        JPanel rootPanel = new JPanel();
        this.setContentPane(rootPanel);

        /*
        添加控件
         */
        JLabel label = new JLabel("JLabel标签");
        rootPanel.add(label);

        JButton button = new JButton("测试");
        rootPanel.add(button);
    }
}
