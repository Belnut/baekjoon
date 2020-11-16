package DFS_BFS;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BreakThroughTest {
    @Test
    public void test1() {
        byte[][] maze = {
                {0,1,0,0},
                {1,1,1,0},
                {1,0,0,0},
                {0,0,0,0},
                {0,1,1,1},
                {0,0,0,0}};

        BreakThrough bt = new BreakThrough();
        bt.initialize(maze);
        bt.run();
        assertThat(bt.getResult() ,is(15));
    }

    @Test
    public void test2() {
        byte[][] maze = {
                {0,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,0}};

        BreakThrough bt = new BreakThrough();
        bt.initialize(maze);
        bt.run();
        assertThat(bt.getResult() ,is(-1));
    }
    @Test
    public void test3() {
        byte[][] maze = {
                {0,0,0,0},
                {1,1,1,0},
                {0,0,0,0},
                {0,1,1,1},
                {0,0,0,0}};

        BreakThrough bt = new BreakThrough();
        bt.initialize(maze);
        bt.run();
        assertThat(bt.getResult() ,is(8));
    }
    @Test
    public void test4() {
        byte[][] maze = {
                {0,0,0,0},
                {1,1,1,0},
                {0,0,0,0},
                {1,1,1,1},
                {0,0,0,0}};

        BreakThrough bt = new BreakThrough();
        bt.initialize(maze);
        bt.run();
        assertThat(bt.getResult() ,is(8));
    }
}


