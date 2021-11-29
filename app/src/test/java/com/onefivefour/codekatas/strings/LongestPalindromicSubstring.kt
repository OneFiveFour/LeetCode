package com.onefivefour.codekatas.strings

import com.google.common.truth.Truth
import org.junit.Test

/**
Given a string s, return the longest palindromic substring in s.
 */
class LongestPalindromicSubstring {

    private fun longestPalindrome(s: String): String {

        var result = ""

        for (i in s.indices) {

            val s1 = expandAround(s, i, i)
            val s2 = expandAround(s, i, i + 1)

            val curPalindrome = if (s1.length > s2.length) s1 else s2

            if (curPalindrome.length > result.length) {
                result = curPalindrome
            }
        }


        return result
    }


    private fun expandAround(s: String, left: Int, right: Int) : String {
        if (left < 0 || right > s.lastIndex || s[left] != s[right]) return ""

        var l = left
        var r = right

        while (l >= 0 && r <= s.lastIndex && s[l] == s[r]) {
            l--
            r++
        }

        return s.substring(l+1, r)

    }


    @Test
    fun test1() {
        val input1 = "babadferrefllab"

        val result = longestPalindrome(input1)

        Truth.assertThat(result).isEqualTo("ferref")
    }

    @Test
    fun test2() {
        val input1 = "cbbd"

        val result = longestPalindrome(input1)

        Truth.assertThat(result).isEqualTo("bb")
    }


    @Test
    fun test3() {
        val input1 = "a"

        val result = longestPalindrome(input1)

        Truth.assertThat(result).isEqualTo("a")
    }


    @Test
    fun test4() {
        val input1 = "ac"

        val result = longestPalindrome(input1)

        Truth.assertThat(result).isEqualTo("a")
    }


}
