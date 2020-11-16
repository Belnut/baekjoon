package Tmp;

public class Test2 {
    public long[] solution(String s, String op) {
        long[] answer = {};
        int size = s.length();
        answer = new long[size-1];

        for(int i = 1 ; i < size; i++ ) {
            long first = Long.parseLong(s.substring(0, i));
            long last = Long.parseLong(s.substring(i));

            switch (op) {
                case "+":
                    answer[i-1] = first + last;
                    break;
                case "-":
                    answer[i-1] = first - last;
                    break;
                case "*":
                    answer[i-1] = first * last;
                    break;
                default:
                    throw new RuntimeException();
            }
        }
        return answer;
    }
}
