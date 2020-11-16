package Dynamic;

import BaseKit.IQuize;

//1520 baekjoon
public class DownRoad implements IQuize {

    private static int MAX_HEIGHT = 10001;

    short[][] mat;
    int[][] route;
    int result;

    int endX, endY;

    public DownRoad( short[][] mat ) {
        this.mat = mat;
        result = 0;
        endX = mat.length;
        endY = mat[0].length;

        route = new int[endX][endY];
        for(int i = 0; i < endX; i++) {
            for(int j = 0; j < endY; j++) {
                route[i][j] = -1;
            }
        }
    }

    @Override
    public void run() {
        result = moveRoad(0, 0);
    }

    int moveRoad(int x, int y) {

        if(x == endX-1 && y == endY-1) { // 도착지점에 도달하면 경로의 수 1을 리턴한다
            return 1;
        }

        if(route[x][y] == -1) { // 경로의 수가 계산된 적 없고, 방문한 적 없는 경우만 계산
            route[x][y] = 0;

            // 위로 이동
            if(x > 0 && mat[x][y] > mat[x-1][y]) {
                route[x][y] += moveRoad(x-1, y);
            }
            // 아래로 이동
            if(x < endX-1 && mat[x][y] > mat[x+1][y]) {
                route[x][y] += moveRoad(x+1, y);
            }
            // 왼쪽으로 이동
            if(y > 0 && mat[x][y] > mat[x][y-1]) {
                route[x][y] += moveRoad(x, y-1);
            }
            // 오른쪽으로 이동
            if(y < endY-1 && mat[x][y] > mat[x][y+1]) {
                route[x][y] += moveRoad(x, y+1);
            }
        }
        return route[x][y];

//
//        if(route[x][y] > 0 ) {
//            return route[x][y];
//        }
//
//        int[] addX = {1, -1, 0, 0};
//        int[] addY = {0, 0, 1, -1};
//
//        int thisHeight = mat[x][y];
//        for (int i = 0 ; i < 4; i ++) {
//            int nextHeight;
//            int nextX = x + addX[i];
//            int nextY = y + addY[i];
//
//            if(nextX < 0 || nextX >= endX)
//                continue;
//            if(nextY < 0 || nextY >= endY)
//                continue;
//
//            nextHeight = mat[nextX][nextY];
//            if(thisHeight > nextHeight) {
//                route[x][y] += moveRoad(nextX, nextY);
//            }
//        }
//
//        return route[x][y];
    }

    public int getResult() {
        return result;
    }
}
