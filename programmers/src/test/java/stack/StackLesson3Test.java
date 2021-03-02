package stack;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 기능 개발
 * Detail
 * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
 * 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
 * <p>
 * progresses	            speeds	            return
 * [93, 30, 55]	            [1, 30, 5]	        [2, 1]
 * [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
 */
public class StackLesson3Test {

    @Test
    void solution() {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.offer((int) Math.ceil((100 - progresses[i]) / speeds[i]));
        }

        List<Integer> result = getBuildSchedule(q);
        assertThat(result).containsExactly(1, 3, 2);
    }

    private List<Integer> getBuildSchedule(Queue<Integer> q) {
        List<Integer> buildSchedule = new ArrayList<>();
        int count = 1;
        int pre = q.poll();
        while (!q.isEmpty()) {
            int current = q.poll();
            if (pre >= current) {
                count++;
                continue;
            }

            buildSchedule.add(count);
            pre = current;
            count = 1;
        }
        buildSchedule.add(count);
        return buildSchedule;
    }

    private int getDay(int progress, int speed) {
        return (int) Math.ceil((100 - progress) / speed);
    }


    @Test
    void solution2() {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] dayOfend = new int[100];
        int day = -1;
        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] + (day * speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        int[] answer = Arrays.stream(dayOfend).filter(i -> i != 0).toArray();

        assertThat(answer).containsExactly(1, 3, 2);
    }
}
