package Tmp3;

import org.junit.Test;

public class ColoringBookTest {
    boolean[][] visited;
    int[][] pict;
    int m; int n;

    @Test
    public void solution() {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0},{1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        m = picture.length;
        n = picture[0].length;

        visited = new boolean[m][n];
        pict = picture;

        int count = 0;
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n ; j++) {
                if(visited[i][j]) continue;
                if(picture[i][j]==0) continue;
                int val = findVal(i,j, pict[i][j]);
                if(val == 0) continue;
                count++;
                max = Integer.max(val, max);
            }
        }

        int[] answer = new int[2];
        answer[0] = count;
        answer[1] = max;
    }

    private int findVal(int x, int y, int val) {
        int count = 1;

        if(visited[x][y]) {
            return 0;
        }

        visited[x][y] = true;

        int moveTop = x+1;
        int moveBtm = x-1;
        int moveLeft = y-1;
        int moveRight = y+1;

        if(moveTop < m && val == pict[moveTop][y]) {
            System.out.println("조건 1");
            count += findVal(moveTop, y, val);
        }
        if(moveBtm >= 0 && val == pict[moveBtm][y]) {
            System.out.println("조건 2");
            count += findVal(moveBtm, y, val);
        }
        if(moveLeft >= 0 && val == pict[x][moveLeft]) {
            System.out.println("조건 3");
            count += findVal(x, moveLeft, val);
        }
        if(moveRight < n && val == pict[x][moveRight]) {
            System.out.println("조건 4");
            count += findVal(x, moveRight, val);
        }

        System.out.println("x: " + x + " y: " + y + " val : " + val + " count: " + count);

        return count;
    }

    public static final int BTM = 0;
    public static final int LFT = 1;
    public static final int TOP = 2;

    @Test
    public void solution2() {
//        for(int n= 1; n<=1000; n++)
//        {
        int n = 13;
        int size = 0;

        for(int i = 0 ; i < n/2; i++) {
            size += n+1;
        }
        if(n%2 == 1) size += (n/2) + 1;

        int[] answer = new int[size];

        int overCount = 1;
        int index = 0;
        int way = BTM;
        int val = 1;
        answer[0] = val++;

        while(true) {
            if(val > size) {
                break;
            }

            switch(way) {
                case BTM :
                    index = index + overCount;
                    if(overCount < n && answer[index] == 0) {
                        answer[index] = val++;
                        overCount++;
                    }
                    else {
                        way = LFT;
                        index = index - overCount;
                    }
                    break;
                case LFT :
                    for(int i = 1; i<= n; i++) {
                        index++;
                        if(index < size && answer[index] == 0) {
                            answer[index] = val++;
                        }
                        else{
                            break;
                        }
                    }
                    index--;
                    way = TOP;
                    break;
                case TOP:
                    index = index - overCount;
                    if(index >= 0 && overCount > 0 && answer[index] == 0) {
                        answer[index] = val++;
                        overCount--;
                    }
                    else {
                        way = BTM;
                        index = index + overCount;
                    }
                    break;
                default:
                    throw new RuntimeException();
            }

            if(index < 0 || index >= size)
                break;
        }
        System.out.println(n);
    }
    @Test
    public void solution3() {
        String p = "()))((()";
        if(p.length() == 0);

        String answer = "";

        char[] str = p.toCharArray();
        int balence = 0;
        boolean vailed = true;
        int start = 0;
        for(int i = 0 ; i<p.length(); i++) {
            if(str[i] == '(') {
                balence++;
            }
            if(str[i] == ')') {
                if(balence <= 0) {
                    vailed = false;
                }
                balence--;
            }

            if(balence == 0 ) {
                if(!vailed) {
                    str[start] = '(';
                    str[i] = ')';
                    int f;
                    int b=i;
                    for(int j = start+1; j<i; j++){
                        f = j;
                        b = b-1;
                        if(f > b) {
                            break;
                        }
                        str[f] = str[f] == '(' ? ')' : '(';
                        str[b] = str[b] == '(' ? ')' : '(';
                    }
                    vailed = true;
                }
                start = i+1;
            }
        }
        answer = new String(str);
    }
}
