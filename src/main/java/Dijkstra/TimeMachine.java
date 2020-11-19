package Dijkstra;

import BaseKit.IQuize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//nodeCount <= 500, routeCount <= 6000, duplicated route, -10,000<= r <= 10,000
//use queue;

public class TimeMachine implements IQuize {
    public static final int MAX = 5000000;
    private int nodeCount;
    private int[] routeIndex;
    private ArrayList<ArrayList<NextRoute>> route;
    private int[] result;

    private boolean isInfiniteRecycle;

    void initialize(int nodeCount) {
        this.nodeCount = nodeCount;
        result = new int[nodeCount-1];
        route = new ArrayList<>();
        routeIndex = new int[nodeCount+1];

        Arrays.fill(routeIndex, -1);
        isInfiniteRecycle = false;
    }

    void addRoute(int x, int y, int cost) {
        if(routeIndex[x] == -1 ) {
            routeIndex[x] = route.size();
            route.add(new ArrayList<>());
        }
        int index = routeIndex[x];
        route.get(index).add(new NextRoute(y, cost));
    }

    @Override
    public void run() {
        result = exploreRoute(1);
        for(int i = 0 ; i < result.length; i++) {
            result[i] = result[i] >= MAX ? -1 : result[i];
        }
    }

    public int[] getResult() {
        return result;
    }

    public int[] exploreRoute(int start) {
        if(start == nodeCount) return new int[]{0};

        int[] d = new int[nodeCount+1];
        Arrays.fill(d, MAX);
        d[start] = 0;

        boolean isUpdated = false;
        for(int i = 1 ; i<= nodeCount; i++ ) {
            isUpdated = false;

            int[] bd = d.clone();

            for(int j = 1 ; j<= nodeCount; j++) {
                int index = routeIndex[j];

                if (d[j] >= MAX) continue;
                if(index == -1) continue;

                for (NextRoute n : route.get(index)) {
                    if( d[n.nextNode] > bd[j] + n.cost) {
                        d[n.nextNode] = bd[j] + n.cost;
                        isUpdated = true;
                    }
                }
            }
            if(!isUpdated) break;
        }

        if(isUpdated) return new int[]{-1};
        else return Arrays.copyOfRange(d, 2, d.length);
    }

    static class NextRoute implements Comparable<NextRoute> {
        int nextNode;
        int cost;

        public NextRoute(int nextNode, int cost)  {
            this.nextNode = nextNode;
            this.cost = cost;
        }

        @Override
        public int compareTo(NextRoute n) {
            return this.cost > n.cost ? 1: -1;
        }
    }
}
