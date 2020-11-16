package divideSearch;

import BaseKit.IQuize;

import java.util.Arrays;
import java.util.Scanner;

//baekjoon 2110
public class InstallRouter implements IQuize {

    public void run() {
        int n, c;
        int[] routers;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        c = sc.nextInt();

        routers = new int[n];
        for (int i = 0; i < n; i++) {
            routers[i] = sc.nextInt();
        }

        Arrays.sort(routers);

        int left = routers[0];
        int right = routers[n-1] - routers[0];
        int rst = 1;

        while(left <= right) {
            int installCount = 1;
            int start = routers[0];
            int mid = (left + right) / 2;
            int d;

            for(int i = 1; i < n; i++) {
                d = routers[i] - start;
                if( mid <= d) {
                    ++installCount;
                    start = routers[i];
                }
            }

            if(installCount >= c ) {
                rst = mid;
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }
        System.out.println(rst);
    }

}
