package com.java.main;

import javax.swing.*;
import java.awt.*;

import static com.java.main.Init.*;

public class Show {
    public JFrame jFrame;
    public Show() {
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setTitle("磁盘调度算法结果");
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panel1 = new JPanel(new GridLayout(1,2));
        JPanel panel2 = new JPanel();
        JTextArea textArea = new JTextArea(N+1,10);
        JTextArea textArea1 = new JTextArea(N+1,10);
        JTextField textField = new JTextField(20);
        JLabel label = new JLabel("平均寻道长度：");
        textField.setText(String.valueOf(String.format("%.3f",AverageDistance)));
        String s = "被访问的下一个磁道号\n";
        String s1 = "移动距离（磁道数）\n";
        for (int i = 0; i < N; i++) {
            s = s + FindOrder[i] + "\n";
        }
        for (int i = 0; i < N; i++) {
            s1 = s1 + MoveDistance[i] + "\n";
        }
        textArea.setEnabled(false);
        textArea1.setEnabled(false);
        textField.setEnabled(false);
        textArea.setText(s);
        textArea1.setText(s1);
        panel1.add(textArea);
        panel1.add(textArea1);
        panel2.add(label);
        panel2.add(textField);
        panel.add(panel1,BorderLayout.CENTER);
        panel.add(panel2,BorderLayout.SOUTH);
        jFrame.add(panel);
        jFrame.setVisible(true);
        jFrame.pack();
    }
}
