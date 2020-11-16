package Tmp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Test6 {
    public String[] solution(String[] logs) {
        String[] answer = {};
        ArrayList<Tester> testers = new ArrayList<>();
        int[] checkId = new int[10000];

        for (int i = 1; i < checkId.length; i++) {
            checkId[i] = -1;
        }

        int index = 0;
        for (int i = 0; i < logs.length; i++) {
            Tester tester;
            String[] log = logs[i].split( " ");

            int id = Integer.parseInt(log[0]);
            if(checkId[id] == -1) {
                checkId[id] = index;
                index++;
                testers.add(new Tester(log[0]));
            }
            tester = testers.get(checkId[id]);

            tester.addScore(Integer.parseInt(log[1]), Integer.parseInt(log[2]));
        }

        for(Iterator<Tester> it = testers.iterator(); it.hasNext();) {
            Tester t = it.next();
            if(t.getTotalCount() < 5) {
                it.remove();
            } else
                t.sortQuiz();
        }

        boolean[] badPeople = new boolean[testers.size()];

        for(int i=0; i< testers.size(); i++) {
            if(badPeople[i])
                continue;
            for (int j = i+1; j< testers.size(); j++) {
                if(badPeople[j])
                    continue;
                boolean check = testers.get(i).checkEquals(testers.get(j));
                if(check) {
                    badPeople[i] = true; badPeople[j] = true;
                }
            }
        }

        ArrayList<String> tmp = new ArrayList<>();
        for (int i =0; i < badPeople.length; i++) {
            if (badPeople[i])
                tmp.add(testers.get(i).getIdCode());
        }

        if(tmp.size() == 0)
            answer = new String[]{ "None" };
        else
            answer= tmp.stream().toArray(String[]::new);
        return answer;
    }
}

class Tester {
    private String idCode;
    private int totalScore;
    private int totalCount;

    private int[] scores;
    private ArrayList<Integer> quizNumbers;

    public Tester (String idCode) {
        this.idCode = idCode;
        scores = new int[101];
        quizNumbers = new ArrayList<Integer>();
        totalScore = 0;
        totalCount = 0;
    }

    public void addScore(int quizNumber, int score) {
        this.quizNumbers.add(quizNumber);
        this.scores[quizNumber] = score;
        totalScore += score;
        totalCount++;
    }

    public void sortQuiz(){
        Collections.sort(quizNumbers);
    }

    public String getIdCode() {
        return idCode;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getScore(int index) {
        return scores[quizNumbers.get(index)];
    }

    public boolean checkEquals(Tester obj) {
        if(obj.totalCount != this.totalCount)
            return false;
        if(obj.totalScore != this.totalScore)
            return false;

        for(int i : this.quizNumbers) {
            if(obj.getScore(i) != this.getScore(i))
                return false;
        }
        return true;
    }
}
