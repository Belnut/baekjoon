package Dynamic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PalindromCheckTest {
    @Test
    public void test1() {
        int[] data = {1,2,1,3,1,2,1};

        PalindromCheck pc = new PalindromCheck(data);
        pc.run();

        int start, end;
        assertThat(pc.checkPalindrom(0, 2), is(true));
        assertThat(pc.checkPalindrom(1, 4), is(false));
        assertThat(pc.checkPalindrom(2, 2), is(true));
        assertThat(pc.checkPalindrom(4, 6), is(true));
    }

}
