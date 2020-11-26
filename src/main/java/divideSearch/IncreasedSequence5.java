package divideSearch;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IncreasedSequence5 {
    List<Integer> list;
    int numCount;
    int[] indexCount;
    int[] number;

    public void setNumCount(int numCount) {
        this.numCount = numCount;
        indexCount = new int[numCount];
        number = new int[numCount];
    }

    public void addNum(int numCount, int i) {
        number[i] = numCount;
    }

    public void run(){

        list = new LinkedList<>();
        list.add(number[0]);
        indexCount[0] = 1;
        for (int i = 1; i < numCount; i++) {
            int t = number[i];

            if(t > list.get(list.size()-1) ) {
                list.add(t);
                indexCount[i] = list.size();
            }
            else {
                int left = 0;
                int right = list.size()-1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    int cmp = list.get(mid);
                    if(cmp >= t) {
                        right = mid;
                    }
                    else {
                        left = mid+1;
                    }
                }
                list.set(right, t);
                indexCount[i] = right+1;
            }
        }
    }

    public String getRecord (){
        int i = list.size();

        Stack<Integer> stack = new Stack<>();
        for(int k = numCount-1; k >= 0 && i != 0 ; k--) {
            if(i == indexCount[k]) {
                stack.push(number[k]);
                i--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(true) {
            sb.append(stack.pop());
            if(!stack.isEmpty()) {
                sb.append(" ");
            } else {
                break;
            }
        }

        return sb.toString();
    }
    public int getResult() {
        return list.size();
    }
}
