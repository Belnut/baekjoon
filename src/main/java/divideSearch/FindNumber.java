package divideSearch;

import BaseKit.IQuize;
import java.util.*;

public class FindNumber implements IQuize {
    Scanner scanner = new Scanner(System.in);

    int n;
    int m;

    int[] origin;
    public FindNumber() {
    }

    @Override
    public void run () {

        n = scanner.nextInt();

        origin = new int[100001];
        for (int i = 0; i < n ; i ++)  {
            origin[i] = scanner.nextInt();
        }

        Arrays.sort(origin);

        m = scanner.nextInt();
        for (int i = 0; i < m ; i++) {
            int target = scanner.nextInt();
            if(  Arrays.binarySearch(origin, target) >= 0 ) {
                System.out.println(1);
            } else
                System.out.println(0);
        }
    }

    private boolean find(int target, int begin, int end)
    {
        int mid = (begin + end)/2;

        if(origin[mid] == target)
            return true;
        else if (begin == end)
            return false;

        else
        {
            if(origin[mid] > target )
                return find(target, begin, mid - 1);

            else
                return find(target, mid + 1 , end);
        }
    }
}