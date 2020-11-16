package DFS_BFS;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class VirusTest {
    @Test
    public void test1() {
        int nodeCount = 7;
        int routeSize = 6;
        int startNode = 1;
        int[][] routes = {{1,2}, {2,3}, {1,5}, {5,2}, {5,6}, {4,7}};

        Virus v = new Virus(routes, nodeCount, startNode);
        v.run();

        assertThat(v.getResult(), is(4));
    }
}
