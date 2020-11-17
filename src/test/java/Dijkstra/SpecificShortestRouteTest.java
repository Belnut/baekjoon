package Dijkstra;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SpecificShortestRouteTest {
    @Test
    public void test1() {
        int nodeCount= 4;
        int routeCount = 6;
        int[] midRoute = {2,3};

        SpecificShortestRoute ssr = new SpecificShortestRoute();
        ssr.initialize(nodeCount);

        ssr.addRoute(1, 2, 3);
        ssr.addRoute(2, 3, 3);
        ssr.addRoute(3, 4, 1);
        ssr.addRoute(1, 3, 5);
        ssr.addRoute(2, 4, 5);
        ssr.addRoute(1, 4, 6);

        ssr.setMidRoute(midRoute);
        ssr.run();

        assertThat(ssr.getResult(), is(7));
    }

    @Test
    public void test2() {
        int nodeCount= 4;
        int routeCount = 5;
        int[] midRoute = {2,3};

        SpecificShortestRoute ssr = new SpecificShortestRoute();
        ssr.initialize(nodeCount);

        ssr.addRoute(1, 3, 4);
        ssr.addRoute(1, 4, 6);
        ssr.addRoute(3, 4, 1);
        ssr.addRoute(4, 2, 2);
        ssr.addRoute(2, 3, 3);

        ssr.setMidRoute(midRoute);
        ssr.run();

        assertThat(ssr.getResult(), is(9));
    }

    @Test
    public void test3() {
        int nodeCount= 4;
        int routeCount = 6;
        int[] midRoute = {2,3};

        SpecificShortestRoute ssr = new SpecificShortestRoute();
        ssr.initialize(nodeCount);

        ssr.addRoute(1, 4, 1);
        ssr.addRoute(4, 2, 1);
        ssr.addRoute(2, 3, 1);
        ssr.addRoute(2, 4, 1);
        ssr.addRoute(3, 1, 1);

        ssr.setMidRoute(midRoute);
        ssr.run();

        assertThat(ssr.getResult(), is(3));
    }

    @Test
    public void test4() {
        int nodeCount= 4;
        int routeCount = 6;
        int[] midRoute = {2,3};

        SpecificShortestRoute ssr = new SpecificShortestRoute();
        ssr.initialize(nodeCount);

        ssr.addRoute(1, 3, 4);
        ssr.addRoute(1, 4, 6);
        ssr.addRoute(3, 4, 1);
        ssr.addRoute(2, 3, 3);

        ssr.setMidRoute(midRoute);
        ssr.run();

        assertThat(ssr.getResult(), is(11));
    }

    @Test
    public void test5() {
        int nodeCount= 4;
        int routeCount = 6;
        int[] midRoute = {2,3};

        SpecificShortestRoute ssr = new SpecificShortestRoute();
        ssr.initialize(nodeCount);

        ssr.addRoute(1, 3, 4);
        ssr.addRoute(1, 4, 6);
        ssr.addRoute(3, 4, 1);
        ssr.addRoute(4, 2, 2);

        ssr.setMidRoute(midRoute);
        ssr.run();

        assertThat(ssr.getResult(), is(9));
    }

    @Test
    public void test6() {
        int nodeCount= 4;
        int routeCount = 6;
        int[] midRoute = {2,3};

        SpecificShortestRoute ssr = new SpecificShortestRoute();
        ssr.initialize(nodeCount);

        ssr.addRoute(1, 3, 4);
        ssr.addRoute(1, 4, 6);
        ssr.addRoute(4, 2, 2);
        ssr.addRoute(2, 3, 3);

        ssr.setMidRoute(midRoute);
        ssr.run();

        assertThat(ssr.getResult(), is(9));
    }

    @Test
    public void test7() {
        int nodeCount= 4;
        int routeCount = 6;
        int[] midRoute = {2,3};

        SpecificShortestRoute ssr = new SpecificShortestRoute();
        ssr.initialize(nodeCount);

        ssr.addRoute(1, 4, 1);
        ssr.addRoute(4, 2, 1);
        ssr.addRoute(2, 3, 1);
        ssr.addRoute(2, 1, 1);
        ssr.addRoute(3, 2, 1);

        ssr.setMidRoute(midRoute);
        ssr.run();

        assertThat(ssr.getResult(), is(4));
    }

    @Test
    public void test8() {
        int nodeCount= 4;
        int routeCount = 5;
        int[] midRoute = {1,4};

        SpecificShortestRoute ssr = new SpecificShortestRoute();
        ssr.initialize(nodeCount);

        ssr.addRoute(1, 2, 3);
        ssr.addRoute(2, 3, 3);
        ssr.addRoute(3, 4, 1);
        ssr.addRoute(1, 3, 5);
        ssr.addRoute(2, 4, 5);

        ssr.setMidRoute(midRoute);
        ssr.run();

        assertThat(ssr.getResult(), is(6));
    }

    @Test
    public void test9() {
        int nodeCount= 4;
        int routeCount = 6;
        int[] midRoute = {1,4};

        SpecificShortestRoute ssr = new SpecificShortestRoute();
        ssr.initialize(nodeCount);

        ssr.addRoute(1, 2, 3);
        ssr.addRoute(2, 3, 3);
        ssr.addRoute(3, 4, 1);
        ssr.addRoute(1, 3, 5);
        ssr.addRoute(2, 4, 5);
        ssr.addRoute(1, 4, 4);

        ssr.setMidRoute(midRoute);
        ssr.run();

        assertThat(ssr.getResult(), is(4));
    }

    @Test
    public void test10() {
        int nodeCount= 4;
        int routeCount = 3;
        int[] midRoute = {2,3};

        SpecificShortestRoute ssr = new SpecificShortestRoute();
        ssr.initialize(nodeCount);

        ssr.addRoute(1, 4, 1);
        ssr.addRoute(2, 4, 2);
        ssr.addRoute(3, 4, 3);

        ssr.setMidRoute(midRoute);
        ssr.run();

        assertThat(ssr.getResult(), is(11));
    }

    @Test
    public void test11() {
        int nodeCount= 4;
        int routeCount = 1;
        int[] midRoute = {2,3};

        SpecificShortestRoute ssr = new SpecificShortestRoute();
        ssr.initialize(nodeCount);

        ssr.addRoute(1, 4, 6);

        ssr.setMidRoute(midRoute);
        ssr.run();

        assertThat(ssr.getResult(), is(-1));
    }

    @Test
    public void test12() {
        int nodeCount= 4;
        int routeCount = 6;
        int[] midRoute = {1,3};

        SpecificShortestRoute ssr = new SpecificShortestRoute();
        ssr.initialize(nodeCount);

        ssr.addRoute(1, 2, 3);
        ssr.addRoute(2, 3, 3);
        ssr.addRoute(3, 4, 1);
        ssr.addRoute(1, 3, 5);
        ssr.addRoute(2, 4, 5);
        ssr.addRoute(1, 4, 4);

        ssr.setMidRoute(midRoute);
        ssr.run();

        assertThat(ssr.getResult(), is(6));
    }

    @Test
    public void test13() {
        int nodeCount= 5;
        int routeCount = 4;
        int[] midRoute = {2,3};

        SpecificShortestRoute ssr = new SpecificShortestRoute();
        ssr.initialize(nodeCount);

        ssr.addRoute(1, 2, 3);
        ssr.addRoute(2, 5, 3);
        ssr.addRoute(3, 4, 1);
        ssr.addRoute(1, 5, 5);

        ssr.setMidRoute(midRoute);
        ssr.run();

        assertThat(ssr.getResult(), is(-1));
    }

    @Test
    public void test14() {
        int nodeCount= 4;
        int routeCount = 4;
        int[] midRoute = {2,3};

        SpecificShortestRoute ssr = new SpecificShortestRoute();
        ssr.initialize(nodeCount);

        ssr.addRoute(1, 2, 1);
        ssr.addRoute(1, 3, 1);
        ssr.addRoute(2, 3, 9);
        ssr.addRoute(2, 4, 9);
        ssr.addRoute(3, 4, 1);

        ssr.setMidRoute(midRoute);
        ssr.run();

        assertThat(ssr.getResult(), is(4));
    }

    @Test
    public void test15() {
        int nodeCount= 3;
        int routeCount = 4;
        int[] midRoute = {1,3};

        SpecificShortestRoute ssr = new SpecificShortestRoute();
        ssr.initialize(nodeCount);

        ssr.addRoute(1, 2, 1);
        ssr.addRoute(1, 3, 3);
        ssr.addRoute(2, 3, 1);

        ssr.setMidRoute(midRoute);
        ssr.run();

        assertThat(ssr.getResult(), is(2));
    }

    @Test
    public void test16() {
        int nodeCount = 7;
        int routeCount = 7;

        int[] midRoute = {2,6};

        SpecificShortestRoute ssr = new SpecificShortestRoute();
        ssr.initialize(nodeCount);

        ssr.addRoute(1, 2, 3);
        ssr.addRoute(3, 2, 5);
        ssr.addRoute(1, 3, 1);
        ssr.addRoute(6, 5, 3);
        ssr.addRoute(7, 5, 8);
        ssr.addRoute(5, 4, 2);
        ssr.addRoute(6, 4, 3);

        ssr.setMidRoute(midRoute);
        ssr.run();

        assertThat(ssr.getResult(), is(-1));
    }

    @Test
    public void test17() {
        int nodeCount = 800;
        int routeCount = 799;

        int[] midRoute = {1,800};

        SpecificShortestRoute ssr = new SpecificShortestRoute();
        ssr.initialize(nodeCount);

        for(int i = 1 ; i < nodeCount ; i++) {
            ssr.addRoute(i, i+1,1000);
        }

        ssr.setMidRoute(midRoute);
        ssr.run();

        assertThat(ssr.getResult(), is(799000));
    }

    @Test
    public void test18() {
        int nodeCount = 800;
        int routeCount = 0;

        int[] midRoute = {1,800};

        SpecificShortestRoute ssr = new SpecificShortestRoute();
        ssr.initialize(nodeCount);

        ssr.setMidRoute(midRoute);
        ssr.run();

        assertThat(ssr.getResult(), is(-1));
    }

    @Test
    public void test19() {
        int nodeCount = 4;
        int routeCount = 7;

        int[] midRoute = {2,3};

        SpecificShortestRoute ssr = new SpecificShortestRoute();
        ssr.initialize(nodeCount);

        ssr.addRoute(1, 2,3);
        ssr.addRoute(1, 2,10);
        ssr.addRoute(2, 3,3);
        ssr.addRoute(3, 4,1);
        ssr.addRoute(1, 3,5);
        ssr.addRoute(2, 4,5);
        ssr.addRoute(1, 4,4);

        ssr.setMidRoute(midRoute);
        ssr.run();

        assertThat(ssr.getResult(), is(7));
    }
}
