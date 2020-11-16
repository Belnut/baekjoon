package DFS_BFS;
import BaseKit.IQuize;
import java.util.*;


public class DFSandBFS implements IQuize {
    ArrayList<Integer>[] routes;
    Stack<Integer> dfsStack;
    Queue<Integer> bfsQueue;
    int nodeCount;
    int startNode;

    ArrayList<Integer> dfsResult;
    ArrayList<Integer> bfsResult;

    boolean[] isEntered;

    public DFSandBFS(int[][] routes, int nodeCount, int startNode ) {
        this.nodeCount = nodeCount;
        this.startNode = startNode;
        this.dfsStack = new Stack<>();
        this.bfsQueue = new LinkedList<>();
        this.routes = new ArrayList[nodeCount+1];

        for (int[] route: routes) {
            int x = route[0];
            int y = route[1];

            if(this.routes[x] == null)
                this.routes[x] = new ArrayList<>();
            this.routes[x].add(y);

            if(this.routes[y] == null)
                this.routes[y] = new ArrayList<>();
            this.routes[y].add(x);
        }

        for(int i = 1; i <= nodeCount; i++) {
            if (this.routes[i] != null) {
                Collections.sort(this.routes[i]);
            }
        }

        isEntered = new boolean[nodeCount + 1];
        dfsResult = new ArrayList<>();
        bfsResult = new ArrayList<>();
    }

    @Override
    public void run() {
        moveDFS();
        moveBFS();
    }

    public void moveDFS() {
        for(int i = 1 ; i <= nodeCount; i++) {
            isEntered[i] = false;
        }
        dfsStack.clear();

        int targetNode = this.startNode;
        int index = 1;
        dfsStack.push(targetNode);
        dfsResult.add(targetNode);
        isEntered[targetNode] = true;
        boolean moved = false;
        while(!dfsStack.isEmpty()) {
            targetNode = dfsStack.lastElement();
            if(routes[targetNode] == null ) {
                dfsStack.pop();
                continue;
            }
            for (int i = 0; i < routes[targetNode].size(); i++) {
                int moveNode = routes[targetNode].get(i);
                if( isEntered[moveNode] == false) {
                    dfsStack.push(moveNode);
                    isEntered[moveNode] = true;
                    dfsResult.add(moveNode);
                    targetNode = moveNode;
                    moved = true;
                    break;
                }
            }

            if(moved == false) {
                dfsStack.pop();
            }
            moved = false;
        }
    }

    public void moveBFS() {
        for(int i = 1 ; i <= nodeCount; i++) {
            isEntered[i] = false;
        }
        bfsQueue.clear();

        int targetNode = this.startNode;
        int index = 1;
        bfsQueue.add(targetNode);
        bfsResult.add(targetNode);
        isEntered[targetNode] = true;
        while(!bfsQueue.isEmpty()) {
            targetNode = bfsQueue.poll();
            if(routes[targetNode] == null ) {
                continue;
            }
            for (int i = 0; i < routes[targetNode].size(); i++) {
                int moveNode = routes[targetNode].get(i);
                if( isEntered[moveNode] == false) {
                    bfsQueue.add(moveNode);
                    isEntered[moveNode] = true;
                    bfsResult.add(moveNode);
                }
            }
        }
    }
}
