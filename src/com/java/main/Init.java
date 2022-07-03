package com.java.main;

import java.util.Arrays;

//初始化类
public class Init {
    static final int MaxNumber = 100;

    static int[] TrackerOrder = new int[MaxNumber];
    //移动距离
    static int[] MoveDistance = new int[MaxNumber];
    //寻道序列
    static int[] FindOrder = new int[MaxNumber];
    //平均寻道长度
    static double AverageDistance;
    //寻道方向 true时向外，false时向里
    static boolean direction;
    //开始磁道号
    static int BeginNum;
    //磁道数
    static int M = 500;
    //提出磁盘I/O申请数
    static int N;
    //排序后的序列
    static int[] SortOrder = new int[MaxNumber];

    static boolean[] Finished = new boolean[MaxNumber];
    //初始化所有出目标通道数组外的所有数组
    public static void InitArray() {
    	MoveDistance =  new int[MaxNumber];
    	FindOrder = new int[MaxNumber];
    	SortOrder = new int[MaxNumber];
    	Finished = new boolean[MaxNumber];
    }
}
