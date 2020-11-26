package Dynamic;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RGBStreet2Test {
    private static String TEST_FILE_PATH = "/Dynamic/RGBStreet2/";

    @Test
    public void test1() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.out").getPath()));

            String[] tmp;
            RGBStreet2 rs2 = new RGBStreet2();

            int houseCount = Integer.parseInt(qr.readLine());
            rs2.initialize(houseCount);

            for(int i = 0 ; i<houseCount; i++) {
                tmp = qr.readLine().split(" ");
                rs2.add(i, RGBStreet2.R, Integer.parseInt(tmp[RGBStreet2.R]));
                rs2.add(i, RGBStreet2.G, Integer.parseInt(tmp[RGBStreet2.G]));
                rs2.add(i, RGBStreet2.B, Integer.parseInt(tmp[RGBStreet2.B]));
            }
            rs2.run();
            int rst = rs2.getResult();
            String exp = ar.readLine();
            assertThat(rst, is(Integer.parseInt(exp)));
            ar.close();
            qr.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
