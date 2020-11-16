package DFS_BFS;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OrganicFarmTest {
    @Test
    public void test1() {
        int x=10; int y=8;
        int farmingCount = 17;
//        for(int i = 0; i < farmingCount; i++) {
//
//        }
        OrganicFarm of = new OrganicFarm();
        of.initialize(x,y);

        of.addFarming(0,0);
        of.addFarming(1,0);
        of.addFarming(1,1);
        of.addFarming(4,2);
        of.addFarming(4,3);
        of.addFarming(4,5);
        of.addFarming(2,4);
        of.addFarming(3,4);
        of.addFarming(7,4);
        of.addFarming(8,4);
        of.addFarming(9,4);
        of.addFarming(7,5);
        of.addFarming(8,5);
        of.addFarming(9,5);
        of.addFarming(7,6);
        of.addFarming(8,6);
        of.addFarming(9,6);

        of.run();
        assertThat(of.getResult(), is(5));
    }
}
