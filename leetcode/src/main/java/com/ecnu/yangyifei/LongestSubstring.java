package com.ecnu.yangyifei;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (null == s) {
            throw new IllegalArgumentException("must not null");
        }
        int maxLen = 0;
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characterSet.contains(c)) {
                maxLen = Math.max(characterSet.size(), maxLen);
                characterSet = new HashSet<>(c);
                int j = i - 1;
                while (true) {
                    char tmp = s.charAt(j);
                    if (tmp == c) break;
                    characterSet.add(tmp);
                    j--;
                }
            }
            characterSet.add(c);
        }
        return  Math.max(characterSet.size(), maxLen);
    }
}
