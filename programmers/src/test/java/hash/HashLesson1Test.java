package hash;

import hash.HashLesson1;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class HashLesson1Test {

    @Test
    void findFailParticipant() {
        String[] participants = {"mislav", "stanko", "mislav", "ana"};
        String[] completions = {"stanko", "ana", "mislav"};
        HashLesson1 hashLesson1 = new HashLesson1(participants, completions);
        String result = hashLesson1.findFailParticipant();
        assertThat(result).isEqualTo("mislav");
    }
}
