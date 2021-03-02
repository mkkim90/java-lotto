package hash;

import java.util.*;

/**
 * 1. 장르 - 노래 고유 번호, 재생 수로 넣는다.
 * 2. 장르 - 총 장르별 재생 수를 넣는다.
 * 3. 장르 - 총 장르별 재생 수의 가장 큰 재생 수로 정렬한다.
 * 4. 가장 큰 재생 수의 장르 - 노래 고유 번호, 재생 수의 가장 큰 재생수로 정렬한다.
 * 5. 그리고 두개의 노래 고유 번호만 배열에 담는다.
 * <p>
 * <p>
 * https://programmers.co.kr/learn/courses/30/lessons/42579
 */
public class HashLesson4 {
    private String[] genres;
    private int[] plays;

    public HashLesson4(String[] genres, int[] plays) {
        this.genres = genres;
        this.plays = plays;
    }

    public int[] solution() {
        Map<String, HashMap<Integer, Integer>> genresMap = new HashMap<String, HashMap<Integer, Integer>>();      //<장르, 곡 정보>
        Map<String, Integer> playMap = new HashMap<String, Integer>(); //<장르, 총 장르 재생수>

        for (int i = 0; i < genres.length; i++) {
            String key = genres[i];
            HashMap<Integer, Integer> infoMap;   // 곡 정보 : <곡 고유번호, 재생횟수>
            infoMap = getSongInfo(genresMap, key);
            infoMap.put(i, plays[i]);
            genresMap.put(key, infoMap);

            playMap.put(key, playMap.getOrDefault(key, 0) + plays[i]);

        }

        Iterator it = sortByValue(playMap).iterator();
        List<Integer> bestSongs = new ArrayList<Integer>();
        while (it.hasNext()) {
            String key = (String) it.next();
            Iterator sortedManyPlayCountSongInfo = sortByValue((HashMap<Integer, Integer>) genresMap.get(key)).iterator();
            bestSongs.addAll(getBestSongs(sortedManyPlayCountSongInfo));
        }

        return convertInt(bestSongs);
    }

    private int[] convertInt(List<Integer> bestSongs) {
        int[] answer = new int[bestSongs.size()];

        for (int i = 0; i < bestSongs.size(); i++) {
            answer[i] = bestSongs.get(i).intValue();
        }

        return answer;
    }

    private List<Integer> getBestSongs(Iterator indexIt) {
        List<Integer> bestSongs = new ArrayList<Integer>();
        int cnt = 0;
        while (indexIt.hasNext()) {
            bestSongs.add((int) indexIt.next());
            cnt++;
            if (cnt > 1) break;
        }
        return bestSongs;
    }

    private HashMap<Integer, Integer> getSongInfo(Map<String, HashMap<Integer, Integer>> genresMap, String key) {
        if (genresMap.containsKey(key)) {
            return genresMap.get(key);
        }
        return new HashMap<Integer, Integer>();
    }

    private ArrayList sortByValue(final Map map) {
        ArrayList<Object> keyList = new ArrayList();
        keyList.addAll(map.keySet());

        Collections.sort(keyList, new Comparator() {
            public int compare(Object o1, Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);

                return ((Comparable) v2).compareTo(v1);
            }
        });

        return keyList;
    }
}
