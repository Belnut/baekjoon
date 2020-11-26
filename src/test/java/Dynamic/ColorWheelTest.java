package Dynamic;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ColorWheelTest {
    private static String TEST_FILE_PATH = "/Dynamic/ColorWheel/";

    @Test
    public void test1() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.out").getPath()));

            ColorWheel cw = new ColorWheel();

            cw.initialize(Integer.parseInt(qr.readLine()));
            cw.setChoiceCount(Integer.parseInt(qr.readLine()));

            cw.run();

            long rst = cw.getResult();
            String exp = ar.readLine();
            assertThat(rst, is(Long.parseLong(exp)));
            ar.close();
            qr.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
