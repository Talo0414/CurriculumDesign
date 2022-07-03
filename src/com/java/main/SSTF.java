package com.java.main;

import static com.java.main.Init.*;
import static java.lang.Math.abs;

public class SSTF {
    public SSTF() {
        int temp,n = 0;
        int A = M;
        temp = BeginNum;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (abs(TrackerOrder[j] - temp)<A&& !Finished[j]){
                    A = abs(TrackerOrder[j] - temp);
                    n = j;
                }else {
                    continue;
                }
            }
            Finished[n] = true;
            MoveDistance[i] = A;
            temp = TrackerOrder[n];
            A = M;
            FindOrder[i] = TrackerOrder[n];
        }
    }
}
