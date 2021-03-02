package carrot;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Test1 {
    @Test
    void solution() {
        int position = 0;
        Map<Character, Integer> m = new HashMap<>();
        List<Character> l = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            m.put(i, ++position);
            l.add(i);
        }

        String input = "hellopython";
        String key = "abcdefghijk";
        char[] inputs = input.toCharArray();
        char[] keys = key.toCharArray();
        String answer = "";
        for (int i = 0; i < inputs.length; i++) {
            int inputIdx = m.get(inputs[i]);
            int keyIdx = m.get(keys[i]);
            int encrytIdx = inputIdx + keyIdx;
            if (encrytIdx >= l.size()) {
                encrytIdx %= l.size();
            }
            answer += l.get(encrytIdx-1);
        }

        System.out.println(answer);
    }

    @Test
    void shiftTest() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        leftShift(list);
        leftShift(list);
        assertThat(list).containsExactly(3,4,5,6,1,2);

        rightShift(list);
        rightShift(list);
        assertThat(list).containsExactly(1,2,3,4,5,6);
    }

    private void leftShift(List<Integer> list) {
        list.add(list.size(), list.get(0));
        list.remove(0);
    }

    private void rightShift(List<Integer> list) {
        list.add(0, list.get(list.size()-1));
        list.remove(list.size()-1);
    }

}
