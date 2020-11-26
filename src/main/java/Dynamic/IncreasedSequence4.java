package Dynamic;

import divideSearch.IncreasedSequence;

import java.util.ArrayList;
import java.util.Stack;

public class IncreasedSequence4 {
    private int numCount;
    private int[] count;
    private int[] record;
    private ArrayList<Integer> sequance;
    private int result;
    private int maxIndex;

    public IncreasedSequence4() {
        sequance = new ArrayList<>();
    }

    public void setNumCount(int count) {
        this.numCount = count;
    }

    public void addNum(int val) {
        sequance.add(val);
    }

    public void run() {
        result = 0;
        count = new int[numCount];
        record = new int[numCount];

        for(int i = 0; i < numCount;i ++) {
            count[i] = 1;
            record[i] = -1;
            for(int j = 0; j <= i; j++) {
                if(sequance.get(i) > sequance.get(j) && count[j] + 1 > count[i] ) {
                    count[i] = count[j]+1;
                    record[i] = j;
                }
            }
        }

        maxIndex = 0;
        result = 0;
        for(int i = 0 ; i < numCount; i++) {
            if(count[i] > result) {
                result= count[i];
                maxIndex = i;
            }
        }
    }

    public int getResult(){
        return result;
    }

    public String getRecord() {
        Stack<Integer> stack = new Stack<>();

        int index = maxIndex;
        while( index != -1) {
            stack.push(sequance.get(index));
            index = record[index];
        }

        StringBuilder sb = new StringBuilder();

        while(true) {
            sb.append(stack.pop());
            if(stack.isEmpty()) {
                break;
            } else {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
