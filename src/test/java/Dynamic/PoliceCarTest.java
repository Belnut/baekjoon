package Dynamic;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PoliceCarTest {
    private static String TEST_FILE_PATH = "/Dynamic/PoliceCar/";
    @Test
    public void test1() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.out").getPath()));

            PoliceCar pc = new PoliceCar();
            pc.setMapSize(Integer.parseInt(qr.readLine()));

            int count = Integer.parseInt(qr.readLine());
            for (int i = 0; i < count; i++) {
                String[] tmp = qr.readLine().split(" ");
                pc.addCaseOperate(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
            }
            pc.run();
            int rst = pc.getResult();
            int[] record = pc.getRecord();

            String expVal = ar.readLine();
            assertThat(rst, is(Integer.parseInt(expVal)));

            for (int i = 0; i < count; i++) {
                String expRec = ar.readLine();
                assertThat(record[i], is(Integer.parseInt(expRec)));
            }
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

            PoliceCar pc = new PoliceCar();
            pc.setMapSize(Integer.parseInt(qr.readLine()));

            int count = Integer.parseInt(qr.readLine());
            for (int i = 0; i < count; i++) {
                String[] tmp = qr.readLine().split(" ");
                pc.addCaseOperate(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
            }

            pc.run();

            int rst = pc.getResult();
            int[] record = pc.getRecord();

            String expVal = ar.readLine();
            assertThat(rst, is(Integer.parseInt(expVal)));

            for (int i = 0; i < count; i++) {
                String expRec = ar.readLine();
                assertThat(record[i], is(Integer.parseInt(expRec)));
            }
            ar.close();
            qr.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
