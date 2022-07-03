package com.java.main;

import javax.swing.*;
public class MainFrame {
    public JFrame jFrame;
    public MainFrame() {
        //设置特殊样式
        JFrame.setDefaultLookAndFeelDecorated(true);
        jFrame = new JFrame();
        //设置窗口标题
        jFrame.setTitle("第十一组——磁盘调度算法");
        //设置窗口大小
        jFrame.setSize(360,240);
        //设置窗口默认居中
        jFrame.setLocationRelativeTo(null);
        //设置窗口大小不可变
        jFrame.setResizable(false);
        //设置默认关闭模式为关闭时销毁窗口
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        JButton button = new JButton("键盘输入");
        JButton button1 = new JButton("文件读入");
        //设置窗口布局
        panel.setLayout(null);
        //设置按钮位置大小参数
        button.setBounds(50,75,100,50);
        button1.setBounds(200,75,100,50);
        button.addActionListener(e -> {
            new KeyInFrame();
        });
        button1.addActionListener(e -> {
            new FileInFrame();
        });
        panel.add(button);
        panel.add(button1);
        jFrame.add(panel);
        //设置窗口可见性，ture为可见，false为不可见
        jFrame.setVisible(true);
    }
}
