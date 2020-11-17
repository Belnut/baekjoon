package Dijkstra;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class UnidentifiedDistanceTest {

    @Test
    public void test1() {
        int testCaseCount = 2;

        //case 1
        int nodeCount = 5;
        int routeCount = 4;
        int candiateCount = 2;

        int startNode = 1;
        int[] midRoute = {2,3};

        UnidentifiedDistance ud = new UnidentifiedDistance();
        ud.initialize(nodeCount);
        ud.setStartNode(startNode);
        ud.setMidRoute(midRoute);

        ud.addRoute(1,2,6);
        ud.addRoute(2,3,2);
        ud.addRoute(3,4,4);
        ud.addRoute(3,5,3);

        ud.setCandidate(new int[]{5,4});
        ud.run();

        int[] rst = ud.getResult();
        assertArrayEquals(rst, new int[]{4, 5} );

        //case 2
        nodeCount = 6;
        routeCount = 9;
        candiateCount = 2;

        startNode = 2;
        midRoute = new int[]{3,1};

        ud.initialize(nodeCount);
        ud.setStartNode(startNode);
        ud.setMidRoute(midRoute);

        ud.addRoute(1,2,1);
        ud.addRoute(1,3,3);
        ud.addRoute(2,4,4);
        ud.addRoute(2,5,5);
        ud.addRoute(3,4,3);
        ud.addRoute(3,6,2);
        ud.addRoute(4,5,4);
        ud.addRoute(4,6,3);
        ud.addRoute(5,6,7);

        ud.setCandidate(new int[]{5,6});
        ud.run();

        rst = ud.getResult();
        assertArrayEquals(rst, new int[]{6} );
    }
}
