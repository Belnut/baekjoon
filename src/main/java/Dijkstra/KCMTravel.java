package Dijkstra;

import BaseKit.IQuize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KCMTravel implements IQuize {
    public static final int MAX = 100000;
    private int nodeCount;
    private int costLimit;

    private ArrayList<ArrayList<NextRoute>> route;
    private int[] routeIndex;

    private int[][] dp;
    private int result;

    public void initialize(int nodeCount, int costLimit) {
        this.nodeCount = nodeCount;
        this.costLimit = costLimit;

        this.route = new ArrayList<>();
        this.routeIndex = new int[nodeCount+1];
        this.dp = new int[nodeCount+1][costLimit+1];

        Arrays.fill(routeIndex, -1);
        for(int i = 2 ; i <= nodeCount ; i++) {
            Arrays.fill(dp[i], MAX);
        }
        result = -1;
    }

    public void addRoute(int x, int y, int cost, int time) {
        if (cost > costLimit) return;
        if(routeIndex[x] == -1) {
            routeIndex[x] = route.size();
            route.add(new ArrayList<>());
        }
        int index = routeIndex[x];
        route.get(index).add(new NextRoute(y, cost, time));
    }

    @Override
    public void run() {
        exploreRoute();
    }

    public void exploreRoute() {
        if(costLimit == 0) {
            result = -1; return;
        }
        Queue<NextRoute> pq = new PriorityQueue<>();
        pq.add(new NextRoute(1, 0, 0));
        dp[1][0] = 0;

        while(!pq.isEmpty()) {
            NextRoute n = pq.poll();

            //이놈 하나 때문에 개판이 났다...
            if(dp[n.nextNode][n.cost] < n.time) continue;

            int index = routeIndex[n.nextNode];
            if(index == -1) continue;
            for(NextRoute t : route.get(index)) {
                int expCost = t.cost + n.cost;
                int expTime = t.time + n.time;

                if(expCost > costLimit) continue;
                if(dp[t.nextNode][expCost] > expTime) {
                    for(int i = expCost; i <= costLimit; i++) {
                        if(dp[t.nextNode][i] > expTime)
                            dp[t.nextNode][i] = expTime;
                    }
                    pq.add(new NextRoute(t.nextNode, expCost, expTime));
                }
            }
        }

        result = MAX;
        for (int i = 1; i <= costLimit; i++) {
            result = Integer.min(result, dp[nodeCount][i]);
        }
        if(result >= MAX) {
            result = -1;
        }
    }

    public int getResult() {
        return result;
    }

    private static class NextRoute implements Comparable<NextRoute> {
        int nextNode;
        int cost;
        int time;

        public NextRoute(int nextNode, int cost, int time) {
            this.nextNode = nextNode;
            this.cost = cost;
            this.time = time;
        }

        @Override
        public int compareTo(NextRoute n) {
            if(this.cost == n.cost ) return this.time > n.time ? 1 : -1;
            else return this.cost > n.cost ? 1 : -1;
        }
    }
}
