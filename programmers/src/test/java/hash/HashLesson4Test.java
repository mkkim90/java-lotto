package hash;

import hash.HashLesson4;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HashLesson4Test {


    @Test
    void getBestSongs() {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] playCount = {500, 600, 150, 800, 2500};
        int[] expected = {4, 1, 3, 0};

        HashLesson4 hashLesson4 = new HashLesson4(genres, playCount);
        assertThat(hashLesson4.solution()).containsExactly(expected);
    }
}
