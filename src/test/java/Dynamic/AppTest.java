package Dynamic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AppTest {
    @Test
    public void test1() {
        int needMemory = 60;
        int[] cost = {3, 0, 3, 5, 4};
        int[] memory = {30, 10, 20, 35, 40};

        App app = new App(memory, cost, needMemory);
        app.run();

        assertThat(app.getResult(), is(6));
    }
}
