package JustTest;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IOTest {
    @Test
    public void test1() {
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int size = Integer.parseInt(br.readLine());
//            byte[][] mat = new byte[size][size];
//
//            for(int i=0; i <size; i++) {
//                for(int j=0; j<size; j++) {
//                    mat[i][j] = (byte) br.read();
//                }
//            }
//
//        }catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
    @Test
    public void test2 () {
        int isServival = 0;
        String name = "HyunJinWon";
        for(int i = 0 ; i < name.length() ; i++) {
            isServival += name.charAt(i);
            isServival%=2;
        }
        System.out.println(isServival);

        assertThat(isServival, is(1));

    }
}
