package Dynamic;

import BaseKit.IQuize;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coin1 implements IQuize {
    private int[] dp;
    private int[] coin;
    @Override
    public void run() {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] tmp = br.readLine().split(" ");

            int n = Integer.parseInt(tmp[0]);
            int k = Integer.parseInt(tmp[1]);

            dp = new int[k+1];
            coin = new int[n];


            for (int i =0; i< n ; i++) {
                coin[i] = Integer.parseInt(br.readLine());
            }

            dp[0] = 1;

            for(int i = 0 ; i < n ; i++ ) {
                for (int j = coin[i] ; j <= k ; j++) {
                    dp[j] += dp[j - coin[i]];
                }
            }

            System.out.println(dp[k]);
        }catch (IOException e) {
            System.out.println("Input Error");
            System.out.println(e.getMessage());
        }
    }
}
