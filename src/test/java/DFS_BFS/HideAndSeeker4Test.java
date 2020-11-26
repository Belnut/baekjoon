package DFS_BFS;

import divideSearch.IncreasedSequence5;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HideAndSeeker4Test {
    //둘중 하나만 정답이면 ok;
    private static String TEST_FILE_PATH = "/DFS_BFS/HideAndSeeker4/";

    @Test
    public void test1() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.out").getPath()));

            HideAndSeek4 has4 = new HideAndSeek4();

            String[] tmp = qr.readLine().split(" ");
            has4.setSeeker(Integer.parseInt(tmp[0]));
            has4.setHider(Integer.parseInt(tmp[1]));

            has4.run();

            int rst = has4.getResult();
            String record = has4.getRecord();

            String expVal = ar.readLine();
            String expRec = ar.readLine();

            assertThat(rst, is(Integer.parseInt(expVal)));
            assertThat(record, is(expRec));
            ar.close();
            qr.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test2() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test2.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test2.out").getPath()));

            HideAndSeek4 has4 = new HideAndSeek4();

            String[] tmp = qr.readLine().split(" ");
            has4.setSeeker(Integer.parseInt(tmp[0]));
            has4.setHider(Integer.parseInt(tmp[1]));

            has4.run();

            int rst = has4.getResult();
            String record = has4.getRecord();

            String expVal = ar.readLine();
            String expRec = ar.readLine();

            assertThat(rst, is(Integer.parseInt(expVal)));
            assertThat(record, is(expRec));
            ar.close();
            qr.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void test3() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test3.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test3.out").getPath()));

            HideAndSeek4 has4 = new HideAndSeek4();

            String[] tmp = qr.readLine().split(" ");
            has4.setSeeker(Integer.parseInt(tmp[0]));
            has4.setHider(Integer.parseInt(tmp[1]));

            has4.run();

            int rst = has4.getResult();
            String record = has4.getRecord();

            String expVal = ar.readLine();
            String expRec = ar.readLine();

            assertThat(rst, is(Integer.parseInt(expVal)));
            assertThat(record, is(expRec));
            ar.close();
            qr.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void test4() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test4.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test4.out").getPath()));

            HideAndSeek4 has4 = new HideAndSeek4();

            String[] tmp = qr.readLine().split(" ");
            has4.setSeeker(Integer.parseInt(tmp[0]));
            has4.setHider(Integer.parseInt(tmp[1]));

            has4.run();

            int rst = has4.getResult();
            String record = has4.getRecord();

            String expVal = ar.readLine();
            String expRec = ar.readLine();

            assertThat(rst, is(Integer.parseInt(expVal)));
            assertThat(record, is(expRec));
            ar.close();
            qr.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test5() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test5.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test5.out").getPath()));

            HideAndSeek4 has4 = new HideAndSeek4();

            String[] tmp = qr.readLine().split(" ");
            has4.setSeeker(Integer.parseInt(tmp[0]));
            has4.setHider(Integer.parseInt(tmp[1]));

            has4.run();

            int rst = has4.getResult();
            String record = has4.getRecord();

            String expVal = ar.readLine();
            String expRec = ar.readLine();

            assertThat(rst, is(Integer.parseInt(expVal)));
            assertThat(record, is(expRec));
            ar.close();
            qr.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static int N, K;
    static int[] parent = new int[100001];
    static int[] time = new int[100001];

    @Test
    public void test6() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test3.in").getPath()));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        // 순서대로 구하기 위해 stack 에 담았다가 다시 pop
        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }

        // 최종 출력
        sb.append(time[K] - 1 + "\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb.toString());
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(N);
        time[N] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == K) return;

            for (int i=0; i<3; i++) {
                int next;

                if (i == 0)         next = now + 1;
                else if (i == 1)    next = now - 1;
                else                next = now * 2;

                if (next < 0 || next > 100000) continue;

                if (time[next] == 0) {
                    q.add(next);
                    time[next] = time[now] + 1;
                    parent[next] = now;
                }
            }
        }
    }
}
