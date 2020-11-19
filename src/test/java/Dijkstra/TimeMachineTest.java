package Dijkstra;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TimeMachineTest {
    @Test
    public void test1() {
        int nodeCount = 3;
        int routeCount = 4;

        TimeMachine tm = new TimeMachine();
        tm.initialize(nodeCount);

        tm.addRoute(1 ,2 ,4);
        tm.addRoute(1 ,3 ,3);
        tm.addRoute(1 ,3 ,5);
        tm.addRoute(1 ,3 ,6);
        tm.addRoute(2 ,3 ,-1);
        tm.addRoute(3 ,1 ,-2);

        tm.run();
        int[] rst = tm.getResult();

        assertArrayEquals(rst , new int[]{4,3});
    }

    @Test
    public void test2() {
        int nodeCount = 3;
        int routeCount = 4;

        TimeMachine tm = new TimeMachine();
        tm.initialize(nodeCount);

        tm.addRoute(1 ,2 ,4);
        tm.addRoute(1 ,3 ,3);
        tm.addRoute(2 ,3 ,-4);
        tm.addRoute(3 ,1 ,-2);

        tm.run();
        int[] rst = tm.getResult();

        assertArrayEquals(rst , new int[]{-1});
    }

    @Test
    public void test3() {
        int nodeCount = 3;
        int routeCount = 2;

        TimeMachine tm = new TimeMachine();
        tm.initialize(nodeCount);

        tm.addRoute(1 ,2 ,4);
        tm.addRoute(1 ,2 ,3);

        tm.run();
        int[] rst = tm.getResult();

        assertArrayEquals(rst , new int[]{3,-1});
    }

    @Test
    public void test4() {
        int nodeCount = 500;
        int routeCount = 500;

        TimeMachine tm = new TimeMachine();
        tm.initialize(nodeCount);

        int[] loc = {1, 2};
        for(int i = 0; i < 500; i++) {
            tm.addRoute( loc[i%2], loc[(i+1)%2] , -10000);
        }

        tm.run();
        int[] rst = tm.getResult();

        assertArrayEquals(rst , new int[]{-1});
    }

    @Test
    public void test5() {
        int nodeCount = 3;
        int routeCount = 3;

        TimeMachine tm = new TimeMachine();
        tm.initialize(nodeCount);

        tm.addRoute(1 ,2,3 );
        tm.addRoute(2 ,1,-1000 );
        tm.addRoute(2 ,1,5 );


        tm.run();
        int[] rst = tm.getResult();

        assertArrayEquals(rst , new int[]{-1});
    }

    @Test
    public void test6() {
        int nodeCount = 3;
        int routeCount = 2;

        TimeMachine tm = new TimeMachine();
        tm.initialize(nodeCount);

        tm.addRoute(3 ,2,-2 );
        tm.addRoute(2 ,3,-2 );


        tm.run();
        int[] rst = tm.getResult();

        assertArrayEquals(rst , new int[]{-1, -1});
    }

    @Test
    public void test7() {
        int nodeCount = 1;
        int routeCount = 0;

        TimeMachine tm = new TimeMachine();
        tm.initialize(nodeCount);
        tm.run();
        int[] rst = tm.getResult();

        assertArrayEquals(rst , new int[]{0});
    }

    @Test
    public void test8() {
        int nodeCount = 5;
        int routeCount = 5;

        TimeMachine tm = new TimeMachine();
        tm.initialize(nodeCount);

        tm.addRoute(1 ,2,2 );
        tm.addRoute(2 ,4,-1 );
        tm.addRoute(2 ,5,1 );
        tm.addRoute(3 ,2,3 );
        tm.addRoute(4 ,3,-4 );

        tm.run();
        int[] rst = tm.getResult();

        assertArrayEquals(rst , new int[]{-1});
    }
}
