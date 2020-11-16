package DFS_BFS;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;

//1260 baekjoon DFS와 BFS
public class DFSandBFSTest {

    @Test
    public void test1() {
        int nodeCount = 4;
        int routeCount = 5;
        int startNode= 1;
        int[][] mat = { {1, 2}, {1, 3}, {1, 4}, {2, 4}, {3, 4}};
        DFSandBFS dab= new DFSandBFS(mat, nodeCount, startNode);
        dab.run();

        for(int i = 0 ; i < dab.dfsResult.size(); i++) {
            System.out.print(dab.dfsResult.get(i) + " ");
        }
        System.out.println();
        for(int i = 0 ; i < dab.bfsResult.size(); i++) {
            System.out.print(dab.bfsResult.get(i) + " ");
        }

        int[] dfsAnswer = {1,2,4,3};
        assertArrayEquals(dab.dfsResult.stream().mapToInt(Integer::intValue).toArray(), dfsAnswer);
        int[] bfsAnswer = {1,2,3,4};
        assertArrayEquals(dab.bfsResult.stream().mapToInt(Integer::intValue).toArray(), bfsAnswer);
    }
    @Test
    public void test2() {
        int nodeCount = 5;
        int routeCount = 5;
        int startNode= 3;
        int[][] mat = { {5, 4}, {5, 2}, {1, 2}, {3, 4}, {3, 1}};
        DFSandBFS dab= new DFSandBFS(mat, nodeCount, startNode);
        dab.run();

        for(int i = 0 ; i < dab.dfsResult.size(); i++) {
            System.out.print(dab.dfsResult.get(i) + " ");
        }
        System.out.println();
        for(int i = 0 ; i < dab.bfsResult.size(); i++) {
            System.out.print(dab.bfsResult.get(i) + " ");
        }

        int[] dfsAnswer = {3,1,2,5,4};
        assertArrayEquals(dab.dfsResult.stream().mapToInt(Integer::intValue).toArray(), dfsAnswer);
        int[] bfsAnswer = {3,1,4,2,5};
        assertArrayEquals(dab.bfsResult.stream().mapToInt(Integer::intValue).toArray(), bfsAnswer);
    }
    @Test
    public void test3() {
        int nodeCount = 1000;
        int routeCount = 1;
        int startNode= 1000;
        int[][] mat = { {999, 1000}};
        DFSandBFS dab= new DFSandBFS(mat, nodeCount, startNode);
        dab.run();

        for(int i = 0 ; i < dab.dfsResult.size(); i++) {
            System.out.print(dab.dfsResult.get(i) + " ");
        }
        System.out.println();
        for(int i = 0 ; i < dab.bfsResult.size(); i++) {
            System.out.print(dab.bfsResult.get(i) + " ");
        }

        int[] dfsAnswer = {1000,999};
        assertArrayEquals(dab.dfsResult.stream().mapToInt(Integer::intValue).toArray(), dfsAnswer);
        int[] bfsAnswer = {1000,999};
        assertArrayEquals(dab.bfsResult.stream().mapToInt(Integer::intValue).toArray(), bfsAnswer);
    }

    @Test
    public void test4() {
        int nodeCount = 1000;
        int routeCount = 10;
        int startNode= 4;
        int[][] mat = { {4, 1000}, {1000, 1}, {1000, 2}, {1000, 3}, {1000, 4}, {4, 500}, {4, 600}, {2, 5}, {5,9}, {1, 24}};
        DFSandBFS dab= new DFSandBFS(mat, nodeCount, startNode);
        dab.run();

        for(int i = 0 ; i < dab.dfsResult.size(); i++) {
            System.out.print(dab.dfsResult.get(i) + " ");
        }
        System.out.println();
        for(int i = 0 ; i < dab.bfsResult.size(); i++) {
            System.out.print(dab.bfsResult.get(i) + " ");
        }

        int[] dfsAnswer = {4,500,600,1000,1,24,2,5,9,3};
        assertArrayEquals(dab.dfsResult.stream().mapToInt(Integer::intValue).toArray(), dfsAnswer);
        int[] bfsAnswer = {4,500,600,1000,1,2,3,24,5,9};
        assertArrayEquals(dab.bfsResult.stream().mapToInt(Integer::intValue).toArray(), bfsAnswer);
    }

    @Test
    public void test5() {
        int nodeCount = 1000;
        int routeCount = 1;
        int startNode = 1;
        int[][] mat = { {999, 1000}};
        DFSandBFS dab= new DFSandBFS(mat, nodeCount, startNode);
        dab.run();

        for(int i = 0 ; i < dab.dfsResult.size(); i++) {
            System.out.print(dab.dfsResult.get(i) + " ");
        }
        System.out.println();
        for(int i = 0 ; i < dab.bfsResult.size(); i++) {
            System.out.print(dab.bfsResult.get(i) + " ");
        }

        int[] dfsAnswer = {1};
        assertArrayEquals(dab.dfsResult.stream().mapToInt(Integer::intValue).toArray(), dfsAnswer);
        int[] bfsAnswer = {1};
        assertArrayEquals(dab.bfsResult.stream().mapToInt(Integer::intValue).toArray(), bfsAnswer);
    }
}
