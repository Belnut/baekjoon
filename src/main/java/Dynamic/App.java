package Dynamic;

import BaseKit.IQuize;

//7579 baekjoon
public class App implements IQuize {
    int[] dp;
    int[] memory;
    int[] cost;
    int size, needMemory;
    int maxCost;

    int result;

    public App(int[] memory, int[] cost, int needMemory) {
        this.memory = memory;
        this.cost = cost;
        size = cost.length;
        this.needMemory = needMemory;
        for(int i = 0 ; i < size; i++) {
            maxCost += cost[i];
        }
        dp = new int[maxCost+1];

    }

    @Override
    public void run() {
        for (int i = 0 ; i < size; i++) {
            for(int j = maxCost; j >= cost[i]; j--) {
                dp[j] = Integer.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }

        for(int i = 0 ; i < maxCost+1; i++) {
            if(needMemory <= dp[i]) {
                result = i;
                break;
            }
        }
    }

    int getResult() {
        return this.result;
    }
}
