package Tmp;


import java.util.LinkedList;
import java.util.Queue;

public class Test5 {
    private String[] reservedKey;

    public String solution(String penter, String pexit, String pescape, String data) {
        reservedKey = new String[3];
        reservedKey[0] = penter;
        reservedKey[1] = pexit;
        reservedKey[2] = pescape;

        int count = data.length() / penter.length();
        int size = penter.length();

        StringBuilder sb = new StringBuilder();
        sb.append(penter);

        for (int i = 0; i < count; i++) {
            int index = i * size;
            String subData = data.substring(index, index + size);

            if (duplicateCheck(subData)) {
                sb.append(pescape);
            }
            sb.append(subData);
        }
        sb.append(pexit);
        return sb.toString();
    }

    boolean duplicateCheck(String data) {
        for(int i = 0 ; i< reservedKey.length; i++) {
            if(reservedKey[i].equals(data))
                return true;
        }
        return false;
    }
}
