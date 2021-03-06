package Heap;

import java.util.ArrayList;

public class MinHeap implements Heap{
    ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<Integer>();
        heap.add(null);
    }

    @Override
    public void add(int val) {
        heap.add(val);
        int p = heap.size()-1;

        while(p > 1 && heap.get(p/2) > heap.get(p)) {
            int tmp = heap.get(p/2);
            heap.set(p/2, heap.get(p));
            heap.set(p, tmp);
            p /= 2;
        }
    }

    @Override
    public int delete() {
        if(heap.size() < 2) {
            return 0;
        }

        int deleteItem = heap.get(1);
        heap.set(1, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int p = 1;

        while( (p*2) < heap.size() ) {
            int min = heap.get(p*2);
            int minP = p*2;

            if( minP+1 < heap.size() && min > heap.get(minP+1) ) {
                min = heap.get(minP+1);
                minP = minP+1;
            }

            if( heap.get(p) < min ) {
                break;
            }

            int tmp = heap.get(p);
            heap.set(p, min);
            heap.set(minP, tmp);
            p = minP;
        }
        return deleteItem;
    }

    @Override
    public int size() {
        return heap.size()-1;
    }

    @Override
    public int top() {
        return heap.get(1);
    }
}
