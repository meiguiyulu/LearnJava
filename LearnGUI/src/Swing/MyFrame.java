package Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author LiuYunJie
 * @Date 2022/5/22 19:06
 **/
public class MyFrame extends JFrame {

    JLabel timeLabel = new JLabel("点击按钮，显示时间");

    public MyFrame(String title) {
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
        rootPanel.add(timeLabel);

        JButton button = new JButton("测试");
        rootPanel.add(button);
        /* 添加事件处理 */
        ActionListener actionListener = new MyActionListener();
        button.addActionListener(actionListener);
    }

    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.print("事件处理初体验:\t");
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            String format = dateFormat.format(new Date());
            System.out.println(format);

            timeLabel.setText(format);
        }
    }

}