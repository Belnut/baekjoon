package Heap;

public class MiddleHeap implements Heap {
    MaxHeap maxHeap;
    MinHeap minHeap;
    public MiddleHeap() {
        maxHeap = new MaxHeap();
        minHeap = new MinHeap();
    }
    @Override
    public void add(int val) {

        if(maxHeap.size() > minHeap.size() ) {
            minHeap.add(val);
        } else {
            maxHeap.add(val);
        }

        if(minHeap.size() != 0 && maxHeap.top() > minHeap.top() ) {
            int tmp = minHeap.top();
            minHeap.delete();
            minHeap.add(maxHeap.top());
            maxHeap.delete();
            maxHeap.add(tmp);
        }
    }

    @Override
    public int delete() {
        return 0;
    }
    @Override
    public int top() {
        if(this.size() == 0)
            return 0;
        return maxHeap.top();
    }
    @Override
    public int size() {
        return maxHeap.size() + minHeap.size();
    }
}
