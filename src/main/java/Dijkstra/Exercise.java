package Dijkstra;

import BaseKit.IQuize;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise implements IQuize {
    public static final int MAX = 4000000;
    private int[][] result;
    private int nodeCount;

    public void initialize(int nodeCount) {
        this.nodeCount = nodeCount;
        result = new int[nodeCount+1][nodeCount+1];
        for (int i = 1; i <= nodeCount; i++) {
            Arrays.fill(result[i], MAX);
            result[i][i] = 0;
        }
    }

    public void addRoute(int x, int y, int cost) {
        result[x][y] = cost;
    }


    @Override
    public void run() {
        exploreRoute();
    }

    private void exploreRoute() {
        for (int i = 1; i <= nodeCount; i++) {
            for(int j = 1; j<= nodeCount; j++) {
                if(i == j || result[j][i] >= MAX ) continue;
                for(int k = 1; k<=nodeCount; k++) {
                    int cmp = result[j][i] + result[i][k];
                    if(result[j][k] > cmp) {
                        result[j][k] = cmp;
                    }
                }
            }
        }
    }

    public int getResult() {
        int min = MAX * 2;
        for(int i = 1; i <= nodeCount; i++) {
            for (int j = i+1 ; j<=nodeCount; j++) {
                if (result[i][j] >= MAX || result[j][i] >= MAX) continue;
                min = Integer.min(min,result[i][j] + result[j][i]);
            }
        }

        if(min >= MAX*2) return -1;
        else return min;
    }

    private static class NextRoute {
        int nextNode;
        int cost;

        public NextRoute(int nextNode, int cost) {
            this.nextNode = nextNode;
            this.cost = cost;
        }
    }
}
