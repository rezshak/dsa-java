package main.java.array;

import java.util.*;

class SlidingWindow {

    static String longestUniqueSubstring(String str) {
        Map<Character, Integer> seen = new HashMap<>();
        String result = "";
        for (int left = 0, right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            if (seen.containsKey(ch)) {
                left = Math.max(seen.get(ch) + 1, left);
            }
            if (result.length() < right - left + 1) {
                result = str.substring(left, right + 1);
            }
            seen.put(ch, right);
        }
        return result;
    }

}
