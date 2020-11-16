package DFS_BFS;

import BaseKit.IQuize;

import java.util.LinkedList;
import java.util.Queue;

//7576 baekjoon 토마토
public class Tomato implements IQuize {
    private int[][] tomato;
    private Queue<int[]> tomatoQueue;
    int endX, endY;
    int totalDay;

    public Tomato () {
        tomatoQueue = new LinkedList<>();
    }

    public void initialize(int[][] tomato, int[][] roots, int x, int y) {
        this.tomato = tomato;
        this.endX = x;
        this.endY = y;
        for (int[] root : roots) {
            tomatoQueue.add(root);
        }
    }

    @Override
    public void run() {
        rapping();

        totalDay = 0;
        for (int i = 0; i < endX; i++) {
            for (int j = 0; j < endY; j++) {
                int rst = tomato[i][j];
                if(rst == 0) { totalDay = -1; return; }
                totalDay = Integer.max(rst, totalDay);
            }
        }
        totalDay -= 1;
    }

    public int getResult() {
        return totalDay;
    }

    private void rapping() {
        int date;
        while(!tomatoQueue.isEmpty()) {
            int[] target = tomatoQueue.poll();
            int x = target[0], y = target[1];
            date = tomato[x][y] + 1;

            if(x+1 < endX && tomato[x+1][y] == 0) {
                tomato[x+1][y] = date;
                tomatoQueue.add(new int[]{x+1, y});
            }
            if(x-1 >= 0 && tomato[x-1][y] == 0) {
                tomato[x-1][y] = date;
                tomatoQueue.add(new int[]{x-1, y});
            }
            if(y+1 < endY && tomato[x][y+1] == 0) {
                tomato[x][y+1] = date;
                tomatoQueue.add(new int[]{x, y+1});
            }
            if(y-1 >= 0 && tomato[x][y-1] == 0) {
                tomato[x][y-1] = date;
                tomatoQueue.add(new int[]{x, y-1});
            }
        }
    }
}
