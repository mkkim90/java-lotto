package hash;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HashLesson3Test {
    /**
     * 의상 경우의 수
     * (의상종류의 수 + 1) * (다른 의상종류의 수 + 1) -1
     * +1의 경우 홀로의 경우
     * -1의 경우 아무것도 착용하지 않은 경우
     *
     * https://programmers.co.kr/learn/courses/30/lessons/42578
    */
    @Test
    void clothesCase() {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        int count = getCount(clothes);
        assertThat(count).isEqualTo(5);
    }

    private int getCount(String[][] clothes) {
        Map<String, Integer> hm = new HashMap<>();
        for (String[] clothe : clothes) {
            hm.put(clothe[1], hm.getOrDefault(clothe[1],0) + 1);
        }
        int count = 1;
        for (String key : hm.keySet()) {
            count *= hm.get(key) + 1;
        }
        count -= 1;
        return count;
    }

    @Test
    void clothesCase2() {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        int count = getCount2(clothes);
        assertThat(count).isEqualTo(5);
    }

    public int getCount2(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    }
}
