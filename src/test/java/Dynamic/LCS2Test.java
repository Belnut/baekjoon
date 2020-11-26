package Dynamic;

import divideSearch.IncreasedSequence5;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LCS2Test {
    private static String TEST_FILE_PATH = "/Dynamic/LCS2/";
    @Test
    public void test1() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.out").getPath()));

            LCS2 lcs2 = new LCS2();
            lcs2.setTarget(qr.readLine());
            lcs2.setCompare(qr.readLine());
            lcs2.run();

            int rst = lcs2.getResult();
            String record = lcs2.getRecord();

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
