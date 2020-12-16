package Tmp3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;

public class FailPercentageTest {

    @Test
    public void test1() {
        int[] answer;

        int N =4;
        int[] stages= {4, 4, 4, 4, 4};

        Arrays.sort(stages);

        int num = 1;
        int count = 0;
        int total = stages.length;

        ArrayList<Stage> s = new ArrayList<>();
        for(int i = 0; i< stages.length; i++) {
            int t = stages[i];
            if(t != num) {
                double per = (count == 0 ? 0 : (double)count/total);
                s.add(new Stage(num, per));
                num++; i--;
                total = total-count;
                count = 0;
                if(t > N) {
                    break;
                }
            }
            else {
                count++;
            }
        }

        if(count != 0 ) {
            double per = (double)count/total;
            s.add(new Stage(num, per));
            num++;
        }

        for(int i = num; i<= N; i++) {
            s.add(new Stage(i, 0));
        }

        Collections.sort(s);

        answer = new int[s.size()];
        for(int i = 0 ; i<s.size(); i++) {
            answer[i] = s.get(i).stageNumber;
        }

        assertArrayEquals( answer , new int[]{4,1,2,3});
    }

    static class Stage implements Comparable<Stage> {
        int stageNumber;
        double p_fail;

        public Stage(int stageNumber, double p_fail) {
            this.stageNumber = stageNumber;
            this.p_fail = p_fail;
        }

        @Override
        public int compareTo(Stage s) {
            if(this.p_fail == s.p_fail) {
                return this.stageNumber < s.stageNumber ? -1 : 1;
            }
            return this.p_fail > s.p_fail ? -1 : 1;
        }
    }
}
