package basic;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * nums = [2, 7, 8, 13]
 * target = 9
 *
 * result = [0,1]
 *
 * 방법 모든 조건 검색
 * 1. brute-force 2중 루프 n ( n-1 ) / 2
 *  - 시간 O(n^2)
 *  - 공간 O(1)
 * 2. 해쉬맵 사용
 *  - 시간 O(n)
 *  - 공간 O(n)
 */
public class TwoSumTest {
    @Test
    void solution() {
        int[] nums = {2, 7, 8, 13};
        int target = 9;

        int[] result = twosum(nums, target);

        assertThat(result).containsExactly(0,1);
    }

    private int[] twosum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }

            map.put(nums[i], i);
        }

        return result;
    }
}
