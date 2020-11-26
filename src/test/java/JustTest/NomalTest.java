package JustTest;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NomalTest {
    @Test
    public void biteAndTest() {
        int x = 0;

        x = (1 << 21) -1;

        for(int i = 1 ; i<= 20; i++)
            assertThat( x & ( 1 << i ), is(1 << i ) );

        assertThat(1 & (~1), is(0));
    }

    @Test
    public void IntegerMaxTest() {
        long x = 1;
        for(int i = 1 ; i<= 12; i++) {
            x *= i;
        }
        assertThat(true, is(x > 0));
        System.out.println(x);
    }

    @Test
    public void intToLongTest() {
        long a = 2000000000;
        long y = 2000000000;

        long X = (a + y) % 1000000003;
        long Y = (a%1000000003 * y% 1000000003) % 1000000003;

        assertThat(X, is(Y));
    }

}
