package basic;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * ( -> ) 매칭
 * [ -> ] 매칭
 * { -> } 매칭
 */
public class ValidParenthesesTest {
    @Test
    void solution() {
        String str = "[{()}]";
        assertThat(validParentheses(str)).isTrue();
    }

    private boolean validParentheses(String str) {
        char[] c = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(' || c[i] == '[' || c[i] == '{') {
                stack.push(c[i]);
            } else if (c[i] == ')' && (stack.size() == 0 || stack.pop() != '(')) {
                return false;
            } else if (c[i] == ']' && (stack.size() == 0 || stack.pop() != '[')) {
                return false;
            } else if (c[i] == '}' && (stack.size() == 0 || stack.pop() != '{')) {
                return false;
            }
        }

        return stack.size() == 0;
    }
}
