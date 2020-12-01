package Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//11779 baekjoon 최소비용 구하기
public class CalculateMinCost {
    public static final int MAX = 1000000000;
    private int[][] route;
    private int nodeCount;
    private int[] result;
    private int[] record;
    private boolean[] visited;
    private int startNode;
    private int endNode;

    private ArrayList<Integer> recordResult;

    public CalculateMinCost(int nodeCount) {
        this.nodeCount = nodeCount;
        route = new int[nodeCount+1][nodeCount+1];
        result = new int[nodeCount+1];
        record = new int[nodeCount+1];
        visited = new boolean[nodeCount+1];

        for(int i = 0; i < route.length; i++) {
            Arrays.fill(route[i], MAX);
        }
    }

    public void addRoute(int s, int e, int cost) {
        route[s][e] = Integer.min(route[s][e], cost);
    }

    public void setStartNode(int startNode) {
        this.startNode = startNode;
    }

    public void setEndNode(int endNode) {
        this.endNode = endNode;
    }

    public void run() {
        recordResult = new ArrayList<>();
        if(startNode == endNode) {
            result[endNode] = 0;
            recordResult.add(endNode);
            return;
        }

        exploreMap();


        int nextNode = endNode;
        while(nextNode != 0) {
            recordResult.add(nextNode);
            nextNode = record[nextNode];
        }
        recordResult.add(startNode);
        Collections.reverse(recordResult);
    }

    public int getTotalCost() {
        return result[endNode];
    }

    public int getRouteCount() {
        return recordResult.size();
    }

    public int[] getRecord() {
        return recordResult.stream().mapToInt(i->i).toArray();
    }



    private void exploreMap() {
        for (int i = 1; i <= nodeCount; i++) {
            if(i == startNode) result[i] = 0;
            else result[i] = route[startNode][i];
        }
        visited[startNode] = true;

        for(int i = 1; i <= nodeCount; i++) {
            int index = minIndex();
            if(index == -1) {continue;}
            visited[index] = true;

//            int routeIndex = routeStoreIndex[index];
//            if(routeIndex == -1) continue;
            for( int j = 1; j <= nodeCount ;j++) {
                int useTarget = result[index] + route[index][j];
                if(result[j] > useTarget) {
                    record[j] = index;
                    result[j] = useTarget;
                }
            }
        }
    }

    private int minIndex() {
        int min = MAX;
        int index = -1;
        for (int i = 1; i <= nodeCount; i++) {
            if(min > result[i] && !visited[i]) {
                index = i; min = result[i];
            }
        }
        return index;
    }

}
