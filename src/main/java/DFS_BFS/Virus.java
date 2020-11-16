package DFS_BFS;

import BaseKit.IQuize;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//2606 baekjoon 바이러스
public class Virus implements IQuize {

    ArrayList<Integer>[] routes;
    Queue<Integer> bfsQueue;
    boolean[] isEntered;
    int startNode;
    int result;

    public Virus(int[][] routes, int nodeCount, int startNode) {
        this.routes = new ArrayList[nodeCount+1];
        this.bfsQueue = new LinkedList<>();
        this.isEntered = new boolean[nodeCount+1];
        this.startNode = startNode;

        for(int[] route : routes){
            int x = route[0];
            int y = route[1];

            if(this.routes[x] == null) {
                this.routes[x] = new ArrayList<Integer>();
            }
            this.routes[x].add(y);
            if(this.routes[y] == null) {
                this.routes[y] = new ArrayList<Integer>();
            }
            this.routes[y].add(x);
        }
    }

    @Override
    public void run() {
        moveBFS();
    }

    public void moveBFS () {
        result = 0;
        bfsQueue.clear();

        for(int i = 1 ; i < isEntered.length ;i++) {
            isEntered[i] = false;
        }

        int targetNode;
        bfsQueue.add(startNode);
        isEntered[startNode] = true;
        while(!bfsQueue.isEmpty()) {
            targetNode = bfsQueue.poll();

            if(routes[targetNode] == null)
                continue;

            for(int i = 0; i < routes[targetNode].size(); i++) {
                int moveNode = routes[targetNode].get(i);
                if(isEntered[moveNode] == false) {
                    bfsQueue.add(moveNode);
                    isEntered[moveNode] = true;
                    result++;
                }
            }
        }
    }

    public int getResult() {
        return this.result;
    }
}
