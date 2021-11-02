package com.onefivefour.codekatas.strings

import com.google.common.truth.Truth
import org.junit.Test

/**
Given a string s, find the length of the longest substring without repeating characters.
 */
class LongestUniqueSubstring {

    private fun lengthOfLongestSubstring(s: String): Int {

        var test = ""

        // Result
        var maxLength = -1

        // Return zero if string is empty
        if (s.isEmpty()) {
            return 0
            
        } else if (s.length == 1) {
            return 1
            
        }
        
        
        for (c in s.toCharArray()) {
            val current = c.toString()

            // If string already contains the character
            // Then substring after repeating character
            if (test.contains(current)) {
                test = test.substring(test.indexOf(current) + 1)
            }
            test += c.toString()
            maxLength = Math.max(test.length, maxLength)
        }

        return maxLength
    }

    @Test
    fun test1() {
        val input1 = "abcabcbb"

        val result = lengthOfLongestSubstring(input1)

        Truth.assertThat(result).isEqualTo(3)
    }

    @Test
    fun test2() {
        val input1 = "bbbbb"

        val result = lengthOfLongestSubstring(input1)

        Truth.assertThat(result).isEqualTo(1)
    }

    @Test
    fun test3() {
        val input1 = "pwwkew"

        val result = lengthOfLongestSubstring(input1)

        Truth.assertThat(result).isEqualTo(3)
    }


}
