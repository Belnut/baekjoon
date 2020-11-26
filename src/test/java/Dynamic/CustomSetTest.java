package Dynamic;

import Dijkstra.Exercise;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CustomSetTest {
    private static String TEST_FILE_PATH = "/Dynamic/CustomSet/";

    @Test
    public void test1() {
        try {
            BufferedReader qr = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.in").getPath()));
            BufferedReader ar = new BufferedReader(new FileReader( getClass().getResource(TEST_FILE_PATH + "test1.out").getPath()));

            String[] tmp;
            CustomSet cs = new CustomSet();

            cs.empty();
            int count = Integer.parseInt(qr.readLine());

            for(int i = 0; i < count; i++) {
                tmp = qr.readLine().split(" ");
                String order = tmp[0];
                int num = 0;
                if(tmp.length != 1)
                    num = Integer.parseInt(tmp[1]);

                if(order.startsWith("add")) {
                    cs.add(num);
                }
                else if(order.startsWith("remove")) {
                    cs.remove(num);
                }
                else if (order.startsWith("check")) {
                    assertThat(cs.check(num), is(Integer.parseInt(ar.readLine())));
                }
                else if(order.startsWith("toggle")) {
                    cs.toggle(num);
                }
                else if(order.startsWith("all")) {
                    cs.all();
                }
                else if(order.startsWith("empty")) {
                    cs.empty();
                }
                else {
                    throw new RuntimeException();
                }
            }
            ar.close();
            qr.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
