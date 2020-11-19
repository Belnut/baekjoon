package Dijkstra;

import BaseKit.IQuize;

import java.util.Arrays;

//11404 baekjoon 플로이드
public class Floyd implements IQuize {
    public static final int MAX = 10000000;
    private int nodeCount;
    private int[][] route;


    public void initialize(int nodeCount) {
        this.nodeCount = nodeCount;
        this.route = new int[nodeCount+1][nodeCount+1];
        for (int i = 1; i <= nodeCount; i++) {
            Arrays.fill(route[i], MAX);
            route[i][i] = 0;
        }
    }

    public void addRoute(int x, int y, int cost) {
        route[x][y] = Integer.min(route[x][y], cost);
    }

    @Override
    public void run() {
        exploreRouteByFloyd();
    }

    private void exploreRouteByFloyd() {
        for(int i = 1; i<= nodeCount ; i++) {
            for (int j = 1; j<= nodeCount; j++) {
                if(i == j) continue;
                if(route[j][i] >= MAX) continue;
                for(int k = 1; k<= nodeCount; k++) {
                    if(i == k ) continue;
                    route[j][k] = Integer.min(route[j][k], route[i][k]+ route[j][i]);
                }
            }
        }
    }

    public int[][] getResult() {
        return this.route;
    }
}
