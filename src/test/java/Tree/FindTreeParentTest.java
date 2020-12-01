package Tree;

import Dynamic.DSLR;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindTreeParentTest {
    private static String TEST_FILE_PATH = "/Tree/FindTreeParent/";

    @Test
    public void test1() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.out").getPath()));

            FindTreeParent ftp = new FindTreeParent();
            int nodeSize = Integer.parseInt(qr.readLine());
            ftp.setSize(nodeSize);


            for(int i = 1; i < nodeSize; i++) {
                String[] tmp = qr.readLine().split(" ");
                ftp.addRoute(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
            }

            ftp.run();
            for(int i = 2; i <= nodeSize; i++) {
                int parent = ftp.getParent(i);
                int expParent = Integer.parseInt(ar.readLine());
                System.out.println(parent);
                assertThat(parent, is(expParent));
            }
            ar.close();
            qr.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test2() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test3.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test3.out").getPath()));

            FindTreeParent ftp = new FindTreeParent();
            int nodeSize = Integer.parseInt(qr.readLine());
            ftp.setSize(nodeSize);


            for(int i = 1; i < nodeSize; i++) {
                String[] tmp = qr.readLine().split(" ");
                ftp.addRoute(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
            }

            ftp.run();
            for(int i = 2; i <= nodeSize; i++) {
                int parent = ftp.getParent(i);
                int expParent = Integer.parseInt(ar.readLine());
                assertThat(parent, is(expParent));
            }
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

            FindTreeParent ftp = new FindTreeParent();
            int nodeSize = Integer.parseInt(qr.readLine());
            ftp.setSize(nodeSize);


            for(int i = 1; i < nodeSize; i++) {
                String[] tmp = qr.readLine().split(" ");
                ftp.addRoute(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
            }

            ftp.run();
            for(int i = 2; i <= nodeSize; i++) {
                int parent = ftp.getParent(i);
                int expParent = Integer.parseInt(ar.readLine());
                assertThat(parent, is(expParent));
            }
            ar.close();
            qr.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
