package Dynamic;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkSungWonTest {
    private static String TEST_FILE_PATH = "/Dynamic/ParkSungWon/";

    @Test
    public void test1() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.out").getPath()));

            ParkSungWon psw = new ParkSungWon();

            int N = Integer.parseInt(qr.readLine());
            psw.initialize(N);
            for(int i = 0 ; i<N; i++) {
                    psw.addV(qr.readLine());
            }
            psw.setK(Integer.parseInt(qr.readLine()));
            psw.run();

            String rst = psw.getResult();
            String exp = ar.readLine();
            assertThat(rst, is(exp));
            ar.close();
            qr.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test1_1() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.out").getPath()));

            PSW1 psw = new PSW1();

            int N = Integer.parseInt(qr.readLine());
            psw.initialize(N);
            for(int i = 0 ; i<N; i++) {
                psw.addV(qr.readLine());
            }
            psw.setK(Integer.parseInt(qr.readLine()));
            psw.run();

            String rst = psw.getResult();
            String exp = ar.readLine();
            assertThat(rst, is(exp));
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

            ParkSungWon psw = new ParkSungWon();

            int N = Integer.parseInt(qr.readLine());
            psw.initialize(N);
            for(int i = 0 ; i<N; i++) {
                psw.addV(qr.readLine());
            }
            psw.setK(Integer.parseInt(qr.readLine()));
            psw.run();

            String rst = psw.getResult();
            String exp = ar.readLine();
            assertThat(rst, is(exp));
            ar.close();
            qr.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test2_1() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test2.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.out").getPath()));

            PSW1 psw = new PSW1();

            int N = Integer.parseInt(qr.readLine());
            psw.initialize(N);
            for(int i = 0 ; i<N; i++) {
                psw.addV(qr.readLine());
            }
            psw.setK(Integer.parseInt(qr.readLine()));
            psw.run();

            String rst = psw.getResult();
            String exp = ar.readLine();
            assertThat(rst, is(exp));
            ar.close();
            qr.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
