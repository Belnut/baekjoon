package DFS_BFS;
import BaseKit.IQuize;

import java.util.ArrayList;
import java.util.Collections;

//2667 baekjoon 단지번호붙이기
public class AddStateNumber implements IQuize {
    byte[][] mat;
    boolean[][] isChecked;
    ArrayList<Integer> result;

    public AddStateNumber(byte[][] mat) {
        this.mat = mat;
        int size = mat.length;
        isChecked = new boolean[size][size];
        result = new ArrayList<>();
    }

    @Override
    public void run() {
        for (int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat.length; j++) {
                int count = dfs(i,j);
                if (count > 0) {
                    result.add(count);
                }
            }
        }

        Collections.sort(result);
    }

    public int dfs(int x, int y) {
        int count = 0;

        if(x < 0 || x >= mat.length) {
            return count;
        }

        if(y < 0 || y >= mat.length) {
            return count;
        }

        if (mat[x][y] == 1 && isChecked[x][y] == false) {
            isChecked[x][y] = true;
            count++;

            count += dfs(x-1, y);
            count += dfs(x, y-1);
            count += dfs(x+1, y);
            count += dfs(x, y+1);
        }
        return count;
    }

    public int[] getResult() {
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
