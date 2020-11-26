package DFS_BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HideAndSeek4 {
    public static final int MAX = 100000;
    int result;
    int[] record;
    int[] count;
    int hider;
    int seeker;

    public HideAndSeek4() {
        record = new int[MAX+1];
        count = new int[MAX+1];
        Arrays.fill(record, -1);
        Arrays.fill(count, -1);
    }

    public void setHider(int hider) {
        this.hider = hider;
    }

    public void setSeeker(int seeker) {
        this.seeker = seeker;
    }

    public int getResult() {
        return result;
    }

    public String getRecord() {
        StringBuilder sb = new StringBuilder();
        if(hider == seeker) {
            return seeker + "";
        }
        else if(seeker > hider) {
            for(int i = seeker; i > hider; i--) { sb.append(i + " "); }
            sb.append(hider);
        }
        else {
            int before = record[hider];
            Stack<Integer> stack = new Stack<>();
            stack.push(hider);
            while(before != -1) {
                stack.push(before);
                before = record[before];
            }
            while (true) {
                sb.append(stack.pop());
                if(!stack.isEmpty()) sb.append(" ");
                else break;
            }
        }
        return sb.toString();
    }

    public void run(){
        if(hider == seeker) {
            result = 0;
            return;
        }
        if(seeker > hider) {
            result = seeker - hider;
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(seeker);
        count[seeker] = 0;

        while(!queue.isEmpty()) {
            int t = queue.poll();
            int nextCost = count[t] + 1;

            int minus = t-1;
            int plus = t+1;
            int multi = t*2;

            if(minus > 0 && count[minus] == -1) {
                count[minus] = nextCost;
                record[minus] = t;
                if(minus == hider) break;
                queue.add(minus);
            }
            if(plus <= MAX && plus <= hider && count[plus] == -1) {
                count[plus] = nextCost;
                record[plus] = t;
                if(plus == hider) break;
                queue.add(plus);
            }

            if(multi <= MAX && count[multi] == -1) {
                count[multi] = nextCost;
                record[multi] = t;
                if(multi == hider) break;
                queue.add(multi);
            }
        }
        result = count[hider];
    }
}
