package Heap;
import java.util.ArrayList;
public class MaxHeap implements Heap{
    ArrayList<Integer> heap;

    public MaxHeap(){
        heap = new ArrayList<Integer>();
        heap.add(null);
    }

    @Override
    public void add(int val) {
        heap.add(val);
        int p = heap.size()-1;

        while (p > 1 && heap.get(p/2) < heap.get(p) ) {
            int tmp = heap.get(p/2);
            heap.set(p/2, heap.get(p));
            heap.set(p, tmp);

            p /= 2;
        }
    }

    @Override
    public int delete() {
        if(heap.size()-1 < 1)
            return 0;

        int deleteItem = heap.get(1);
        heap.set(1, heap.get( heap.size()-1 ));
        heap.remove(heap.size()-1);

        int p = 1;
        while( (p*2) < heap.size() ) {
            int max = heap.get(p*2);
            int maxP = p*2;

            if (maxP +1 < heap.size() && max < heap.get(maxP + 1)) {
                max = heap.get(maxP + 1);
                maxP = maxP+1;
            }

            if(heap.get(p) > max) {
                break;
            }

            int tmp = heap.get(p);
            heap.set(p, heap.get(maxP));
            heap.set(maxP, tmp);
            p = maxP;

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
