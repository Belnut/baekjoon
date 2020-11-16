package Dynamic;

import BaseKit.IQuize;

//10942 baekjoon 펠린드돔?
public class PalindromCheck implements IQuize {
    int[] data;
    boolean[][] dp;

    public PalindromCheck(int[] data) {
        int size = data.length;
        this.data = data;

        dp = new boolean[size][size];
        for (int i = 0 ; i < size; i++) {
            for(int j = 0; j <size; j++) {
                dp[i][j] = true;
            }
        }
    }

    @Override
    public void run() {
        int size = data.length;

        for(int i = 1; i < size; i++ ) {
            for (int j = 0; j < size-i; j++) {
                dp[j][j+i] = data[j] == data[j+i] && dp[j+1][j+i-1];
            }
        }
    }

    public boolean checkPalindrom(int start, int end) {
        return dp[start][end];
    }
}
