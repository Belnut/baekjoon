package Dynamic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MultiMatrixSequanceTest {

    @Test
    public void test1(){
        int count;
        int mat[];

        count = 3;
        mat = new int[count+1];
        mat[0] = 5;mat[1] = 3;mat[2] = 2;mat[3] = 6;

        MultiMatrixSequance mms = new MultiMatrixSequance(mat);
        mms.run();

        assertThat(mms.result(), is(90));

    }
}
