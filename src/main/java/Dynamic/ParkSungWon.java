package Dynamic;

import java.util.ArrayList;
import java.util.Arrays;

public class ParkSungWon {
    private static final int LENGTH_MAX = 50;
    private int n;
    private int k;
    private int ten[];
    private int length[];
    private ArrayList<String> v;
   
    private int a[];
    private long dp[][];

    public void initialize(int n) {
        this.n = n;

        v = new ArrayList<>();
        a = new int[n];
        length = new int[n];
        ten = new int[LENGTH_MAX+1];
    }

    public void addV(String v) {
        length[this.v.size()] = v.length();
        this.v.add(v);
    }

    public void setK(int k) {
        this.k = k;
        dp = new long[(1 << n)][k];

        int tmp = 10;
        for( int i = 1; i <= LENGTH_MAX; i++) {
            ten[i] = tmp % k;
            tmp = ten[i] * 10;
        }

        for (int i = 0 ; i < v.size(); i++) {
            String t = v.get(i);
            tmp = (t.charAt(0) - '0');
            tmp %= k;
            for(int j = 1; j < t.length() ; j++) {
                tmp *= 10;
                tmp += (t.charAt(j) - '0');
                tmp %= k;
            }
            a[i] = tmp;
        }
    }

    public void run() {
        tsp();
    }

    public void tsp() {
        for (int i = 1; i < (1<< n); i++) {
            for (int j = 0; j < k; j++) {
                for(int l = 0; l < n; l++) {
                    if( !isIn(i, l) ) continue;
                    int bf = diff(i, l);
                    if( bf == 0 ) { //요소 하나로만 수열을 만드는 경우
                        dp[i][a[l]] = 1;
                        break;
                    } else {
                        if(dp[bf][j] == 0) continue;
                        int next = j * ten[length[l]];
                        next %= k;
                        next += a[l];
                        next %= k;
                        dp[i][next] += dp[bf][j];
                    }
                }
            }
        }
    }

    public boolean isIn(int subSet, int t) {
        return (subSet & (1 << t)) != 0;
    }

    public int diff(int subSet, int t) {
        return subSet & (~ (1 << t) );
    }

    public String getResult() {
        long numerator = dp[(1<<n)-1][0];
        long denominator = 1;
        for(int i = 2; i <= n; i++) {
            denominator *= i;
        }

        if(numerator == 0)
            return "0/1";

        if(numerator == denominator)
            return "1/1";

        long g = gcd(numerator, denominator);

        numerator /= g;
        denominator /= g;

        return new String(numerator + "/" + denominator);
    }
    public long gcd(long a1, long a2) {
        if (a2 == 0) return a1;
        return gcd(a2, a1 % a2);
    }
}
