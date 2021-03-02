package carrot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test2 {
    private static final String TYPE_ONE_PREFIX = "010-";
    private static final String TYPE_TWO_PREFIX = "010";
    private static final String TYPE_THREE_PREFIX = "+82-10-";
    private static final String DELIMETER = "-";

    @Test
    void solution() {
        /*유형 1 : 010-XXXX-XXXX
        유형 2 : 010 XXXX XXXX
        유형 3 : +82-10-XXXX-XXXX*/
        assertThat(getType("01012345678")).isEqualTo(2);
        assertThat(getType("010123456789")).isEqualTo(-1);
        assertThat(getType("01012345678-9")).isEqualTo(-1);
        assertThat(getType("+82-10-2345-1234")).isEqualTo(3);
        assertThat(getType("010-1234-5678")).isEqualTo(1);
        assertThat(getType("01012-345678-9")).isEqualTo(-1);
        assertThat(getType("&*-01012345678-9")).isEqualTo(-1);

    }

    private int getType(String str) {
        if (str.startsWith(TYPE_TWO_PREFIX) && isNumber(str) && str.length() == 11) {
            return 2;
        }

        String[] splits = str.split(DELIMETER);
        if (!isMiddlePhoneNumberAndLastPhoneNumber(splits)) {
            return -1;
        }

        if (str.startsWith(TYPE_ONE_PREFIX) && splits.length == 3) {
            return 1;
        }

        if (str.startsWith(TYPE_THREE_PREFIX) && splits.length == 4) {
            return 3;
        }

        return -1;
    }

    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    private boolean isMiddlePhoneNumberAndLastPhoneNumber(String[] splits) {
        int phoneNumLength = 4;
        int splitLength = splits.length;
        return isNumber(splits[splitLength - 1])
                && isNumber(splits[splitLength - 2])
                && splits[splitLength - 1].length() == phoneNumLength
                && splits[splitLength - 2].length() == phoneNumLength;
    }
}
