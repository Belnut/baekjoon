package Dijkstra;

import BaseKit.IQuize;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestRoute implements IQuize {

    int nodeCount;
    int[][] route;
    int[] rst;

    Queue<Integer> queue;
    boolean[] isChecked;
    int startNode;

    public ShortestRoute() {
    }

    public void initialize(int nodeCount) {
        this.nodeCount = nodeCount;
        this.rst = new int[nodeCount+1];
        queue = new LinkedList<>();
        isChecked = new boolean[nodeCount+1];
        route = new int[nodeCount+1][nodeCount+1];
        for(int i = 1 ; i <= nodeCount+1; i ++) {
            for (int j = 1 ; j <= nodeCount; nodeCount++) {
                route[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public void addRoute(int[] loc, int cost) {
        route[loc[0]][loc[1]] = cost;
        route[loc[1]][loc[0]] = cost;
    }

    public void setStart(int startNode) {
        startNode = startNode;
        for (int i = 1; i <= nodeCount; i++) {
            rst[i] = route[startNode][i];
        }
    }

    @Override
    public void run() {

    }

    private void exploreMap() {
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int start = queue.poll();
        }

    }
}
