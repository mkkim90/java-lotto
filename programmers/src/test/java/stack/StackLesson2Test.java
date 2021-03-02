package stack;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * 주식가격 : 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return
 *
 * prices	        |    return
 * [1, 2, 3, 2, 3]  |	[4, 3, 1, 1, 0]
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 * soultion2 참고
 */
public class StackLesson2Test {

    @Test
    void result() {
        int [] prices = {1, 2, 3, 2, 3};
        int [] result = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {

            Queue<Integer> q = getQ(i, prices);
            result[i] = getNotDownPriceTime(q);
        }
        assertThat(result).containsExactly(4,3,1,1,0);
    }

    private Queue<Integer> getQ(int index, int[] prices) {
        Queue<Integer> q = new LinkedList<>();
        for (int j = index; j < prices.length; j++) {
            q.offer(prices[j]);
        }
        return q;
    }

    private int getNotDownPriceTime(Queue<Integer> q) {
        int currentPrice = q.poll();
        int result = 0;
        while (!q.isEmpty()) {
            result++;
            if (currentPrice > q.poll()) {
                break;
            }
        }
        return result;
    }

    @Test
    void result2() {
        int [] prices = {1, 2, 3, 2, 3};
        assertThat(solution2(prices)).containsExactly(4,3,1,1,0);
    }

    public int[] solution2(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        int i, j;
        for (i = 0; i < len; i++) {
            for (j = i + 1; j < len; j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        return answer;
    }
}
