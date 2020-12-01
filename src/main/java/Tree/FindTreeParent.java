package Tree;

import java.util.ArrayList;

public class FindTreeParent {
    ArrayList<Integer>[] tree;
    int [] parent;
    int size;

    public void setSize(int size) {
        this.size = size;
        tree = new ArrayList[size+1];
        for(int i = 1; i<= size; i ++) {
            tree [i] = new ArrayList<>();
        }
        parent = new int[size+1];
    }
    public void addRoute(int p, int c) {
        tree[p].add(c);
        tree[c].add(p);
    }

    public void run() {
        parent[1] = -1;
        dfs(1);
    }

    private void dfs(int p) {
        for(int c : tree[p]) {
            if(parent[c] != 0) continue;

            parent[c] = p;
            dfs(c);
        }
    }

    public int getParent(int c) {
        return parent[c];
    }

}
