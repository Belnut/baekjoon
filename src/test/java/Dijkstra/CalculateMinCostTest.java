package Dijkstra;

import Dynamic.DSLR;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculateMinCostTest {
    private static String TEST_FILE_PATH = "/Dijkstra/CalculateMinCost/";

    @Test
    public void test1() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.out").getPath()));

            int nodeCount = Integer.parseInt(qr.readLine());
            CalculateMinCost cmc = new CalculateMinCost(nodeCount);
            int routeCount = Integer.parseInt(qr.readLine());

            String[] tmp;
            for(int i =0; i< routeCount; i++) {
                tmp = qr.readLine().split(" ");
                cmc.addRoute(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]));
            }
            tmp = qr.readLine().split(" ");
            cmc.setStartNode(Integer.parseInt(tmp[0]));
            cmc.setEndNode(Integer.parseInt(tmp[1]));
            cmc.run();

            int[] record = cmc.getRecord();
            int cost = cmc.getTotalCost();
            int visitNodeCount = cmc.getRouteCount();

            int expCost = Integer.parseInt(ar.readLine());
            int expVisitNodeCount = Integer.parseInt(ar.readLine());
            tmp = ar.readLine().split(" ");
            int[] expRec = new int[expVisitNodeCount];
            for (int i = 0; i < tmp.length; i++) {
                expRec[i] = Integer.parseInt(tmp[i]);
            }

            assertThat(cost, is(expCost));
            assertThat(visitNodeCount, is(expVisitNodeCount));
            assertThat(record, is(expRec));
            System.out.println(record);
            ar.close();
            qr.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test2() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test2.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test2.out").getPath()));

            int nodeCount = Integer.parseInt(qr.readLine());
            CalculateMinCost cmc = new CalculateMinCost(nodeCount);
            int routeCount = Integer.parseInt(qr.readLine());

            String[] tmp;
            for(int i =0; i< routeCount; i++) {
                tmp = qr.readLine().split(" ");
                cmc.addRoute(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]));
            }
            tmp = qr.readLine().split(" ");
            cmc.setStartNode(Integer.parseInt(tmp[0]));
            cmc.setEndNode(Integer.parseInt(tmp[1]));
            cmc.run();

            int[] record = cmc.getRecord();
            int cost = cmc.getTotalCost();
            int visitNodeCount = cmc.getRouteCount();

            int expCost = Integer.parseInt(ar.readLine());
            int expVisitNodeCount = Integer.parseInt(ar.readLine());
            tmp = ar.readLine().split(" ");
            int[] expRec = new int[expVisitNodeCount];
            for (int i = 0; i < tmp.length; i++) {
                expRec[i] = Integer.parseInt(tmp[i]);
            }

            assertThat(cost, is(expCost));
            assertThat(visitNodeCount, is(expVisitNodeCount));
            assertThat(record, is(expRec));
            System.out.println(record);
            ar.close();
            qr.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test3() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test3.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test3.out").getPath()));

            int nodeCount = Integer.parseInt(qr.readLine());
            CalculateMinCost cmc = new CalculateMinCost(nodeCount);
            int routeCount = Integer.parseInt(qr.readLine());

            String[] tmp;
            for(int i =0; i< routeCount; i++) {
                tmp = qr.readLine().split(" ");
                cmc.addRoute(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]));
            }
            tmp = qr.readLine().split(" ");
            cmc.setStartNode(Integer.parseInt(tmp[0]));
            cmc.setEndNode(Integer.parseInt(tmp[1]));
            cmc.run();

            int[] record = cmc.getRecord();
            int cost = cmc.getTotalCost();
            int visitNodeCount = cmc.getRouteCount();

            int expCost = Integer.parseInt(ar.readLine());
            int expVisitNodeCount = Integer.parseInt(ar.readLine());
            tmp = ar.readLine().split(" ");
            int[] expRec = new int[expVisitNodeCount];
            for (int i = 0; i < tmp.length; i++) {
                expRec[i] = Integer.parseInt(tmp[i]);
            }

            assertThat(cost, is(expCost));
            assertThat(visitNodeCount, is(expVisitNodeCount));
            assertThat(record, is(expRec));

//            BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
//            br.write(cost + "\n");
//            br.write(visitNodeCount + "\n");
//
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < visitNodeCount; i++) {
//                sb.append(record[i] + " ");
//            }
//            br.write(sb.toString() + "\n");
//            br.flush();
//            br.close();

            ar.close();
            qr.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
