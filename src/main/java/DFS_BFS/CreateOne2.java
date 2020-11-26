package DFS_BFS;

import BaseKit.IQuize;

import java.util.*;


public class CreateOne2 implements IQuize {
    public static final int MAX = 1000000;
    int data;
    int record[];
    int dp[];
    int result;

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public void run() {
        record = new int [MAX+1];
        record[data] = -1;

        dp = new int[data+1];
        Arrays.fill(dp, MAX);
        dp[data] = 0;

        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, data));
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            int cost = n.cost + 1;
            int value = n.value;

            if(value % 3 == 0 && dp[value/3] > cost ) {
                queue.add(new Node(cost, value/3));
                record[value/3] = value;
                dp[value/3] = cost;
                if(value / 3 == 1) {
                    result = cost;
                    break;
                }
            }
            if(value % 2 == 0 && dp[value/2] > cost) {
                queue.add(new Node(cost, value/2));
                record[value/2] = value;
                dp[value/2] = cost;
                if(value / 2 == 1) {
                    result = cost;
                    break;
                }
            }
            if(dp[value-1] > cost) {
                queue.add(new Node(cost, value - 1));
                record[value - 1] = value;
                dp[value-1] = cost;
                if (value - 1 == 1) {
                    result = cost;
                    break;
                }
            }
        }
    }

    public int getResult() {
        return result;
    }

    public String getRecord() {
        int r = 1;
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(r != -1) {
            st.push(r);
            r = record[r];
        }

        while(true){
            sb.append(st.pop());
            if(!st.isEmpty()) {
                sb.append(" ");
            } else {
                break;
            }
        }
        return sb.toString();
    }

    private static class Node implements Comparable<Node> {
        int cost = 0;
        int value = 0;
        public Node(int cost, int value) {
            this.cost = cost;
            this.value = value;
        }

        @Override
        public int compareTo(Node node) {
            if(this.cost == node.cost) return this.value > node.value ? -1 : 1;
            return this.cost > node.cost ? 1 : -1;
        }
    }
}
