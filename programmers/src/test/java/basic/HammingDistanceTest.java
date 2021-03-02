package basic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * a = 3 -> 11
 * b = 2 -> 10
 *
 * a & b = 10 : 두비트가 모두 1이면 1, 아니면 0
 * a | b = 11 : 두비트중 하나라도 1이면 1, 아니면 0
 * a ^ b = 01 : 두비트가 다르면 1, 아니면 0
 *
 * a >> 1 = 01 : a의 모든 비트를 오른쪽으로 i만큼 밀고, 맨 왼쪽을 0으로 채움
 * a << 1 = 10 : a의 모든 비트를 왼쪽으로 i만큼 밀고, 맨 오른을 0으로 채움
 */
public class HammingDistanceTest {
    @Test
    void solution() {
        int ret = hammingDistance(1,4);
        assertThat(ret).isEqualTo(2);
    }

    private int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            cnt += (xor >> i) & 1;
        }
        return cnt;
    }
}
