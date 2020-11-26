package Dynamic;

import java.util.Arrays;
import java.util.Set;

//2098 baekjoon 외판원 순회
public class TravelSalesmanProblem {
    static final int MAX = 16000001;
    private int nodeCount;
    private int dp[][];
    private int route[][];
    private int maxSubSet;

    public void initialize(int nodeCount) {
        this.nodeCount = nodeCount;
        maxSubSet = (1 << (nodeCount-1))-1;
        route = new int[nodeCount+1][nodeCount+1];
        dp = new int[nodeCount+1][maxSubSet+1];

        for (int i = 1; i <= nodeCount ; i++) {
            Arrays.fill(route[i], MAX);
            Arrays.fill(dp[i], MAX);
        }
    }

    public void addRoute(int x, int y, int cost) {
        if(cost == 0) return;
        route[x][y] = Integer.min(route[x][y], cost);
    }

    public void run() {
        exploreRoute();
    }

    public int getResult () {
        return minimum(1, maxSubSet);
    }

    private void exploreRoute() {
        for (int i = 2; i <= nodeCount; i++) {
            dp[i][0] = route[i][1];
        }

        for(int i = 1 ; i < nodeCount-1 ; i++) {
            for(int subA = 1; subA <= maxSubSet; subA++) {
                if(subSetCount(subA) != i) continue;
                for(int k = 2; k <= nodeCount; k++) {
                    if(subSetIsIn(subA, k)) continue;
                    dp[k][subA] = minimum(k, subA);
                }
            }
        }
    }

    //subSet에서 집합 제외 검색기능
    private int minimum(int k ,int subA) {
        int minVal = MAX;
        for (int i = 2; i <= nodeCount; i++) {
            if(!subSetIsIn(subA, i)) continue;
            int subSet = subSetDiff(subA, i);
            int v = route[k][i] + dp[i][subSet];
            if(minVal > v) {
                minVal = v;
            }
        }
        return minVal;
    }

    private int subSetDiff(int subA, int j) {
        j = 1 << (j-2);
        return subA & (~j);
    }

    private boolean subSetIsIn(int subSet, int x) {
        return (subSet & (1 << x-2)) != 0 ? true : false;
    }

    private int subSetCount(int t) {
        int count = 0;
        for(int i = 0; i < nodeCount-1; i++) {
            if( (t & (1 << (i))) != 0 ) count+=1;
        }
        return count;
    }

}
