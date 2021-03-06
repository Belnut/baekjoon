package JustTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class ArrayClearTest {

    //repeater is more fast then New;
    @Test
    public void arrayClearSpeedTest() {
        int[] test1 = new int[100000000];

        long start = System.currentTimeMillis();
        for (int i = 0 ; i < test1.length; i++) {
            test1[i] = 0;
        }
        long timeRepeater = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        test1 = new int[100000000];
        long timeNew = System.currentTimeMillis() - start;

        System.out.println("repeater = " + timeRepeater + "ms");
        System.out.println("New = " + timeNew + "ms");
    }

    @Test
    public void arrayPushTest() {
        int[] test1;
        ArrayList<Integer> test2;
        int size = 1000;


        long start = System.currentTimeMillis();
        test1 = new int[size];
        for (int i = 0 ; i < size; i++) {
            test1[i] = 1;
        }
        long timeArray = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        test2 = new ArrayList<>();
        for (int i = 0 ; i < size; i++) {
            test2.add(1);
        }
        long timeArrayList = System.currentTimeMillis() - start;

        System.out.println("arrayInt = " + timeArray + "ms");
        System.out.println("ArrayList<Integer> = " + timeArrayList + "ms");
    }

    @Test
    public void HashMapArrayTest() {
        int size = 100000;

        long start = System.currentTimeMillis();
        int[] test1 = new int[size];
        for (int i = 0 ; i < size; i++) {
            test1[i] = 1;
        }
        long timeArray = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        HashMap<Integer, Integer> test2 = new HashMap<>();
        for (int i = 0 ; i < size; i++) {
            test2.put(i,i);
        }
        long timeHashMap = System.currentTimeMillis() - start;

        System.out.println("input arrayInt = " + timeArray + "ms");
        System.out.println("input hashMap = " + timeHashMap + "ms");

        start = System.currentTimeMillis();
        for (int i = 0 ; i < size; i++) {
            int x = test1[i];
        }
        timeArray = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        for (int i = 0 ; i < size; i++) {
            int x = test2.get(i);
        }
        timeHashMap = System.currentTimeMillis() - start;

        System.out.println("find arrayInt = " + timeArray + "ms");
        System.out.println("find hashMap = " + timeHashMap + "ms");
    }
}
