package pgWinterIntern;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StringOrderTest {
    @Test
    public void StringBuilderTest() {
        String x = "3(AB2(DCE";

        StringBuilder sb = new StringBuilder(x);

        int index = sb.lastIndexOf("(");
        int number = Integer.parseInt(sb.substring(index-1, index));
        String subStr = sb.substring(index+1);

        assertThat(number, is(2));
        assertThat(subStr, is("DCE"));
        assertThat(sb.toString(), is("3(AB2(DCE"));
    }

    @Test
    public void test1(){
        StringOrder so = new StringOrder("2(ARDE)");
        so.run();

        assertThat(so.result, is("ARDEARDE"));
    }

    @Test
    public void test2(){
        StringOrder so = new StringOrder("3(EEE2(ARDE)AS)Z");
        so.run();

        assertThat(so.result, is("EEEARDEARDEASEEEARDEARDEASEEEARDEARDEASZ"));
    }
}
