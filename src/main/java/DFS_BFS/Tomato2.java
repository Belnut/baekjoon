package DFS_BFS;

import BaseKit.IQuize;

import java.util.LinkedList;
import java.util.Queue;

//7569 baekjoon 토마
public class Tomato2 implements IQuize {

    private int[][][] tomato;
    private Queue<int[]> tomatoQueue;
    private int endX, endY, endZ;
    private int result;

    public Tomato2() {
        tomatoQueue = new LinkedList<>();
    }

    public void initialize(int [][][] tomato, int[][] roots) {
        tomatoQueue.clear();
        this.tomato = tomato;
        endZ = tomato.length;
        endX = tomato[0].length;
        endY = tomato[0][0].length;

        for(int[] root : roots) {
            tomatoQueue.add(root);
        }
    }

    @Override
    public void run() {
        rapping();
        for(int i = 0;i < endZ; i++) {
            for (int j = 0; j < endX; j++) {
                for (int k = 0; k < endY; k++) {
                    if(tomato[i][j][k] == 0) {
                        result = -1;
                        return;
                    }
                    result = Integer.max(result, tomato[i][j][k]);
                }
            }
        }
        result-= 1;
    }

    public int getResult() {
        return result;
    }

    private void rapping() {
        int date;
        while(!tomatoQueue.isEmpty()) {
            int[] target = tomatoQueue.poll();
            int x = target[1], y = target[2], z=target[0];
            date = tomato[z][x][y] + 1;

            if(x+1 < endX && tomato[z][x+1][y] == 0) {
                tomato[z][x+1][y] = date;
                tomatoQueue.add(new int[]{z, x+1, y});
            }
            if(x-1 >= 0 && tomato[z][x-1][y] == 0) {
                tomato[z][x-1][y] = date;
                tomatoQueue.add(new int[]{z, x-1, y});
            }
            if(y+1 < endY && tomato[z][x][y+1] == 0) {
                tomato[z][x][y+1] = date;
                tomatoQueue.add(new int[]{z, x, y+1});
            }
            if(y-1 >= 0 && tomato[z][x][y-1] == 0) {
                tomato[z][x][y-1] = date;
                tomatoQueue.add(new int[]{z ,x, y-1});
            }
            if(z+1 < endZ && tomato[z+1][x][y] == 0) {
                tomato[z+1][x][y] = date;
                tomatoQueue.add(new int[]{z+1, x, y});
            }
            if(z-1 >= 0 && tomato[z-1][x][y] == 0) {
                tomato[z-1][x][y] = date;
                tomatoQueue.add(new int[]{z-1, x, y});
            }
        }
    }
}
