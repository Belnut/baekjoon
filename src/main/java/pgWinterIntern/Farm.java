package pgWinterIntern;

import BaseKit.IQuize;

public class Farm implements IQuize {

    int[][] area;
    boolean[][] checked;

    int[] rst;

    public Farm(int[][] area, int kind) {
        this.area = area;
        int x = area.length;
        int y = area[0].length;
        checked = new boolean[x][y];
        rst = new int[kind];
    }


    @Override
    public void run() {
        int x = checked.length;
        int y = checked[0].length;

        for( int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(checked[i][j])
                    continue;

                int val = area[i][j];
                searchAreaTryCatch(i,j, val);
                rst[val] += 1;
            }
        }

        for (int i : rst)
        System.out.println(i + " ");
    }

    //속도차이 그렇게 나지 않
    void searchAreaTryCatch (int x, int y, int val) {
        try {
            //이미 체크함
            if (checked[x][y]) {
                return;
            }
            if(area[x][y] == val) {
                checked[x][y] = true;
                searchAreaTryCatch(x+1 , y, val);
                searchAreaTryCatch(x , y+1, val);
                searchAreaTryCatch(x-1 , y, val);
                searchAreaTryCatch(x , y-1, val);
            }
        }catch (ArrayIndexOutOfBoundsException e) {
            return;
        }
    }
    void searchAreaIf(int x, int y, int val) {
        if(x >= area.length || x < 0)
            return;
        if(y >= area[0].length || y < 0)
            return;

        if (checked[x][y]) {
            return;
        }
        if(area[x][y] == val) {
            checked[x][y] = true;
            searchAreaIf(x+1 , y, val);
            searchAreaIf(x , y+1, val);
            searchAreaIf(x-1 , y, val);
            searchAreaIf(x , y-1, val);
        }
    }

    public int[] result() {
        return rst;
    }
}
