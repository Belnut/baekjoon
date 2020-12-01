package Dynamic;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DSLRTest {
    private static String TEST_FILE_PATH = "/Dynamic/DSLR/";

    @Test
    public void test1() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.out").getPath()));

            DSLR dslr = new DSLR();
            int testCount = Integer.parseInt(qr.readLine());

            for(int i =0; i< testCount; i++) {
                String[] tmp = qr.readLine().split(" ");
                dslr.inputCase(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
                dslr.run();
                String record = dslr.getRecord();
                String expRec = ar.readLine();
                assertThat(record, is(expRec));
                System.out.println(record);
            }
            ar.close();
            qr.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
