package Tmp2;

import Dynamic.ParkSungWon;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class tt2 {
    @Test
    public void t1() {

        int[] goods = { 5,31,15};
        ArrayList<Integer> maxGoods = new ArrayList<>();
        ArrayList<Integer> minGoods = new ArrayList<>();

        int minus = 0;
        int rst = 0;


        for(int i = 0; i < goods.length; i++) {
            if(goods[i] >= 50) {
                maxGoods.add(goods[i]);
            }
            else {
                minGoods.add(goods[i]);
            }
            rst += goods[i];
        }

        //미달 물품들로 50 이상값을 가지는 value 찾기
        while(!minGoods.isEmpty()) {
            if(minGoods.size() < 2) {
                break;
            }

            int newGood = minGoods.get(0);
            newGood += minGoods.get( minGoods.size()-1 );

            minGoods.remove(minGoods.size()-1);
            minGoods.remove(0);

            Iterator<Integer> iterator = minGoods.iterator();
            while(iterator.hasNext()) {
                if(newGood >= 50) break;
                newGood += iterator.next();
                minGoods.remove(iterator);
            }
            if(newGood >= 50 ) {
                maxGoods.add(newGood);
            }
            else {
                break;
            }
        }

        minus = 10 * maxGoods.size();
        assertThat(rst - minus, is(97));
    }

    @Test
    public void tt2() {
        int page = 151241;
        int[] broken = {0,1,2,3,4,7,8,9};
        int[] unbroken = new int[10 - broken.length];
        Arrays.sort(broken);

        int bindex = 0;
        int nbIndex = 0;
        for(int i = 0 ; i < 10; i++) {
            if(bindex < broken.length && broken[bindex] == i) {
                bindex++;
                continue;
            } else {
                unbroken[nbIndex] = i;
                nbIndex++;
            }
        }

        int target = page;
        Stack<Integer> s = new Stack<>();

        int clickCount = 0;
        while (target != 0) {
            int checkNum = target % 10;
            target /= 10;

            int min = 10;
            int v = 0;
            for(int i = 0 ; i< unbroken.length; i++) {
                if(min > sub(checkNum,unbroken[i])) {
                    min = sub(checkNum,unbroken[i]);
                    v = unbroken[i];
                }
            }
            s.add(v);
            clickCount++;
        }

        int makePage=0;
        int maxTen = 1;
        while(!s.isEmpty()) {
            makePage += s.pop();
            makePage*=10;
            maxTen*=10;
        }
        makePage /= 10;

        int plus = sub(page, makePage);
        int minus = sub(page, makePage + (maxTen * unbroken[0]));

        int plusClickCount = plus + clickCount;
        int minusClickCount = minus + clickCount + 1;
        int originClickCount = sub(100, page);

        clickCount = Integer.min(plusClickCount, minusClickCount);
        clickCount = Integer.min(clickCount, originClickCount);
        assertThat(clickCount, is(6));
    }

    public int sub(int x, int y) { return x > y ? x-y : y-x; }

    @Test
    public void tt3() {
        String s = "aaaabbbbc";
        int n= 5;

        int[] charactor = new int[26];
        int total = s.length();
        for(int i = 0 ; i< s.length(); i++) {
            int t = s.charAt(i) - 'a';
            charactor[t]+=1;
        }

        ArrayList<Integer> charList = new ArrayList<>();
        for(int i = 0 ; i< 26; i++ ){
            if(charactor[i] != 0)
                charList.add(charactor[i]);
        }
        Queue<Integer> minQ = new PriorityQueue<>();
        Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());


        for(int i = 0 ; i < charList.size(); i++) {
            minQ.add(charList.get(i));
            maxQ.add(charList.get(i));
        }
        int min = 500000;
        for(int i = 0; i< n; i++) {

            Queue<Integer> tmpMaxQ = new PriorityQueue<>(maxQ);
            Queue<Integer> tmpMinQ = new PriorityQueue<>(minQ);
            for(int j = 0 ; j < n-i; j++) {
                int maxSub = j;
                int minSub = i-j;

                int x = maxQ.poll();
            }
        }
    }

    @Test
    public void tt4() {
        String cardNumber = "26227174957722514961366";

        int[] num = new int[cardNumber.length()+1];

        for(int i = 0 ; i < cardNumber.length(); i++) {
            num[i+1] = Integer.parseInt(cardNumber.charAt(i) + "");
        }

        if(cardNumber.length()%2 == 0) {
            for(int x = 1; x <= cardNumber.length(); x += 2) {
                num[x] *= 2;
            }
        }
        else {
            for(int x = 0; x <= cardNumber.length(); x += 2) {
                num[x] *= 2;
            }
        }

        int sum = 0;
        for (int n : num) {
            while(n!= 0) {
                sum += n%10;
                n/=10;
            }
        }

        if(sum %10 != 0)
            assertThat("INVALID", is(""));
        else
            assertThat("VALID", is(""));

    }

    @Test
    public void tt5() {
        int[] votes = {5,10,7,3,8};
        if(votes.length == 1)
            return;// 0;

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int target = votes[0];
        int count = 0;

        for(int i = 1; i< votes.length; i++) {
            queue.add(votes[i]);
        }

        while(true) {
            int max = queue.poll();
            if(target > max ) break;

            int nextMax;
            if(queue.isEmpty()) {
                nextMax=0;
            }else {
                nextMax = queue.peek();
            }
            while( max >= nextMax) {
                target += 1;
                max -= 1;
                if(target > max) break;
            }
            queue.add(max);
        }

        assertThat(target - votes[0], is(-1));
        return; //target - vote[0];
    }
}
