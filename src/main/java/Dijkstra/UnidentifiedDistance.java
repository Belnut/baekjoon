package Dijkstra;

import BaseKit.IQuize;
import org.w3c.dom.Node;

import javax.xml.stream.XMLInputFactory;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UnidentifiedDistance implements IQuize {
    public static final int MAX = 2000000;
    private int nodeCount;
    private int startNode;
    private int[] candidate;
    private int[] midRoute;
    private int midRouteCost;

    private ArrayList<ArrayList<NextRoute>> route;
    private int[] routeIndex;

    private int[] result;

    public void initialize(int nodeCount) {
        this.nodeCount = nodeCount;
        route = new ArrayList<>();
        routeIndex = new int[nodeCount+1];
        midRouteCost = MAX;
        Arrays.fill(routeIndex, -1);
    }

    public void setStartNode(int startNode) {
        this.startNode = startNode;
    }

    public void setCandidate(int[] candidate) {
        this.candidate = candidate;
    }

    public void setMidRoute(int[] midRoute) {
        this.midRoute = midRoute;
    }
    public void setMidRoute (int x, int y) {
        this.setMidRoute(new int[]{x,y});
    }

    public void addRoute(int x, int y, int cost) {
        this.addRoute(new int[]{x,y}, cost);
        this.addRoute(new int[]{y,x}, cost);
    }

    private void addRoute(int[] loc, int cost) {
        if(routeIndex[loc[0]] == -1) {
            routeIndex[loc[0]] = route.size();
            route.add(new ArrayList<>());
        }
        int index = routeIndex[loc[0]];
        route.get(index).add(new NextRoute(loc[1], cost));

        if(Arrays.equals(loc, midRoute)) {
            midRouteCost = Integer.min(midRouteCost, cost);
        }
    }

    public int[] getResult() {
        return result;
    }

    @Override
    public void run() {
        int sToM1 = Dijkstra(startNode, midRoute[0]);
        int sToM2 = Dijkstra(startNode, midRoute[1]);

        int[] m1ToE = Dijkstra(midRoute[0]);
        int[] m2ToE = Dijkstra(midRoute[1]);

        int[] stoE = Dijkstra(startNode);
        int[] sme = new int[nodeCount+1];

        ArrayList<Integer> rst = new ArrayList<>();
        for (int i : candidate) {
            sme[i] = Integer.min(sToM1 + midRouteCost + m2ToE[i], sToM2 + midRouteCost + m1ToE[i]);

            if(stoE[i] < MAX && stoE[i] >= sme[i]) {
                rst.add(i);
            }
        }
        Collections.sort(rst);
        result = rst.stream().mapToInt(i -> i).toArray();
    }

    private int[] Dijkstra(int start) {
        int[] d = new int[nodeCount+1];
        Arrays.fill(d, MAX);
        boolean[] visited = new boolean[nodeCount+1];

        d[start] = 0;

        for(int i = 1; i <= nodeCount; i++) {
            int tNode = findShortestRoute(d, visited);
            if(tNode == -1) { break; }
            visited[tNode] = true; //방문체크

            int routeIndex = this.routeIndex[tNode];
            if(routeIndex == -1) { continue; }
            int[] bd = d.clone();
            for (NextRoute nr : route.get(routeIndex)) {
                d[nr.nextNode] = Integer.min( d[nr.nextNode], bd[tNode] + nr.cost );
            }
        }
        return d;
    }

    private int Dijkstra(int start, int end) {
        if(start == end)
            return 0;

        return Dijkstra(start)[end];
    }

    private int findShortestRoute( int[] d, boolean[] visited ) {
        int min = MAX;
        int index = -1;
        for (int i = 1; i <= nodeCount; i++) {
            if ( !visited[i] && min > d[i]) {
                index = i;
                min = d[i];
            }
        }
        return index;
    }

    static class NextRoute {
        int nextNode;
        int cost;

        public NextRoute(int nextNode, int cost) {
            this.nextNode = nextNode;
            this.cost = cost;
        }
    }
}
