package Dynamic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//9019 baekjoon DSLR
public class DSLR {
    private static final int MAX_VAlUE = 10000;
    private static final char NO_COMMEND = ' ';
    private boolean[] visiited;
    private int[] dp;
    private char[] commend;
    private int start;
    private int end;

    public DSLR () {
        visiited = new boolean[MAX_VAlUE];
        dp = new int[MAX_VAlUE];
        commend = new char[MAX_VAlUE];
    }

    public void inputCase(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        Arrays.fill(dp, -1);
        Arrays.fill(commend, NO_COMMEND);
        Arrays.fill(visiited, false);

        Queue<Integer> queue = new LinkedList<>();

        dp[start] = 0;
        queue.add(start);
        while (!queue.isEmpty()) {
            int target = queue.poll();
            if(target == end) break;

            int cmd_D_val = (target * 2) % MAX_VAlUE;
            int cmd_S_val = (target == 0 ? 9999 : target - 1);
            int cmd_L_val = (target % 1000) * 10 + (target / 1000) ;
            int cmd_R_val = (target / 10) + (target % 10) * 1000;

            if(!visiited[cmd_D_val]) {
                dp[cmd_D_val] = target;
                visiited[cmd_D_val] = true;
                commend[cmd_D_val] = 'D';
                queue.add(cmd_D_val);

                if (cmd_D_val == end) break;
            }
            if(!visiited[cmd_S_val]) {
                dp[cmd_S_val] = target;
                visiited[cmd_S_val] = true;
                commend[cmd_S_val] = 'S';
                queue.add(cmd_S_val);

                if (cmd_S_val == end) break;
            }
            if(!visiited[cmd_L_val]) {
                dp[cmd_L_val] = target;
                visiited[cmd_L_val] = true;
                commend[cmd_L_val] = 'L';
                queue.add(cmd_L_val);

                if (cmd_L_val == end) break;
            }
            if(!visiited[cmd_R_val]) {
                dp[cmd_R_val] = target;
                visiited[cmd_R_val] = true;
                commend[cmd_R_val] = 'R';
                queue.add(cmd_R_val);

                if (cmd_R_val == end) break;
            }
        }
    }

    String getRecord() {
        if(start == end) {
            return "";
        }
        Stack<Character> st = new Stack<>();

        int nextVal = end;
        while (nextVal != start) {
            st.add(commend[nextVal]);
            nextVal = dp[nextVal];
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();
    }
}
