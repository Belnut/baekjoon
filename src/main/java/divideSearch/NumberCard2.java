package divideSearch;
import BaseKit.IQuize;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

//10816 baekjooon
public class NumberCard2  implements IQuize {

    ArrayList<Integer> dack;

    int n, m = 1;

    public NumberCard2()
    {
        dack  = new ArrayList<Integer>();
    }
    
    public void run()
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try{
            n = Integer.parseInt(in.readLine());

            String[] nums = in.readLine().split(" ");

            for (int i = 0; i < n ; i++) {
                dack.add(Integer.parseInt(nums[i]));
            }
            nums = null;

            Collections.sort(dack);
            m = Integer.parseInt(in.readLine());
            nums = in.readLine().split(" ");

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < m; i++) {
                int rst;
                Integer num = Integer.parseInt(nums[i]);

                int index = lowerBound(num);
                rst = lowerBound(num+1) - index;
                bw.write(rst + " ");
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
    }
    //return index;
    public int lowerBound(Integer target) {
        int begin = 0;
        int end = dack.size();

        while(begin < end) {
            int mid = (begin + end) / 2;

            if(dack.get(mid) >= target) {
                end = mid;
            }
            else {
                begin = mid + 1;
            }
        }
        return end;
    }

}
