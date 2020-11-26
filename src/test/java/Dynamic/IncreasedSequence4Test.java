package Dynamic;

import DFS_BFS.CreateOne2;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IncreasedSequence4Test {
    private static String TEST_FILE_PATH = "/Dynamic/IncreasedSequence4/";

    @Test
    public void test1() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.out").getPath()));

            IncreasedSequence4 co2 = new IncreasedSequence4();
            int count = Integer.parseInt(qr.readLine());

            co2.setNumCount(count);

            String[] tmp = qr.readLine().split(" ");
            for(int i =0; i< count; i++) {
                co2.addNum(Integer.parseInt(tmp[i]));
            }

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

            IncreasedSequence4 co2 = new IncreasedSequence4();
            int count = Integer.parseInt(qr.readLine());

            co2.setNumCount(count);

            String[] tmp = qr.readLine().split(" ");
            for(int i =0; i< count; i++) {
                co2.addNum(Integer.parseInt(tmp[i]));
            }

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
