package DFS_BFS;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TomatoTest {
    @Test
    public void test1() {
        int[][] tomato = {
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,1}
        };
        int y = 6;
        int x = 4;
        int[][] roots = {{3,5}};

        Tomato t = new Tomato();
        t.initialize(tomato, roots, x, y);
        t.run();

        assertThat(t.getResult(), is(8));
    }

    @Test
    public void test2() {
        int[][] tomato = {
                {0,-1,0,0,0,0},
                {-1,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,1}
        };
        int y = 6;
        int x = 4;
        int[][] roots = {{3,5}};

        Tomato t = new Tomato();
        t.initialize(tomato, roots, x, y);
        t.run();

        assertThat(t.getResult(), is(-1));
    }

    @Test
    public void test3() {
        int[][] tomato = {
                {1,-1,0,0,0,0},
                {0,-1,0,0,0,0},
                {0,0,0,0,-1,0},
                {0,0,0,0,-1,1}
        };
        int y = 6;
        int x = 4;
        int[][] roots = {{3,5}, {0,0}};

        Tomato t = new Tomato();
        t.initialize(tomato, roots, x, y);
        t.run();

        assertThat(t.getResult(), is(6));
    }

    @Test
    public void test4() {
        int[][] tomato = {
                {-1,1,0,0,0},
                {0,-1,-1,-1,0},
                {0,-1,-1,-1,0},
                {0,-1,-1,-1,0},
                {0,0,0,0,0}
        };
        int y = 5;
        int x = 5;
        int[][] roots = {{0,1}};

        Tomato t = new Tomato();
        t.initialize(tomato, roots, x, y);
        t.run();

        assertThat(t.getResult(), is(14));
    }

    @Test
    public void test5() {
        int[][] tomato = {
                {1,-1},
                {-1,1}
        };
        int y = 2;
        int x = 2;
        int[][] roots = {{0,0}, {1,1}};

        Tomato t = new Tomato();
        t.initialize(tomato, roots, x, y);
        t.run();

        assertThat(t.getResult(), is(0));
    }

}
