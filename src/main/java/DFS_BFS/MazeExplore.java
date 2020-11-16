package DFS_BFS;

import BaseKit.IQuize;

import java.util.ArrayList;

//2178 baekjoon 미로탐색
public class MazeExplore implements IQuize {
    private byte[][] maze;
    private int[][] moveCount;
    private int endX, endY;

    public void initialize(byte[][] maze) {
        this.maze = maze;
        this.endX = maze.length;
        this.endY = maze[0].length;
        this.moveCount = new int[endX][endY];
    }

    @Override
    public void run() {
        exploreMaze(0,0,1);
    }

    public void exploreMaze(int x, int y, int targetCount) {
        if(x < 0 || x >= endX) {
            return;
        }
        if(y < 0 || y >= endY) {
            return;
        }

        if(maze[x][y] == 1) {
            moveCount[x][y] = targetCount;
            int nextCount = targetCount+1;

            if( x+1 < endX && maze[x+1][y] != 0 && (moveCount[x+1][y] > nextCount || moveCount[x+1][y] == 0) )
                exploreMaze(x+1,y,nextCount);
            if( y+1 < endY && maze[x][y+1] != 0 && (moveCount[x][y+1] > nextCount || moveCount[x][y+1] == 0) )
                exploreMaze(x,y+1,nextCount);
            if( x-1 >= 0 && maze[x-1][y] != 0 && (moveCount[x-1][y] > nextCount || moveCount[x-1][y] == 0) )
                exploreMaze(x-1,y,nextCount);
            if( y-1 >= 0 &&maze[x][y-1] != 0 && (moveCount[x][y-1] > nextCount || moveCount[x][y-1] == 0))
                exploreMaze(x,y-1,nextCount);

        }
    }

    public int getResult() {
        return moveCount[endX-1][endY-1];
    }

}
