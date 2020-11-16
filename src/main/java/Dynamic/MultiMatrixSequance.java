package Dynamic;

import BaseKit.IQuize;

public class MultiMatrixSequance implements IQuize {
    int result;

    int[] mat;
    int matCount;
    int[][] dp;

    public MultiMatrixSequance(int[] mat) {
        this.mat = mat;
        this.matCount = mat.length-1;
        this.dp = new int[matCount+1][matCount+1];
    }


    @Override
    public void run() {
        for (int i = 1; i <= matCount; i++) {
            for(int j = 1 ; j <= matCount-i; j++) {
                dp[j][i+j] = Integer.MAX_VALUE;
                for(int r = 0; r < i; r++) {
                    dp[j][j+i] = Integer.min(dp[j][i+j], dp[j][j+r] + dp[j+r+1][j+i] + (mat[j-1] * mat[j+r] * mat[i+j]));
                }
            }
        }

        result = dp[1][matCount];
    }

    int min(int a1, int a2) {
        return a1 > a2 ? a2 : a1;
    }

    public int result() {
        return this.result;
    }
}
