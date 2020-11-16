package divideSearch;

import BaseKit.IQuize;

import java.util.Scanner;

//1300 baekjoon
public class KthNumber implements IQuize {

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);

        long n, k;
        n = sc.nextLong();
        k = sc.nextLong();

        long left = 1;
        long right = n * n;

        long rst = 0;

        while(left <= right) {
            long tmp = 0;
            long mid = (left + right) / 2 ;

            for(int i = 1; i <= n; i++)
                tmp += min(mid/i, n);

            if (tmp >= k ) {
                rst = mid;
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(rst);
    }

    public long min(long a, long b) {
        return a > b ? b : a;
    }
}
