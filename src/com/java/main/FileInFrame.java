package com.java.main;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

import static com.java.main.Init.*;
public class FileInFrame {
    public JFileChooser jFileChooser;
    public JFrame jFrame;
    public FileInFrame() {
        jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jFileChooser.setDialogTitle("请选择带有磁盘调度信息的文本文件");
        jFileChooser.setFileFilter(new FileNameExtensionFilter("文本文件(*.txt)", "txt"));
        int state = jFileChooser.showOpenDialog(null);
        if (state == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file),"UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String s;
                String[] sf;
                while ((s = bufferedReader.readLine()) != null) {
                    sf = s.split(":");
                    if ("磁盘I/O的申请数".equals(sf[0])) {
                        N = Integer.parseInt(sf[1]);
                    } else if ("要访问的磁道号".equals(sf[0])) {
                        String[] strings = sf[1].split("、");
                        for (int i = 0; i < strings.length; i++) {
                            TrackerOrder[i] = Integer.parseInt(strings[i]);
                        }
                    } else if ("开始磁道号".equals(sf[0])) {
                        BeginNum = Integer.parseInt(sf[1]);
                    }
                }
                /*
                ----------------------------------------------
                 */
                jFrame = new JFrame();
                //设置点击关闭为隐藏窗口
                jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                //设置居中
                jFrame.setLocationRelativeTo(null);
                //设置不可改变大小
                jFrame.setResizable(false);
                //新建一个面板
                JPanel panel = new JPanel(new GridLayout(2,1));
                JPanel panel1 = new JPanel();
                JPanel panel2 = new JPanel();
                JLabel label = new JLabel("请选择磁盘调度算法");
                JButton FCFS = new JButton("FCFS");
                JButton SSTF = new JButton("SSTF");
                panel1.add(label);
                panel2.add(FCFS);
                panel2.add(SSTF);
                panel.add(panel1);
                panel.add(panel2);
                jFrame.add(panel);
                FCFS.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	//进行数组初始化
                    	InitArray();
                        new FCFS();
                        new Count();
                        //弹出展示窗口
                        new Show();
                    }
                });
                SSTF.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	//进行数组初始化
                    	InitArray();
                        new SSTF();
                        new Count();
                        //弹出展示窗口
                        new Show();
                    }
                });
                jFrame.pack();
                jFrame.setVisible(true);
                /*
                ----------------------------------------------
                 */
                bufferedReader.close();
                inputStreamReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}