package DFS_BFS;

import BaseKit.IQuize;

public class OrganicFarm implements IQuize {
    int[][] farm;
    boolean[][] isChecked;
    int result;
    int endX, endY;

    public void initialize(int x, int y) {
        farm = new int[x][y];
        isChecked = new boolean[x][y];
        this.result = 0;
        this.endX = farm.length;
        this.endY = farm[0].length;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < endX; i++) {
            for (int j = 0; j< endY; j++) {
                boolean isAdd = checkFarm(i,j);
                if(isAdd) {
                    result++;
                }
            }
        }
    }

    public void addFarming(int x, int y) {
        farm[x][y] = 1;
    }

    public boolean checkFarm(int x, int y) {
        boolean hasOnce = false;

        if(x < 0 || x >= endX) {
            return hasOnce;
        }
        if(y < 0 || y >= endY) {
            return hasOnce;
        }

        if(farm[x][y] == 1 && isChecked[x][y] == false) {
            hasOnce = true;
            isChecked[x][y] = true;
            checkFarm(x-1, y);
            checkFarm(x, y-1);
            checkFarm(x+1, y);
            checkFarm(x, y+1);
        }
        return hasOnce;
    }

    public int getResult() {
        return this.result;
    }
}
