package main.java.array;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class SlidingWindow {

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

    @Test
    public void givenString_whenGetUniqueCharacterSubstringCalled_thenResultFoundAsExpected() {
        assertEquals("", longestUniqueSubstring(""));
        assertEquals("A", longestUniqueSubstring("A"));
        assertEquals("ABCDEF", longestUniqueSubstring("AABCDEF"));
        assertEquals("ABCDEF", longestUniqueSubstring("ABCDEFF"));
        assertEquals("NGISAWE", longestUniqueSubstring("CODINGISAWESOME"));
        assertEquals("be coding", longestUniqueSubstring("always be coding"));
    }

}
