package Dijkstra;

import BaseKit.IQuize;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//1504 baekjoon 미확인 도착지
public class SpecificShortestRoute implements IQuize {
    public static final int MAX = 800000;
    int[] midRouteNode;
    int[][] route;
    int nodeCount;
    int result;


    public void initialize(int nodeCount) {
        this.nodeCount = nodeCount;
        route = new int[nodeCount+1][nodeCount+1];
        for (int i = 1; i <= nodeCount; i++) {
            Arrays.fill(route[i], MAX);
        }
        result = -1;
    }

    public void addRoute(int x, int y, int cost) {
        route[x][y] = Integer.min(route[x][y], cost);
        route[y][x] = Integer.min(route[y][x], cost);
    }


    public int getResult() {
        return result;
    }

    public void setMidRoute(int[] midRouteNode) {
        this.midRouteNode = midRouteNode;
    }

    public void setMidRoute(int x, int y) {
        setMidRoute(new int[]{x,y});
    }

    @Override
    public void run() {
        exploreRoute();
    }

    public void exploreRoute() {
        int front = dijkstra(1, midRouteNode[0]);
        int mid = dijkstra(midRouteNode[0], midRouteNode[1]);
        int back = dijkstra(midRouteNode[1], nodeCount);

        int r1;
        if(front >= MAX || mid >= MAX || back >= MAX ) r1 = 3 * MAX;
        else r1 = front + mid + back;

        front = dijkstra(1, midRouteNode[1]);
        mid = dijkstra(midRouteNode[1], midRouteNode[0]);
        back = dijkstra(midRouteNode[0], nodeCount);

        int r2;

        if(front >= MAX || mid >= MAX || back >= MAX ) r2 = 3 * MAX;
        else r2 = front + mid + back;

        if(r1 == 3*MAX && r2 == 3*MAX) result = -1;
        else result = Integer.min(r1, r2);
    }

    public int dijkstra(int start, int end) {
        if(start == end) return 0;

        int[] d = new int[nodeCount+1];
        boolean[] visited = new boolean[nodeCount+1];
        Arrays.fill(d, MAX);
        d[start] = 0;

        Queue<NextNode> pq = new PriorityQueue<>();
        pq.add(new NextNode(start,0));

        while(!pq.isEmpty()) {
            NextNode n = pq.poll();

            if(visited[n.nexNode])
                continue;

            visited[n.nexNode] = true;

            for (int i = 1; i <= nodeCount; i++) {
                d[i] = Integer.min(d[i], d[n.nexNode] + route[n.nexNode][i]);
            }

            for(int i = 1 ; i<= nodeCount; i++) {
                if(!visited[i] && d[i] < MAX ) {
                    pq.add(new NextNode(i, d[i]));
                }
            }

            if(visited[end]) break;
        }

        return d[end];
    }

    static class NextNode implements Comparable<NextNode>{
        int nexNode;
        int cost;

        public NextNode (int nexNode, int cost) {
            this.nexNode = nexNode;
            this.cost = cost;
        }

        @Override
        public int compareTo(NextNode n) {
            return this.cost > n.cost ? 1: -1;
        }
    }
}
