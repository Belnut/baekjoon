package Tmp;

public class Test4 {
    public int solution(int n, int[][] board) {
        int answer = 0;
        int size = n * n;
        int[][] NumberLoc = new int[size+1][2];

        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int index = board[i][j];
                NumberLoc[index][0] = i;
                NumberLoc[index][1] = j;
            }
        }

        int[] start = {0,0};
        for(int i = 1 ; i <= size; i ++) {
            int[] next = NumberLoc[i];
            int keyCount = 1;

            int reverseX = min(n - next[0] + start[0], n - start[0] + next[0]);
            int reverseY = min(n - next[1] + start[1], n - start[1] + next[1]);

            keyCount += min(absoluteValue(next[0] - start[0]), reverseX);
            keyCount += min(absoluteValue(next[1] - start[1]), reverseY);

            answer += keyCount;
            start = next;
        }

        return answer;
    }

    int min(int a1, int a2) {
        return a1 > a2 ? a2 : a1;
    }

    private int absoluteValue(int x) {
        return x < 0 ? -x : x;
    }
}
