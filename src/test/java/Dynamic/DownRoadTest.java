package Dynamic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DownRoadTest {
    @Test
    public void test1() {
        short[][] mat = { {50, 45, 37, 32 ,30}, {35, 50, 40, 20 ,25}, {30, 30, 25, 17 ,28}, {27, 24, 22, 15 ,10}};
        DownRoad dr= new DownRoad(mat);
        dr.run();
        assertThat(dr.getResult() ,is(3));
    }
}
