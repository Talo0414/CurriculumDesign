package com.java.main;

import static com.java.main.Init.*;

public class Count {
    public Count() {
        int Total = 0;
        for (int i = 0; i < N; i++) {
            Total+=MoveDistance[i];
        }
        AverageDistance = ((double)Total)/((double) N);
    }
}
