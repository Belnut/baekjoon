package DFS_BFS;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MazeExploreTest {
    @Test
    public void test1 () {
        byte[][] maze = {
                {1,0,1,1,1,1},
                {1,0,1,0,1,0},
                {1,0,1,0,1,1},
                {1,1,1,0,1,1}};

        MazeExplore me = new MazeExplore();
        me.initialize(maze);
        me.run();

        assertThat( me.getResult(), is(15));
    }

    @Test
    public void test2 () {
        byte[][] maze = {
                {1,1,0,1,1,0},
                {1,1,0,1,1,0},
                {1,1,1,1,1,1},
                {1,1,1,1,0,1}};

        MazeExplore me = new MazeExplore();
        me.initialize(maze);
        me.run();

        assertThat( me.getResult(), is(9));
    }

    @Test
    public void test3 () {
        byte[][] maze = {
                {1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1},
                {1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1}};

        MazeExplore me = new MazeExplore();
        me.initialize(maze);
        me.run();

        assertThat( me.getResult(), is(38));
    }

    @Test
    public void test4 () {
        byte[][] maze = {
                {1,0,1,1,1,1,1},
                {1,1,1,0,0,0,1},
                {1,0,0,0,0,0,1},
                {1,0,0,0,0,0,1},
                {1,0,0,0,0,0,1},
                {1,0,0,0,0,0,1},
                {1,1,1,1,1,1,1},};

        MazeExplore me = new MazeExplore();
        me.initialize(maze);
        me.run();

        assertThat( me.getResult(), is(13));
    }
}
