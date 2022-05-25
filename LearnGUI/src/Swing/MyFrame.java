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
    JTextField textField = new JTextField(20);
    JCheckBox checkBox = new JCheckBox("同意");
    JButton button = new JButton("测试");

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

        rootPanel.add(button);
        /* JLabel中增加HTML文本 */
        JLabel htmlLabel = new JLabel("<html>bold <br> plain</html>");
        rootPanel.add(htmlLabel);

        /* 文本框 */
        textField.setText("你好呀");
        rootPanel.add(textField);

        checkBox.addActionListener(e -> {
            if (checkBox.isSelected())
                button.setEnabled(true);
            else button.setEnabled(false);
        });

        /* 复选框 */
        rootPanel.add(checkBox);

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

            System.out.println(textField.getText());
        }
    }

}
