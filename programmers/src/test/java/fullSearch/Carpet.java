package fullSearch;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * brown	yellow	return
 * 10	2	[4, 3]
 * 8	1	[3, 3]
 * 24	24	[8, 6]
 */
public class Carpet {
    @Test
    void solution() {
        int brown = 10;
        int yellow = 2;
        int cnt = brown + yellow;
        int answer[] = new int[2];
        for (int i = 1; i < cnt; i++) {
            if (cnt % i == 0 && 2*i + 2*((cnt/i)-2)==brown) {
                answer[1] = i;
                answer[0] = cnt / i;
                break;
            }
        }

        assertThat(answer).containsExactly(4, 3);

    }
}
