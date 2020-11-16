package Tmp;

import org.junit.Test;

public class Test7T {
    @Test
    public void test1() {
        Test7 t = new Test7();

        int[][] rst = t.solution(4, true);

    }

    @Test
    public void test2() {
        Test6 t = new Test6();

        t.solution(new String[] {"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"});
    }
}
