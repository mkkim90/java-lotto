package hash;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HashLesson2Test {

    @Test
    void isPrefixPhoneBook() {
        String[] phoneBooks ={"123", "456", "789"};
        assertThat(solution(phoneBooks)).isTrue();
    }

    private boolean solution(String[] phoneBooks) {
        Set<String> phoneBookSet= new HashSet<>(Arrays.asList(phoneBooks));
        for (int i = 0; i < phoneBooks.length; i++) {
            if (!isPrefixPhoneBook(phoneBookSet, phoneBooks[i])) {
                return false;
            };
        }

        return true;
    }

    private boolean isPrefixPhoneBook(Set<String> phoneBookSet, String phone) {
        Iterator<String> it = phoneBookSet.iterator();
        while(it.hasNext()){
            String str = it.next();
            if (str.indexOf(phone) == 0 && !str.equals(phone)) {
                return false;
            }
        }

        return true;
    }

    @Test
    void isPrefixPhoneBook2() {
        String[] phoneBooks ={"12","123","1235","567","88"};
        assertThat(solution2(phoneBooks)).isFalse();
        String[] phoneBooks2 = {"119", "97674223", "1195524421"};
        assertThat(solution2(phoneBooks2)).isFalse();
        String[] phoneBooks3 = {"123","456","789"};
        assertThat(solution2(phoneBooks3)).isTrue();
    }

    private boolean solution2(String[] phoneBooks) {
        for (int i = 0; i < phoneBooks.length-1; i++) {
            for (int j = i+1; j < phoneBooks.length; j++) {
                if(phoneBooks[i].startsWith(phoneBooks[j])) {return false;}
                if(phoneBooks[j].startsWith(phoneBooks[i])) {return false;}
            }
        }
        return true;
    }

}
