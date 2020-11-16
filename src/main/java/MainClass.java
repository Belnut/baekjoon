import BaseKit.IQuize;
import DFS_BFS.AddStateNumber;
import DFS_BFS.MazeExplore;
import pgWinterIntern.Farm;

import java.io.*;
import java.util.ArrayList;

public class MainClass {

    public static void main(String[] args) {
//        int[][] area = {{0,0,1,1},{0,1,0,2},{2,2,2,2},{1,1,2,1},{1,1,2,1},{1,1,1,0},{2,2,2,2},{1,2,0,2}};
//        IQuize farm = new Farm(area, 3);
//        long start = System.currentTimeMillis();
//
//        farm.run();
//
//        long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
//        System.out.println( "실행 시간 : " + ( end - start ) + "ms");
//
//        throw new RuntimeException();

//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int size = Integer.parseInt(br.readLine());
//            byte[][] mat = new byte[size][size];
//
//            for(int i=0; i <size; i++) {
//                for(int j=0; j<size; j++) {
//                    mat[i][j] = (byte) (br.read()-48);
//                }
//                br.read();
//            }
//            AddStateNumber asn = new AddStateNumber(mat);
//            asn.run();
//
//            int[] result =asn.getResult();
//
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//            bw.write(result.length + "\n");
//            for (int i =0; i < result.length; i++) {
//                bw.write(result[i] +"\n");
//            }
//            bw.flush();
//            bw.close();
//        }catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});

        int[][] a = new int[1][];
        int[] b = {1,2};
        a[0] = b;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] tmp = br.readLine().split(" ");

            int endX = Integer.parseInt(tmp[0]);
            int endY = Integer.parseInt(tmp[1]);
            byte[][] maze = new byte[endX][endY];
            for(int i=0; i <endX; i++) {
                for(int j=0; j<endY; j++) {
                    maze[i][j] = (byte) (br.read()-48);
                }
                br.read();
            }

            MazeExplore me = new MazeExplore();
            me.initialize(maze);
            me.run();

            System.out.println(me.getResult() + "\n");
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}