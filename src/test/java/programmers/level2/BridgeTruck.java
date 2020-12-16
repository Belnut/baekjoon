package programmers.level2;

import java.util.*;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BridgeTruck {
    @Test
    public void solution() {
        int bridge_length= 5;
        int weight = 5;
        int[] truck_weights = {1, 1, 1, 1, 1, 2, 2};

        int answer = 0;
        int bridge_weight = 0;
        Queue<Integer> bridge = new LinkedList<>();

        while(bridge.size() < bridge_length)
            bridge.add(0);

        for (int truck_w : truck_weights) {
            if (bridge_weight + truck_w > weight) {
                while (true) {
                    answer++;
                    bridge_weight -= bridge.poll();
                    if(bridge_weight + truck_w <= weight)
                        break;
                    bridge.add(0);
                }
                bridge.add(truck_w);
                bridge_weight+=truck_w;
            }
            else {
                answer++;
                bridge.add(truck_w);
                bridge_weight += truck_w;
                bridge_weight -= bridge.poll();
            }
        }
        while(bridge_weight != 0) {
            bridge_weight -= bridge.poll();
            answer++;
        }

        assertThat(answer, is(14));
    }

}
