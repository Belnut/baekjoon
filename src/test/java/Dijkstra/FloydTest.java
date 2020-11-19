package Dijkstra;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FloydTest {
    @Test
    public void test1() {
        int nodeCount = 5;
        int routeCount = 14;

        Floyd f = new Floyd();
        f.initialize(nodeCount);

        f.addRoute(1, 2, 2);
        f.addRoute(1, 3, 3);
        f.addRoute(1, 4, 1);
        f.addRoute(1, 5, 10);
        f.addRoute(2, 4, 2);
        f.addRoute(3, 4, 1);
        f.addRoute(3, 5, 1);
        f.addRoute(4, 5, 3);
        f.addRoute(3, 5, 10);
        f.addRoute(3, 1, 8);
        f.addRoute(1, 4, 2);
        f.addRoute(5, 1, 7);
        f.addRoute(3, 4, 2);
        f.addRoute(5, 2, 4);

        f.run();
        int[][] result = f.getResult();

        assertArrayEquals(result[1], new int[]{Floyd.MAX, 0, 2, 3, 1, 4});
        assertArrayEquals(result[2], new int[]{Floyd.MAX, 12, 0, 15, 2, 5});
        assertArrayEquals(result[3], new int[]{Floyd.MAX, 8, 5, 0, 1, 1});
        assertArrayEquals(result[4], new int[]{Floyd.MAX, 10, 7, 13, 0, 3});
        assertArrayEquals(result[5], new int[]{Floyd.MAX, 7, 4, 10, 6, 0});
   }

    @Test
    public void test2() {
        int nodeCount = 4;
        int routeCount = 7;

        Floyd f = new Floyd();
        f.initialize(nodeCount);

        f.addRoute(1, 2, 5);
        f.addRoute(1, 4, 8);
        f.addRoute(2, 1, 7);
        f.addRoute(2, 3, 9);
        f.addRoute(3, 1, 2);
        f.addRoute(3, 4, 4);
        f.addRoute(4, 3, 3);

        f.run();
        int[][] result = f.getResult();

        assertArrayEquals(result[1], new int[]{Floyd.MAX, 0, 5, 11, 8});
        assertArrayEquals(result[2], new int[]{Floyd.MAX, 7, 0, 9, 13});
        assertArrayEquals(result[3], new int[]{Floyd.MAX, 2, 7, 0, 4});
        assertArrayEquals(result[4], new int[]{Floyd.MAX, 5, 10, 3, 0});
    }
}
