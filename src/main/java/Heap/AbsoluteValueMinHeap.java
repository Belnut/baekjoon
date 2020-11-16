package Heap;

import java.util.ArrayList;

public class AbsoluteValueMinHeap implements Heap {
    private ArrayList<Integer> heap;

    public AbsoluteValueMinHeap() {
        heap = new ArrayList<Integer>();
        heap.add(null);
    }

    @Override
    public void add(int val) {
        heap.add(val);
        int p = heap.size()-1;

        if(p <= 1)
            return;

        while(absoluteValue(heap.get(p/2)) > absoluteValue(heap.get(p)) ||
                (absoluteValue(heap.get(p/2)) == absoluteValue(heap.get(p)) && heap.get(p/2) > heap.get(p))) {
            int tmp = heap.get(p/2);
            heap.set(p/2, heap.get(p));
            heap.set(p, tmp);
            p /= 2;

            if(p<=1)
                break;
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

            if( minP+1 < heap.size())
                if ( absoluteValue(min) > absoluteValue(heap.get(minP+1)) ||
                        (absoluteValue(min) == absoluteValue(heap.get(minP+1)) && min > heap.get(minP+1)))  {
                min = heap.get(minP+1);
                minP = minP+1;
            }

            if( absoluteValue(heap.get(p)) < absoluteValue(min) ||
                    (absoluteValue(heap.get(p)) == absoluteValue(min) && min > heap.get(p)))  {
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
    public int top() {
        if(this.size() == 0)
            return 0;
        else
            return heap.get(1);
    }

    @Override
    public int size() {
        return heap.size()-1;
    }

    private int absoluteValue(int val) {
        if (val < 0)
            val *= -1;
        return val;
    }
}
