package programmers.level2;

import org.junit.Test;
import java.util.*;

import static org.junit.Assert.assertArrayEquals;

public class FundCost {
    @Test
    public void solution() {
        int[] prices = {1, 2, 3, 2, 1, 5, 4, 2};


        int length = prices.length;
        int[] answer = new int[length];

        Stack<Integer> stack = new Stack<>();
        stack.push(prices[length-1]);
        answer[length-1] = 0;

        for(int i = length-2; i >= 0; i--) {
            int t = prices[i];

            if(stack.peek() >= t) {
                answer[i] = length - (i+1);
                stack.push(t);
            }
            else{
                if(prices[i] <= prices[i+1]) {
                    int k = i;
                    while(k < length && prices[i] <= prices[k]) {
                        answer[i]++;
                        k++;
                    }
                }
                else
                    answer[i] = 1;
            }
        }

        assertArrayEquals(answer, new int[]{7, 3, 1, 1, 3, 1, 1, 0});
    }
}
