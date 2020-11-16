package Heap;

import BaseKit.IQuize;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UseMiddleHeap implements IQuize {
    private MiddleHeap middleHeap;

    public UseMiddleHeap() {
        middleHeap = new MiddleHeap();
    }

    @Override
    public void run() {
        try {
            int n;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(br.readLine());
                middleHeap.add(num);
                num = middleHeap.top();
                System.out.println(num);
            }
        }catch (IOException e) {
            System.out.print("Input Error!");
            System.out.println(e.getMessage());
            return;
        }
    }
}
