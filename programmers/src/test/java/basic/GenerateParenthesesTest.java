package basic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 백트랙킹
 * n = 3 일때
 * ((()))
 * (()())
 * (())()
 * ()(())
 * ()()()
 * recursion + termination check
 */
public class GenerateParenthesesTest {
    @Test
    void solution() {
        int n = 3;
        List<String> ret = new ArrayList<>();
        process(3, 0,0,"", ret);
        assertThat(ret.size()).isEqualTo(5);
    }

    private void process(int n, int openNum, int closeNum, String str, List<String> ret) {
        // termination check
        if (openNum == n && closeNum == n) {
            ret.add(str);
            return;
        }
        // recursion
        if (n > openNum)
            process(n, openNum + 1, closeNum, str + "(", ret);

        if (openNum > closeNum)
            process(n, openNum, closeNum + 1, str + ")", ret);
    }
}
