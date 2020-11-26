package Dynamic;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TravelSalesmanProblemTest {
    private static String TEST_FILE_PATH = "/Dynamic/TravelSalesmanProblem/";

    @Test
    public void test1() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.out").getPath()));

            String[] tmp;
            TravelSalesmanProblem tsp = new TravelSalesmanProblem();

            int nodeCount = Integer.parseInt(qr.readLine());
            tsp.initialize(nodeCount);

            for(int i = 0 ; i<nodeCount; i++) {
                tmp = qr.readLine().split(" ");
                for (int j = 0 ; j< nodeCount; j++) {
                    int cost = Integer.parseInt(tmp[j]);
                    tsp.addRoute(i+1, j+1, cost);
                }
            }
            tsp.run();
            int rst = tsp.getResult();
            String exp = ar.readLine();
            assertThat(rst, is(Integer.parseInt(exp)));
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

            String[] tmp;
            TravelSalesmanProblem tsp = new TravelSalesmanProblem();

            int nodeCount = Integer.parseInt(qr.readLine());
            tsp.initialize(nodeCount);

            for(int i = 0 ; i<nodeCount; i++) {
                tmp = qr.readLine().split(" ");
                for (int j = 0 ; j< nodeCount; j++) {
                    int cost = Integer.parseInt(tmp[j]);
                    tsp.addRoute(i+1, j+1, cost);
                }
            }
            tsp.run();
            int rst = tsp.getResult();
            String exp = ar.readLine();
            assertThat(rst, is(Integer.parseInt(exp)));
            ar.close();
            qr.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

