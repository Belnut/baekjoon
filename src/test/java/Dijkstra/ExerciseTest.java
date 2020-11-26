package Dijkstra;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ExerciseTest {
    private static String TEST_FILE_PATH = "/Dijkstra/Exercise/";

    @Test
    public void test1() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.out").getPath()));

            String[] tmp;
            Exercise ex = new Exercise();

            tmp = qr.readLine().split(" ");
            int nodeCount = Integer.parseInt(tmp[0]);
            int routeCount = Integer.parseInt(tmp[1]);

            ex.initialize(nodeCount);

            for(int j = 0 ; j<routeCount; j++) {
                tmp = qr.readLine().split(" ");
                int x = Integer.parseInt(tmp[0]);
                int y = Integer.parseInt(tmp[1]);
                int cost = Integer.parseInt(tmp[2]);

                ex.addRoute(x,y,cost);
            }

            ex.run();
            int rst = ex.getResult();
            String exp = ar.readLine();

            assertThat(rst, is(Integer.parseInt(exp)));

            ar.close();
            qr.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
