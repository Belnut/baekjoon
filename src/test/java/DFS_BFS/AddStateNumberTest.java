package DFS_BFS;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class AddStateNumberTest {

    @Test
    public void test1 () {
        byte[][] mat = {
                {0,1,1,0,1,0,0},
                {0,1,1,0,1,0,1},
                {1,1,1,0,1,0,1},
                {0,0,0,0,1,1,1},
                {0,1,0,0,0,0,0},
                {0,1,1,1,1,1,0},
                {0,1,1,1,0,0,0} };

        AddStateNumber asn = new AddStateNumber(mat);
        asn.run();

        int[] expected = {7,8,9};
        int[] actual = asn.getResult();
        assertThat(actual.length ,is(3));
        assertArrayEquals(actual, expected);
    }
}
