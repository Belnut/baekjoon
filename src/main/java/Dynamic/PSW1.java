package Dynamic;

import java.util.ArrayList;

public class PSW1 {
    private static final int LENGTH_MAX = 50;
    private int n;
    private int k;
    private int ten[];
    private int len[];
    private ArrayList<String> num;

    private int a[];
    private long dp[][];

    public void initialize(int n) {
        this.n = n;

        num = new ArrayList<>();
        a = new int[n];
        len = new int[n];
    }

    public void addV(String v) {
        len[this.num.size()] = v.length();
        this.num.add(v);
    }

    public void setK(int k) {
        this.k = k;
        dp = new long[(1 << n)][k];

        ten = new int[LENGTH_MAX+1];  //10의 i승의 k 모듈러값
        ten[0] = 1;
        for (int i = 1; i <= 50; i++) {
            ten[i] = ten[i - 1] * 10;
            ten[i] %= k;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < len[i]; j++) {
                a[i] = a[i] * 10 + (num.get(i).charAt(j) - '0');
                a[i] %= k;
            }
        }
    }

    public void run() {
        tsp();
    }

    public void tsp() {
        dp[0][0] = 1;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < n; l++) {
                    if ((i & (1 << l)) == 0) {
                        int next = j * ten[len[l]];
                        next %= k;
                        next += a[l];
                        next %= k;
                        dp[i | (1 << l)][next] += dp[i][j];
                    }
                }
            }
        }
    }

    public String getResult() {
        long t1 = dp[(1 << n) - 1][0];
        long t2 = 1;
        for (long i = 2; i <= n; i++) t2 *= i;
        long g = gcd(t1, t2);
        t1 /= g;
        t2 /= g;
        return t1 + "/" + t2;
    }
    public long gcd(long a1, long a2) {
        if (a2 == 0) return a1;
        return gcd(a2, a1 % a2);
    }
}
