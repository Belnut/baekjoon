package DFS_BFS;

import BaseKit.IQuize;

import java.util.LinkedList;
import java.util.Queue;

public class HideAndSeek implements IQuize {
    private static final int MAX_VAL = 100000;
    int isChecked[];
    int start;
    int end;
    Queue<Integer> bfsQueue;

    public HideAndSeek() {
        isChecked = new int[MAX_VAL+1];
        bfsQueue = new LinkedList<>();
    }

    public void initialize(int start, int end) {
        for (int i = 1; i <= MAX_VAL; i++) {
            isChecked[i] = -1;
        }
        bfsQueue.clear();
        bfsQueue.add(start);
        isChecked[start] = 0;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        if(start >= end) {
            isChecked[end] = start - end;
        } else {
            seeking();
        }

    }

    private void seeking() {
        while(!bfsQueue.isEmpty()) {
            int target = bfsQueue.poll();
            int nowCount = isChecked[target];

            if(target-1 >= 0 && isChecked[target-1] == -1) {
                isChecked[target-1] = nowCount+1;
                bfsQueue.add(target-1);
                if(target-1 == end) { break; }
            }
            if(target*2 <= MAX_VAL && isChecked[target*2] == -1) {
                isChecked[target*2] = nowCount+1;
                bfsQueue.add(target*2);
                if(target*2 == end) { break; }
            }
            if(target+1 <= MAX_VAL && isChecked[target+1] == -1) {
                isChecked[target+1] = nowCount+1;
                bfsQueue.add(target+1);
                if(target+1 == end) { break; }
            }
        }
    }

    public int getResult() {
        return isChecked[end];
    }
}
