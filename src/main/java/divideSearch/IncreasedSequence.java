package divideSearch;
import BaseKit.IQuize;

import java.util.ArrayList;
import java.io.*;
public class IncreasedSequence implements IQuize {
    ArrayList<Integer> rst;

    public IncreasedSequence() {
        rst = new ArrayList<Integer>();
    }
    @Override
    public void run() {

        int n;
        String[] inputs;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());

            inputs = br.readLine().split(" ");
        }catch (IOException e) {
            System.out.print("Input Error!");
            System.out.println(e.getMessage());
            return;
        }

        rst.add(Integer.parseInt(inputs[0]));
        for(int i = 1; i < n; i++){
            int num = Integer.parseInt(inputs[i]);
            if(num > rst.get(rst.size() - 1 )) {
                rst.add(num);
            }
            else {
                int index = lower_bound(num);
                rst.set(index, num);
            }
        }

        System.out.println(rst.size());
    }

    public int lower_bound(int val) {
        int left = 0;
        int right = rst.size()-1;

        while (left <= right) {
            int mid = (left + right) / 2 ;

            if(rst.get(mid) >= val )
                right = mid - 1;
            else
                left = mid +1;
        }

        return left;
    }
}
