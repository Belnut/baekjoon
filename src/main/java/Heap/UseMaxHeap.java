package Heap;

import BaseKit.IQuize;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UseMaxHeap implements IQuize {
    MaxHeap maxHeap;
    public UseMaxHeap() {
        maxHeap = new MaxHeap();
    }

    @Override
    public void run() {
        int n;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(br.readLine());

                if(num == 0 )
                    System.out.println(maxHeap.delete());
                else
                    maxHeap.add(num);
            }
        }catch (IOException e) {
            System.out.print("Input Error!");
            System.out.println(e.getMessage());
            return;
        }
    }
}
