package Dijkstra;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ShortestRouteTest {

    @Test
    public void test1() {
        ShortestRoute sr = new ShortestRoute();

        int nodeCount = 5;
        int routeCount = 6;
        int startNode = 1;
        sr.initialize(nodeCount);

        sr.addRoute(new int[]{5,1}, 1);
        sr.addRoute(new int[]{1,2}, 2);
        sr.addRoute(new int[]{1,3}, 3);
        sr.addRoute(new int[]{2,3}, 4);
        sr.addRoute(new int[]{2,4}, 5);
        sr.addRoute(new int[]{3,4}, 6);

        sr.setStart(startNode);
        sr.run();
        int[] rst= sr.getResult();

        assertArrayEquals(rst, new int[]{0,0,2,3,7,ShortestRoute.MAX});
    }

    @Test
    public void test2() {
        ShortestRoute sr = new ShortestRoute();

        int nodeCount = 3;
        int routeCount = 2;
        int startNode = 3;
        sr.initialize(nodeCount);

        sr.addRoute(new int[]{1,3}, 10);
        sr.addRoute(new int[]{2,1}, 4);

        sr.setStart(startNode);
        sr.run();
        int[] rst= sr.getResult();

        assertArrayEquals(rst, new int[]{0,ShortestRoute.MAX,ShortestRoute.MAX, 0});
    }

    @Test
    public void test3() {
        ShortestRoute sr = new ShortestRoute();

        int nodeCount = 2;
        int routeCount = 1;
        int startNode = 2;
        sr.initialize(nodeCount);

        sr.addRoute(new int[]{2,1}, 1);

        sr.setStart(startNode);
        sr.run();
        int[] rst= sr.getResult();

        assertArrayEquals(rst, new int[]{0,1,0});
    }

    @Test
    public void test4() {
        ShortestRoute sr = new ShortestRoute();

        int nodeCount = 4;
        int routeCount = 8;
        int startNode = 1;
        sr.initialize(nodeCount);

        sr.addRoute(new int[]{1,2}, 3);
        sr.addRoute(new int[]{2,1}, 5);
        sr.addRoute(new int[]{4,3}, 4);
        sr.addRoute(new int[]{2,3}, 10);
        sr.addRoute(new int[]{1,3}, 10);
        sr.addRoute(new int[]{2,4}, 1);
        sr.addRoute(new int[]{3,1}, 1);
        sr.addRoute(new int[]{1,2}, 2);

        sr.setStart(startNode);
        sr.run();
        int[] rst= sr.getResult();

        assertArrayEquals(rst, new int[]{0,0,2,7,3});
    }

    @Test
    public void test5() {
        ShortestRoute sr = new ShortestRoute();

        int nodeCount = 12;
        int routeCount = 20;
        int startNode = 1;
        sr.initialize(nodeCount);

        sr.addRoute(new int[]{1,2}, 1);
        sr.addRoute(new int[]{1,3}, 1);
        sr.addRoute(new int[]{1,4}, 2);
        sr.addRoute(new int[]{1,5}, 2);
        sr.addRoute(new int[]{1,6}, 2);
        sr.addRoute(new int[]{1,7}, 2);
        sr.addRoute(new int[]{1,8}, 2);
        sr.addRoute(new int[]{1,9}, 3);
        sr.addRoute(new int[]{1,10}, 4);
        sr.addRoute(new int[]{1,11}, 5);

        sr.addRoute(new int[]{2,11}, 5);
        sr.addRoute(new int[]{3,11}, 4);
        sr.addRoute(new int[]{4,11}, 3);
        sr.addRoute(new int[]{5,11}, 2);
        sr.addRoute(new int[]{6,11}, 1);
        sr.addRoute(new int[]{7,10}, 1);
        sr.addRoute(new int[]{8,10}, 2);
        sr.addRoute(new int[]{9,10}, 3);
        sr.addRoute(new int[]{10,11}, 4);
        sr.addRoute(new int[]{1,11}, 10);

        sr.setStart(startNode);
        sr.run();
        int[] rst= sr.getResult();

        assertArrayEquals(rst, new int[]{0,0,1,1,2,2,2,2,2,3,3,3, ShortestRoute.MAX});
    }

    @Test
    public void test6() {
        ShortestRoute2 sr = new ShortestRoute2();

        int nodeCount = 2;
        int routeCount = 4;
        int startNode = 1;
        sr.initialize(nodeCount);

        sr.addRoute(new int[]{1,2}, 1);
        sr.addRoute(new int[]{1,2}, 2);
        sr.addRoute(new int[]{1,2}, 5);
        sr.addRoute(new int[]{1,2}, 10);

        sr.setStart(startNode);
        sr.run();
        int[] rst= sr.getResult();

        assertArrayEquals(rst, new int[]{ShortestRoute2.MAX,0,1});
    }
}
