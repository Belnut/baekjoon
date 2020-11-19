package Dijkstra;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class KCMTravelTest {
    @Test
    public void test1() {
        int testCase = 2;
        int nodeCount;
        int costLimit;
        int routeCount;
        KCMTravel kcmt = new KCMTravel();

        nodeCount = 3;
        costLimit = 100;
        routeCount = 3;

        kcmt.initialize(nodeCount,costLimit);

        kcmt.addRoute(1, 2, 1, 1);
        kcmt.addRoute(2, 3, 1, 1);
        kcmt.addRoute(1, 3, 3, 30);

        kcmt.run();
        assertThat(kcmt.getResult(), is(2));


        nodeCount = 4;
        costLimit = 10;
        routeCount = 4;

        kcmt.initialize(nodeCount,costLimit);

        kcmt.addRoute(1, 2, 5, 3);
        kcmt.addRoute(2, 3, 5, 4);
        kcmt.addRoute(3, 4, 1, 5);
        kcmt.addRoute(1, 3, 10, 6);

        kcmt.run();
        assertThat(kcmt.getResult(), is(-1));
    }

    @Test
    public void test2() {
        int testCase = 3;
        int nodeCount;
        int costLimit;
        int routeCount;
        KCMTravel kcmt = new KCMTravel();

        nodeCount = 5;
        costLimit = 5;
        routeCount = 4;

        kcmt.initialize(nodeCount,costLimit);

        kcmt.addRoute(1, 2, 2, 1);
        kcmt.addRoute(2, 3, 2, 1);
        kcmt.addRoute(3, 5, 2, 1);
        kcmt.addRoute(1, 3, 1, 5);

        kcmt.run();
        assertThat(kcmt.getResult(), is(6));


        nodeCount = 5;
        costLimit = 0;
        routeCount = 4;

        kcmt.initialize(nodeCount,costLimit);

        kcmt.addRoute(1, 2, 2, 1);
        kcmt.addRoute(2, 3, 2, 1);
        kcmt.addRoute(3, 5, 2, 1);
        kcmt.addRoute(1, 3, 1, 5);

        kcmt.run();
        assertThat(kcmt.getResult(), is(-1));

        nodeCount = 5;
        costLimit = 6;
        routeCount = 4;

        kcmt.initialize(nodeCount,costLimit);

        kcmt.addRoute(1, 2, 2, 1);
        kcmt.addRoute(2, 3, 2, 1);
        kcmt.addRoute(3, 5, 2, 1);
        kcmt.addRoute(1, 3, 1, 5);

        kcmt.run();
        assertThat(kcmt.getResult(), is(3));

    }

    @Test
    public void test3() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource("/Dijkstra/KCMTravel/test1.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource("/Dijkstra/KCMTravel/test1.out").getPath()));

            int testcase = Integer.parseInt(qr.readLine());

            String[] tmp;
            KCMTravel kcmt = new KCMTravel();

            for(int i = 0; i< testcase; i++) {
                tmp = qr.readLine().split(" ");
                int nodeCount = Integer.parseInt(tmp[0]);
                int costLimit = Integer.parseInt(tmp[1]);
                int routeCount = Integer.parseInt(tmp[2]);

                kcmt.initialize(nodeCount, costLimit);

                for(int j = 0 ; j<routeCount; j++) {
                    tmp = qr.readLine().split(" ");
                    int x = Integer.parseInt(tmp[0]);
                    int y = Integer.parseInt(tmp[1]);
                    int cost = Integer.parseInt(tmp[2]);
                    int time = Integer.parseInt(tmp[3]);

                    kcmt.addRoute(x,y,cost,time);
                }

                kcmt.run();
                int rst = kcmt.getResult();
                String exp = ar.readLine();
                if(rst == -1) {
                    assertThat("Poor KCM", is(exp));
                } else {
                    assertThat(rst, is(Integer.parseInt(exp)));
                }
                ar.close();
                qr.close();
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test4() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource("/Dijkstra/KCMTravel/test2.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource("/Dijkstra/KCMTravel/test2.out").getPath()));

            int testcase = Integer.parseInt(qr.readLine());

            String[] tmp;
            KCMTravel kcmt = new KCMTravel();

            for(int i = 0; i< testcase; i++) {
                tmp = qr.readLine().split(" ");
                int nodeCount = Integer.parseInt(tmp[0]);
                int costLimit = Integer.parseInt(tmp[1]);
                int routeCount = Integer.parseInt(tmp[2]);

                kcmt.initialize(nodeCount, costLimit);

                for(int j = 0 ; j<routeCount; j++) {
                    tmp = qr.readLine().split(" ");
                    int x = Integer.parseInt(tmp[0]);
                    int y = Integer.parseInt(tmp[1]);
                    int cost = Integer.parseInt(tmp[2]);
                    int time = Integer.parseInt(tmp[3]);

                    kcmt.addRoute(x,y,cost,time);
                }

                kcmt.run();
                int rst = kcmt.getResult();
                String exp = ar.readLine();
                if(rst == -1) {
                    assertThat("Poor KCM", is(exp));
                } else {
                    assertThat(rst, is(Integer.parseInt(exp)));
                }
                ar.close();
                qr.close();
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test5() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource("/Dijkstra/KCMTravel/test3.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource("/Dijkstra/KCMTravel/test3.out").getPath()));

            int testcase = Integer.parseInt(qr.readLine());

            String[] tmp;
            KCMTravel kcmt = new KCMTravel();

            for(int i = 0; i< testcase; i++) {
                tmp = qr.readLine().split(" ");
                int nodeCount = Integer.parseInt(tmp[0]);
                int costLimit = Integer.parseInt(tmp[1]);
                int routeCount = Integer.parseInt(tmp[2]);

                kcmt.initialize(nodeCount, costLimit);

                for(int j = 0 ; j<routeCount; j++) {
                    tmp = qr.readLine().split(" ");
                    int x = Integer.parseInt(tmp[0]);
                    int y = Integer.parseInt(tmp[1]);
                    int cost = Integer.parseInt(tmp[2]);
                    int time = Integer.parseInt(tmp[3]);

                    kcmt.addRoute(x,y,cost,time);
                }

                kcmt.run();
                int rst = kcmt.getResult();
                String exp = ar.readLine();
                if(rst == -1) {
                    assertThat("Poor KCM", is(exp));
                } else {
                    assertThat(rst, is(Integer.parseInt(exp)));
                }
                ar.close();
                qr.close();
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test6() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource("/Dijkstra/KCMTravel/test4.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource("/Dijkstra/KCMTravel/test4.out").getPath()));

            int testcase = Integer.parseInt(qr.readLine());

            String[] tmp;
            KCMTravel kcmt = new KCMTravel();

            for(int i = 0; i< testcase; i++) {
                tmp = qr.readLine().split(" ");
                int nodeCount = Integer.parseInt(tmp[0]);
                int costLimit = Integer.parseInt(tmp[1]);
                int routeCount = Integer.parseInt(tmp[2]);

                kcmt.initialize(nodeCount, costLimit);

                for(int j = 0 ; j<routeCount; j++) {
                    tmp = qr.readLine().split(" ");
                    int x = Integer.parseInt(tmp[0]);
                    int y = Integer.parseInt(tmp[1]);
                    int cost = Integer.parseInt(tmp[2]);
                    int time = Integer.parseInt(tmp[3]);

                    kcmt.addRoute(x,y,cost,time);
                }

                kcmt.run();
                int rst = kcmt.getResult();
                String exp = ar.readLine();
                if(rst == -1) {
                    assertThat("Poor KCM", is(exp));
                } else {
                    assertThat(rst, is(Integer.parseInt(exp)));
                }
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test7() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource("/Dijkstra/KCMTravel/test5.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource("/Dijkstra/KCMTravel/test5.out").getPath()));

            int testcase = Integer.parseInt(qr.readLine());

            String[] tmp;
            KCMTravel kcmt = new KCMTravel();

            for(int i = 0; i< testcase; i++) {
                tmp = qr.readLine().split(" ");
                int nodeCount = Integer.parseInt(tmp[0]);
                int costLimit = Integer.parseInt(tmp[1]);
                int routeCount = Integer.parseInt(tmp[2]);

                kcmt.initialize(nodeCount, costLimit);

                for(int j = 0 ; j<routeCount; j++) {
                    tmp = qr.readLine().split(" ");
                    int x = Integer.parseInt(tmp[0]);
                    int y = Integer.parseInt(tmp[1]);
                    int cost = Integer.parseInt(tmp[2]);
                    int time = Integer.parseInt(tmp[3]);

                    kcmt.addRoute(x,y,cost,time);
                }

                kcmt.run();
                int rst = kcmt.getResult();
                String exp = ar.readLine();
                if(rst == -1) {
                    assertThat("Poor KCM", is(exp));
                } else {
                    assertThat(rst, is(Integer.parseInt(exp)));
                }
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
