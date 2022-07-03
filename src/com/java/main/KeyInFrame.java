package com.java.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static com.java.main.Init.*;
public class KeyInFrame {
    public JFrame jFrame;
    public KeyInFrame() {
        //设置特殊样式
        JFrame.setDefaultLookAndFeelDecorated(true);
        jFrame = new JFrame();
        //设置窗口可见性，ture为可见，false为不可见
        jFrame.setVisible(true);
        //设置窗口标题
        jFrame.setTitle("键盘输入");
        //设置窗口大小
        jFrame.setSize(510,340);
        //设置窗口默认居中
        jFrame.setLocationRelativeTo(null);
        //设置窗口大小不可变
        jFrame.setResizable(false);
        //设置默认关闭模式为关闭时销毁窗口
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel panel1 = new JPanel();
        //JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel(new GridLayout(2,1));
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        JLabel label = new JLabel("磁盘I/O申请数：");
        JLabel label1 = new JLabel("请依次输入要访问的磁道号:");
        JLabel label2 = new JLabel("请输入开始的磁道号");

        JTextField textField = new JTextField(10);
        JTextField textField1= new JTextField(10);

        JTextArea textArea = new JTextArea(N,10);

        JButton button = new JButton("确定");
        JButton button1 = new JButton("确定");
        JButton button2 = new JButton("确定");
        JButton button3 = new JButton("FCFS");
        JButton button4 = new JButton("SSTF");

        //磁盘I/O申请数确认按钮事件
        button.addActionListener(e -> {
            //点击确定按钮对N进行赋值
            if (textField.getText() != null) {
                //将文本框的值赋给N
                N = Integer.parseInt(textField.getText());
                //设置文本框不可编辑
                textField.setEnabled(false);
            }
        });
        //依次输入要访问磁盘号文本域事件
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    //当敲击ENTER键时，限制输入的行数与请求的I/O数相同。
                    if (textArea.getLineCount() == N) {
                        textArea.setEnabled(false);
                    }
                }
            }
        });
        //依次输入要访问磁盘号确定按钮事件
        button1.addActionListener(e -> {
            if (textArea.getLineCount() != N){
                JDialog dialog =new JDialog(jFrame,"错误提示",true);
                JLabel jLabel = new JLabel("要访问的磁道号未输入完全");
                JButton jButton = new JButton("确定");
                jButton.addActionListener(e1 -> dialog.dispose());
                dialog.setLayout(new GridLayout(2,1));
                dialog.add(jLabel);
                dialog.add(jButton);
                dialog.setSize(210,140);
                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            }else {
                textArea.setEnabled(false);
                String[] strings = textArea.getText().split("\n");
                for (int i = 0; i < strings.length; i++) {
                    //将文本框中的值赋给TrackerOrder数组
                    TrackerOrder[i] = Integer.parseInt(strings[i]);
                }
            }
        });
        //开始磁盘号确定按钮事件
        button2.addActionListener(e -> {
            //点击确定按钮对BeginNum进行赋值
            if (textField.getText() != null) {
                //将文本框的值赋给BeginNum
               BeginNum = Integer.parseInt(textField1.getText());
                //设置文本框不可编辑
                textField1.setEnabled(false);
            }

        });
        //FCFS按钮事件
        button3.addActionListener(e -> {
            //.isEnabled():是否可输入状态，false不可输入，true可输入
            if (!(textField.isEnabled() == textArea.isEnabled() == textField1.isEnabled())){
                InitArray();
                new FCFS();
                new Count();
                new Show();
            }
        });
        //SSTF按钮事件
        button4.addActionListener(e -> {
            if (!(textField.isEnabled() == textArea.isEnabled() == textField1.isEnabled())){
                InitArray();
                new SSTF();
                new Count();
                new Show();
            }
        });

        panel1.add(label);
        panel1.add(textField);
        panel1.add(button);

        //panel2.add(label1,BorderLayout.NORTH);
        panel2.add(label1);
        //panel2.add(textArea,BorderLayout.CENTER);
        panel2.add(textArea);
        //panel2.add(button1,BorderLayout.EAST);
        panel2.add(button1);

        panel4.add(label2);
        panel4.add(textField1);
        panel4.add(button2);

        panel5.add(button3);
        panel5.add(button4);

        panel3.add(panel4);
        panel3.add(panel5);

        panel.add(panel1,BorderLayout.NORTH);
        panel.add(panel2,BorderLayout.CENTER);
        panel.add(panel3,BorderLayout.SOUTH);

        jFrame.add(panel);
    }
}
