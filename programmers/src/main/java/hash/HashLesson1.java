package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HashLesson1 {
    private String[] participants;
    private String[] completions;

    public HashLesson1(String[] participant, String[] completion) {
        validateParticipantCount(participant);
        validateparticipantName(participant);
        validateCompletionSmallerOneThanParticipant(participant, completion);
        this.participants = participant;
        this.completions = completion;
    }

    private void validateParticipantCount(String[] participant) {
        int participantCount = participant.length;
        if (participantCount < 1 || participantCount > 100_000) {
            throw new IllegalArgumentException("마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.");
        }
    }

    private void validateCompletionSmallerOneThanParticipant(String[] participant, String[] completion) {
        int participantCount = participant.length;
        int completionCount = completion.length;
        if (participantCount <= completionCount || participantCount -  completionCount != 1) {
            throw new IllegalArgumentException("completion의 길이는 participant의 길이보다 1 작습니다.");
        }
    }

    private void validateparticipantName(String[] participant) {
        List<String> participants = Arrays.asList(participant);
        List<String> upperEnglishName = participants.stream()
                .filter(i -> !Pattern.matches("^[a-z].{1,20}$", i))
                .collect(Collectors.toList());

        if (!upperEnglishName.isEmpty()) {
            throw new IllegalArgumentException("참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져야 합니다.");
        }
    }

    public String findFailParticipant() {
        Map<String, Integer> hm = new HashMap<>();
        String result = "";
        for (String participant : participants) {
            hm.put(participant, hm.getOrDefault(participant, 0) + 1);
        }

        for (String completion : completions) {
            hm.put(completion, hm.get(completion) -1);
        }

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0) {
                result = key;
                return result;
            }
        }
        return result;
    }
}