package Tmp;

public class Test3 {
    public int solution(int money, String[] expected, String[] actual) {
        int answer;
        int size = expected.length;
        int betMoney = 100;
        for(int i = 0 ; i < size && money > 0; i++) {
            if(expected[i] == actual[i]) {
                money += betMoney;
                betMoney = 100;
            }
            else {
                money -= betMoney;

                if(betMoney *2 > money )
                    betMoney = money;
                else
                    betMoney *= 2;
            }
        }
        answer = money;
        return answer;
    }
}
