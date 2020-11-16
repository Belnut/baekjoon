package pgWinterIntern;

import BaseKit.IQuize;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FarmTest {
    @Test
    public void Test1 () {
        int[][] area = {{0,0,1,1},{0,1,0,2},{2,2,2,2},{1,1,2,1},{1,1,2,1},{1,1,1,0},{2,2,2,2},{1,2,0,2}};
        Farm farm = new Farm(area, 3);
        long start = System.currentTimeMillis();

        farm.run();

        long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
        System.out.println( "실행 시간 : " + ( end - start ) + "ms");

        int[] rst = farm.result();
        int[] expected = {4, 5, 2};
        assertArrayEquals(expected, rst);
    }
}
