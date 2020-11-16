package Tmp;

import org.junit.Test;

public class Test3T {
    @Test
    public void test1() {
        Test3 t3 = new Test3();
        int rst = t3.solution(1000, new String[] {"H", "T", "H", "T", "H", "T", "H"}, new String[] {"T", "T", "H", "H", "T", "T", "H"});
    }
}
