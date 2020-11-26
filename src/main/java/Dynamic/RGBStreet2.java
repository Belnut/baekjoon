package Dynamic;

public class RGBStreet2 {
    private static final int MAX = 1000001;
    public static final int R = 0;
    public static final int G = 1;
    public static final int B = 2;
    private int[][] dp;
    private int[][] color;
    private int houseCount;
    private int result;


    public void initialize(int houseCount) {
        this.houseCount = houseCount;
        dp = new int[houseCount][3];
        color = new int[houseCount][3];

        result = 0;
    }

    public void add(int houseNum, int RGB, int cost) {
        color[houseNum][RGB] = cost;
    }

    public void run() {
        painting();
    }

    public void painting() {
        result = MAX;
        for(int i = 0 ; i < 3; i++) {
            //선정된 색 외의 나머지 색 제외
            for(int j = 0; j < 3; j++) {
                if(i == j) dp[0][j] = color[0][i];
                else dp[0][j] = MAX;
            }

            //계산
            for(int j = 1; j < houseCount; j++) {
                dp[j][R] = Integer.min(dp[j-1][G] + color[j][R], dp[j-1][B] + color[j][R]);
                dp[j][G] = Integer.min(dp[j-1][R] + color[j][G], dp[j-1][B] + color[j][G]);
                dp[j][B] = Integer.min(dp[j-1][R] + color[j][B], dp[j-1][G] + color[j][B]);
            }

            //최소값 확인
            for(int j = 0; j < 3; j++) {
                if (i != j) result = Integer.min(result, dp[houseCount-1][j]);
            }
        }
    }

    public int getResult() {
        return result;
    }
}
