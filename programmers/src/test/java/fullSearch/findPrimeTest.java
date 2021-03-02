package fullSearch;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class findPrimeTest {

    int answer = 0;
    @Test
    public void solution() {
        String str = "17";
        char[] numbers = str.toCharArray();
        boolean[] visited = new boolean[numbers.length];

        for (int i = 0; i <= numbers.length; i++) {
            combination(numbers, visited, 0, numbers.length, i);
        }

        assertThat(answer).isEqualTo(3);
    }

    private void combination(char[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
           print(arr, visited, n);
           return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    private void print(char[] arr, boolean[] visited, int n) {
        String comb = "";
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                comb += arr[i];
            }
        }
        if (comb != "" && isPrime(Integer.parseInt(comb))) {
            answer++;
        }
    }

    private boolean isPrime(int num) {
        if (num == 0 || num == 1)  {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    @Test
    void permutationTest() {
        String str = "17";
        HashSet<Integer> set = new HashSet<>();
        permutation("", str, set);
    }

    private void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);

    }
}
