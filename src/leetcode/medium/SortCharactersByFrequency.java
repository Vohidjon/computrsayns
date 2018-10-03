package leetcode.medium;

import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Queue<Letter> letters = new PriorityQueue<>((o1, o2) -> o2.frequency - o1.frequency);

        Map<Character, Letter> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if(map.containsKey(ch)) {
                map.get(ch).frequency++;
            } else {
                map.put(ch, new Letter(ch, 1));
            }
        }
        for (Map.Entry<Character, Letter> entry : map.entrySet()) {
            letters.add(entry.getValue());
        }
        StringBuffer buffer = new StringBuffer();
        while (!letters.isEmpty()) {
            Letter l = letters.poll();
            while (l.frequency > 0) {
                buffer.append(l.ch);
                l.frequency--;
            }
        }
        return buffer.toString();
    }

    class Letter {
        public Character ch;
        public Integer frequency;

        public Letter(Character ch, Integer frequency) {
            this.ch = ch;
            this.frequency = frequency;
        }

    }
}
