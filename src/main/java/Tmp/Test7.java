package Tmp;

public class Test7 {
    int[][] answer;
    public int[][] solution(int n, boolean horizontal) {

        answer = new int[n][n];
        int[][] moveVector = {{1, -1}, {-1, 1}};
        int[] start;
        int moveP;
        if(horizontal) {
            start = new int[]{0, 1};
            moveP = 0;
        }
        else {
            start = new int[]{1, 0};
            moveP = 1;
        }
        answer[start[0]][start[1]] = 1;

        while(true) {
            int nextCount = answer[start[0]][start[1]];

            int nextX = start[0] + moveVector[moveP][0];
            int nextY = start[1] + moveVector[moveP][1];

            if (nextX < 0 ) {
                nextX = 0; nextCount += 1;
                moveP = (moveP + 1) %2;

                if(nextY >= n) // 우측 상단
                    nextY = n-1;
            } else if (nextX >= n) {
                nextX = n-1; nextCount +=1;
                moveP = (moveP + 1) %2;

                if(nextY < 0) // 왼쪽 하단
                    nextY = 1;
                else
                    nextY +=2;

            } else if(nextY < 0) {
                nextY = 0; nextCount += 1;
                moveP = (moveP + 1) %2;
            } else if(nextY >= n) {
                nextY = n-1; nextX += 2;
                nextCount +=1;
                moveP = (moveP + 1) %2;

            } else {
                nextCount +=2;
            }
            answer[nextX][nextY] = nextCount;
            start[0] = nextX; start[1] = nextY;

            if(nextX == n-1 && nextY == n-1)
                break;
        }

        return answer;
    }
}
