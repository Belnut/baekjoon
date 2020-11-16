package DFS_BFS;

import BaseKit.IQuize;

import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.Queue;

//범위가 넓기 때문에 DFS 로 문제를 풀면 시간초과
//BFS로 풀어야 한다
public class BreakThrough implements IQuize {
    private static final int UNBREAKWALL = 0;
    private static final int BREAKWALL = 1;

    private byte[][] maze;
    private boolean[][][] isChecked;
    private Queue<Point> queue;

    private int endX, endY;
    private int result;

    public BreakThrough() {
    }

    public void initialize(byte[][] maze) {
        this.maze = maze;
        this.endX = maze.length;
        this.endY = maze[0].length;
        queue = new LinkedList<>();
        isChecked = new boolean[2][endX][endY];
        result = Integer.MAX_VALUE;
    }

    @Override
    public void run() {
        exploreMaze(0, 0);
    }

    public void exploreMaze(int startX, int startY) {
        queue.add(new Point(startX, startY,0, 1));

        isChecked[startX][startX][0] = true;
        isChecked[startX][startX][0] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};


        while(!queue.isEmpty()) {
            Point now = queue.poll();
            int x = now.x; int y = now.y;
            int breakWall = now.breakWall;
            int count = now.count+1;

            if(x == endX-1 && y == endY-1) {
                result = Integer.min(result, now.count);
            }


            for(int i = 0; i < dx.length; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];


                if(tx <0 || tx >= endX || ty <0 || ty >= endY )
                    continue;

                if(maze[tx][ty] == 1) {
                    if(breakWall == 0 && !isChecked[breakWall][tx][ty]) {
                        isChecked[BREAKWALL][tx][ty] = true;
                        queue.add(new Point(tx, ty, 1, count));
                    }
                }
                else {
                    if(!isChecked[breakWall][tx][ty]) {
                        isChecked[breakWall][tx][ty] = true;
                        queue.add(new Point(tx, ty, breakWall, count));
                    }
                }
            }
        }
    }

    public int getResult() {
        if(result == Integer.MAX_VALUE)
            return -1;
        return result;
    }

    static class Point {
        int x; int y;
        int breakWall;
        int count;

        public Point(int x, int y, int breakWall, int count) {
            this.x = x;
            this.y = y;
            this.breakWall = breakWall;
            this.count = count;
        }
    }
}
