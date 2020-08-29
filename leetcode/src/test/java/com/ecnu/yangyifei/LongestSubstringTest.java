package com.ecnu.yangyifei;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/LongestSubString.csv", numLinesToSkip = 1)
    void lengthOfLongestSubstring(String input, int expected) {
        assertEquals(expected, new LongestSubstring().lengthOfLongestSubstring(input));

    }
}