package DFS_BFS;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Tomato2Test {

    @Test
    public void test1() {
        int x = 3;
        int y = 5;
        int z = 1;

        int[][][] tomato = {{
                {0,-1,0,0,0},
                {-1,-1,0,0,0},
                {0,0,0,1,1}}};

        int[][] roots = {{0, 1, 3}, {0, 1, 4}, {0, 2, 3}, {0, 2, 4} };

        Tomato2 t2= new Tomato2();
        t2.initialize(tomato, roots);

        t2.run();

        assertThat(t2.getResult(), is(-1));
    }

    @Test
    public void test2() {
        int x = 3;
        int y = 5;
        int z = 2;

        int[][][] tomato = {
                {
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0}
                },
                {
                    {0, 0, 0, 0, 0},
                    {0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 0}
                }
        };

        int[][] roots = {{1, 1, 2} };

        Tomato2 t2= new Tomato2();
        t2.initialize(tomato, roots);

        t2.run();

        assertThat(t2.getResult(), is(4));
    }

    @Test
    public void test3() {
        int x = 3;
        int y = 4;
        int z = 2;

        int[][][] tomato = {
                {
                        {1, 1, 1, 1},
                        {1, 1, 1, 1},
                        {1, 1, 1, 1}
                },
                {
                        {1, 1, 1, 1},
                        {-1, -1, -1, -1},
                        {1, 1, 1, -1}
                }
        };

        int[][] roots = {
                {0,0,0},{0,0,1},{0,0,2},{0,0,3},
                {0,0,0},{0,1,1},{0,1,2},{0,1,3},
                {0,0,0},{0,2,1},{0,2,2},{0,2,3},
                {1,0,0},{1,0,1},{1,0,2},{1,0,3},
                {1,2,0},{1,2,1},{1,2,2}};

        Tomato2 t2= new Tomato2();
        t2.initialize(tomato, roots);

        t2.run();

        assertThat(t2.getResult(), is(0));
    }
}
