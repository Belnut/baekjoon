package Dynamic;

import java.util.ArrayList;
import java.util.Arrays;

public class PoliceCar {
    public static final int CAR1 = 0;
    public static final int CAR2 = 1;

    ArrayList<int[]> route;
    int mapSize;
    int totalMove;
    int[][] dp;
    int[][] record;

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
        totalMove = 0;
        route = new ArrayList<>();
        route.add(new int[]{1,1});
        route.add(new int[]{mapSize,mapSize});

    }

    public void addCaseOperate(int x, int y) {
        route.add(new int[]{x,y});
    }

    public int getResult() {
        return totalMove;
    }

    public int[] getRecord() {
        int[] rst = new int[route.size()-2];
        int car1 = CAR1;
        int car2 = CAR2;
        int index = 0;

        while(index < rst.length) {
            if(record[car1][car2] == 0) {
                rst[index] = 1;
                car1 = Integer.max(car1,car2) + 1;
            } else {
                rst[index] = 2;
                car2 = Integer.max(car1,car2) + 1;
            }
            index++;
        }

        return rst;
    }

    public void run() {
        dp = new int[route.size()][route.size()];
        record = new int[route.size()][route.size()];
        for (int i= 0 ; i<route.size(); i++)
            Arrays.fill(dp[i], -1);

        totalMove = solve(0, 1);
    }


    private int solve(int x, int y) {
        int nextCase = Integer.max(x, y)+1;
        if(nextCase == route.size()) return 0;

        if(dp[x][y] != -1 ) return dp[x][y];

        int car1Move = solve(nextCase, y) + distance(x, nextCase);
        int car2Move = solve(x, nextCase) + distance(y, nextCase);

        if(car2Move > car1Move) {
            dp[x][y] = car1Move;
            record[x][y] = CAR1;
        }
        else {
            dp[x][y] = car2Move;
            record[x][y] = CAR2;
        }

        return dp[x][y];
    }

    private int distance(int i1, int i2) {
        int cost = 0;
        cost += sub(route.get(i1)[0], route.get(i2)[0]);
        cost += sub(route.get(i1)[1], route.get(i2)[1]);
        return cost;
    }

    private int sub(int a1, int a2) {
        if(a1 > a2) {
            return a1 - a2;
        } else{
            return a2 - a1;
        }
    }
}
