package Dijkstra;

import BaseKit.IQuize;

import java.util.*;
//1753 baekjoon 최단경로 메모리초과
public class ShortestRoute2 implements IQuize {
    public static final int MAX = 1000000;
    private int[] midRouteNode;
    private ArrayList<ArrayList<nextRoute>> route;

    private HashMap<Integer, Integer> map;

    private int nodeCount;
    private int[] result;
    private int startNode;


    public void initialize(int nodeCount) {
        this.nodeCount = nodeCount;
        this.map = new HashMap<>();
        route = new ArrayList<>();
    }

    public void addRoute(int x, int y, int cost) {
        if(map.get(x) == null) {
            int routeIndex = route.size();
            map.put(x, routeIndex);
            route.add(new ArrayList<>());
        }
        route.get(map.get(x)).add(new nextRoute(y, cost));
    }

    public void addRoute(int[]loc , int cost) {
        addRoute(loc[0], loc[1], cost);
    }

    public int[] getResult() {
        return result;
    }

    public void setStart(int startNode) {
        this.startNode = startNode;
    }

    @Override
    public void run() {
        exploreRoute();
    }

    public void exploreRoute() {
        dijkstra(startNode);
    }

    public void dijkstra(int start) {
        int[] d = new int[nodeCount+1];
        boolean[] visited = new boolean[nodeCount+1];
        Arrays.fill(d, MAX);
        d[start] = 0;


        Queue<nextRoute> pq = new PriorityQueue<>();
        pq.add(new nextRoute(start,0));

        while(!pq.isEmpty()) {
            nextRoute n = pq.poll();

            if(visited[n.nextNode])
                continue;

            visited[n.nextNode] = true;
            int[] bd = d.clone();

            if (map.get(n.nextNode) == null) {
                continue;
            }

            for (nextRoute target : route.get(map.get(n.nextNode))) {
                d[target.nextNode] = Integer.min(d[target.nextNode], bd[n.nextNode] + target.cost);
            }

            for(int i = 1 ; i<= nodeCount; i++) {
                if(!visited[i] && d[i] < MAX ) {
                    pq.add(new nextRoute(i, d[i]));
                }
            }
        }
        result = d;
    }

    static class nextRoute implements Comparable<nextRoute>{
        int nextNode;
        int cost;

        public nextRoute(int nexNode, int cost) {
            this.nextNode = nexNode;
            this.cost = cost;
        }

        @Override
        public int compareTo(nextRoute n) {
            return this.cost > n.cost ? 1: -1;
        }
    }
}
