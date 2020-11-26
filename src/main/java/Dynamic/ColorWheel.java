package Dynamic;

import java.util.Collection;

public class ColorWheel {
    private static final long MOD = 1000000003;
    private long[][] dp;
    private int colorCount;
    private int choiceCount;
    private long result;

    public void initialize(int ColorCount) {
        this.colorCount = ColorCount;
        dp = new long[ColorCount+1][ColorCount+1];
    }

    public void setChoiceCount(int choiceCount) {
        this.choiceCount = choiceCount;
    }

    public void run() {
        findKind();
    }
    public long getResult() {
        return result;
    }

    private void findKind() {
        if(choiceCount == 1) {
            result = colorCount; return;
        }
        if(colorCount%2 == 0 && choiceCount == colorCount/2) {
            result = colorCount/2; return;
        }
        if(colorCount/2 < choiceCount) {
            result = 0; return;
        }

        dp[2][1] = 2;
        dp[3][1] = 3;
        for(int i = 4 ; i <= colorCount; i++) {
            dp[i][1] = i;
            for(int j = 2; j <= choiceCount; j++) {
                dp[i][j] = (dp[i-2][j-1] + dp[i-1][j]) % MOD;
            }
        }

        result = dp[colorCount][choiceCount];
    }
}
