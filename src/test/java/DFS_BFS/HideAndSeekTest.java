package DFS_BFS;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HideAndSeekTest {
    @Test
    public void test1() {
        int start = 5;
        int end = 17;
        HideAndSeek has = new HideAndSeek();
        has.initialize(start, end);
        has.run();

        assertThat(has.getResult() ,is(4));
    }
    @Test
    public void test2() {
        int start = 100;
        int end = 0;
        HideAndSeek has = new HideAndSeek();
        has.initialize(start, end);
        has.run();

        assertThat(has.getResult() ,is(100));
    }
    @Test
    public void test3() {
        int start = 2;
        int end = 16;
        HideAndSeek has = new HideAndSeek();
        has.initialize(start, end);
        has.run();

        assertThat(has.getResult() ,is(3));
    }
}
