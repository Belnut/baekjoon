package DFS_BFS;

import Dynamic.RGBStreet2;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CreateOne2Test {
    private static String TEST_FILE_PATH = "/DFS_BFS/CreateOne2/";

    @Test
    public void test1() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.out").getPath()));

            CreateOne2 co2 = new CreateOne2();
            int startValue = Integer.parseInt(qr.readLine());

            co2.setData(startValue);
            co2.run();

            int rst = co2.getResult();
            String record = co2.getRecord();

            String expVal = ar.readLine();
            String expRec = ar.readLine();

            assertThat(rst, is(Integer.parseInt(expVal)));
            assertThat(record, is(expRec));
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

            CreateOne2 co2 = new CreateOne2();
            int startValue = Integer.parseInt(qr.readLine());

            co2.setData(startValue);
            co2.run();

            int rst = co2.getResult();
            String record = co2.getRecord();

            String expVal = ar.readLine();
            String expRec = ar.readLine();

            assertThat(rst, is(Integer.parseInt(expVal)));
            assertThat(record, is(expRec));
            ar.close();
            qr.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
