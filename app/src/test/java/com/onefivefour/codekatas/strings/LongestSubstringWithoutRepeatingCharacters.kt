package com.onefivefour.codekatas.strings

import com.google.common.truth.Truth
import org.junit.Test

/**
Given a string s, find the length of the longest substring without repeating characters.
 */
class LongestSubstringWithoutRepeatingCharacters {

    private fun lengthOfLongestSubstring(s: String): Int {

        if (s.length < 2) return s.length

        var left = 0
        var right = 1

        var result = -1
        var testString = s.substring(0, 1)

        while (right < s.length) {

            if (testString.contains(s[right])) {
                result = Math.max(result, right - left)
                left += testString.indexOf(s[right]) + 1
            }


            right++

            testString = s.substring(left, right)

        }

        return Math.max(result, right - left)
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

    @Test
    fun test4() {
        val input1 = "au"

        val result = lengthOfLongestSubstring(input1)

        Truth.assertThat(result).isEqualTo(2)
    }


}
