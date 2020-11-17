package Dijkstra;
import BaseKit.IQuize;

import java.util.ArrayList;
//1753 baekjoon 최단경로
public class ShortestRoute implements IQuize {
    public static final int MAX = 1000000;
    int nodeCount;
    ArrayList<ArrayList<NextNode>> route;
    short routeStoreCount;
    short[] routeStoreIndex;
    int[] rst;

    boolean[] isChecked;
    int startNode;

    public ShortestRoute() {
    }

    public void initialize(int nodeCount) {
        this.nodeCount = nodeCount;
        this.rst = new int[nodeCount+1];

        isChecked = new boolean[nodeCount+1];
        route = new ArrayList<>();
        routeStoreCount = 0;
        routeStoreIndex = new short[nodeCount+1];
        for(int i = 1 ; i <= nodeCount; i++) {
            routeStoreIndex[i] = -1;
        }
    }

    public void addRoute(int[] loc, int cost) {
        if(routeStoreIndex[loc[0]] == -1) {
            routeStoreIndex[loc[0]] = routeStoreCount++;
            route.add(new ArrayList<>());
        }
        int index = routeStoreIndex[loc[0]];
        route.get(index).add(new NextNode(loc[1], cost));
    }

    public void setStart(int startNode) {
        this.startNode = startNode;
    }

    @Override
    public void run() {
        for (int i = 1; i <= nodeCount; i++) {
            rst[i] = ShortestRoute.MAX;
        }
        rst[startNode] = 0;

        //시작 노드와 연결 경로 없을 시 종료
        int index = routeStoreIndex[startNode];
        if (index == -1) {
            return;
        }

        for(NextNode r : route.get(index)) {
            rst[r.target] = Integer.min(rst[r.target] , r.cost);
        }

        exploreMap();
    }

    private void exploreMap() {
        isChecked[startNode] = true;
        for(int i = 1; i <= nodeCount; i++) {
            int index = minIndex();
            if(index == -1) {continue;}
            isChecked[index] = true;

            int routeIndex = routeStoreIndex[index];
            if(routeIndex == -1) continue;
            for(NextNode n : route.get(routeIndex)) {
                rst[n.target] = Integer.min(rst[n.target], rst[index] + n.cost);
            }
        }
    }

    private int minIndex() {
        int min = MAX;
        int index = -1;
        for (int i = 1; i <= nodeCount; i++) {
            if(min > rst[i] && !isChecked[i]) {
                index = i; min = rst[i];
            }
        }
        return index;
    }

    int[] getResult() {
        return this.rst;
    }

    static class NextNode {
        int target;
        int cost;

        public NextNode(int target, int cost) {
            this.cost = cost;
            this.target = target;
        }
    }
}
