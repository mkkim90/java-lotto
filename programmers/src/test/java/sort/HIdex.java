package sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class HIdex {
    @Test
    void solution() {
        int[] citations = {3, 0, 6, 1, 5};
        int answer = hIndex(citations);
        assertThat(answer).isEqualTo(3);
    }

    private int hIndex(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for (int i = citations.length-1; i >= 0; i--) {
            if (citations[i] <= answer) {
                break;
            }
            answer++;
        }
        return answer;
    }
}
