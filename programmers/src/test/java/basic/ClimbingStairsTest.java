package basic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 1 2 3 5 8 : 피보나치 수열
 * f(n) = f(n-1) + f(n-2)
 * f(5) = f(4) + f(3)
 * f(4) = f(3) + f(2)
 * 재귀구현을 하면 : 공간복잡도 O(1) 시간복잡도 O(2^n)
 * f(2) = 2
 * f(3) = 3
 * 다이나믹 프로그래밍 -> 공간복잡도 O(n) 시간복잡도 O(n)
 * 점화식을 찾아야 한
 */
public class ClimbingStairsTest {
    @Test
    void solution() {
        int n = 5;
        assertThat(climbingStairs(n)).isEqualTo(8);
    }

    private int climbingStairs(int n) {
        if (n <= 3) return n;

        int[] d = new int[n+1];
        d[1] = 1;
        d[2] = 2;
        for (int i = 3; i <= n; i++) {
            d[i] = d[i-1] + d[i-2];
        }
        return d[n];
    }
}
