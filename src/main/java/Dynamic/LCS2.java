package Dynamic;

import java.util.Stack;

public class LCS2 {
    private int dp[][];
    private String target;
    private String compare;

    public void setTarget(String target) {
        this.target = target;
    }

    public void setCompare(String compare) {
        this.compare = compare;
    }

    public void run() {
        dp = new int[compare.length() + 1][target.length() + 1];
        for (int i = 1; i <= compare.length() ; i++) {
            char c = compare.charAt(i-1);
            for (int j = 1; j <= target.length(); j++) {
                if(c == target.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1 ;
                } else {
                    dp[i][j] = Integer.max( dp[i-1][j], dp[i][j-1]);
                }
            }
        }
    }

    public int getResult() {
        return dp[compare.length()][target.length()];
    }

    public String getRecord() {
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        int i = compare.length();
        int j = target.length();
        int count = dp[i][j];

        while( i != 0 && j != 0 && count != 0) {

            if(dp[i-1][j] == count) {
                i-=1;
            } else if (dp[i][j-1] == count) {
                j-=1;
            } else {
                stack.push(compare.charAt(i-1));
                i-=1;j-=1;
                count --;
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
