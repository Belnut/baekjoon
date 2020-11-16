package Tmp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Test4T {
    @Test
    public void test1() {
        Test4 t4 = new Test4();
        int rst = t4.solution(3, new int[][] {{3,5,6},{9,2,7},{4,1,8}});
        assertThat(rst ,is(22));
    }
}
