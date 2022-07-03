package com.java.main;

import static com.java.main.Init.*;
import static java.lang.Math.abs;

public class FCFS {
    public FCFS() {
        int temp;
        temp = BeginNum;
        for (int i = 0; i < N; i++) {
            MoveDistance[i] = abs(TrackerOrder[i] - temp);
            temp = TrackerOrder[i];
            FindOrder[i] = TrackerOrder[i];
        }
    }
}
