package Dynamic;

import BaseKit.IQuize;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileSum implements IQuize {
    int sum[];
    int dp[][];

    @Override
    public void run() {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());

            while(t-- != 0) {
                int k = Integer.parseInt(br.readLine());
                String[] tmp = br.readLine().split(" ");

                sum = new int[k+1];
                for (int i = 1; i <= k; i++)
                    sum[i] = Integer.parseInt(tmp[i-1]) + sum[i-1];

                dp = new int[k+1][k+1];

                for (int r = 1; r < k ; r++) {
                    for (int i = 1; i <= k-r; i++) {
                        dp[i][i+r] = Integer.MAX_VALUE;
                        for (int j = 0; j < r; j++ ) {
                            dp[i][i+r] = min(dp[i][i+r], dp[i][i+j] + dp[i+j+1][i+r] + sum[i+r] - sum[i-1] );
                        }
                    }
                }
                System.out.println(dp[1][k]);
            }
        }catch (IOException e) {
            System.out.println("input Error!");
            System.out.println(e.getMessage());
        }
    }

    int min (int a, int b) {
        return a > b ? b : a;
    }
}
