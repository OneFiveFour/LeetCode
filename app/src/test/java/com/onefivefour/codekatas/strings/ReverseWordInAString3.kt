package com.onefivefour.codekatas.strings

import com.google.common.truth.Truth
import org.junit.Test

/**
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 */
class ReverseWordInAString3 {

    private fun reverseWords(s: String): String {

        if (s.length < 2) return s

        val sArray = s.toCharArray()

        var lastWhiteSpace = -1

        for (i in sArray.indices) {

            if (sArray[i] == ' ') {
                val startIndex = Math.min(lastWhiteSpace + 1, sArray.lastIndex)
                val endIndex = Math.max(i-1, 0)
                reverse(sArray, startIndex, endIndex)
                lastWhiteSpace = i
            }
            
            if (i == sArray.lastIndex) {
                val startIndex = Math.min(lastWhiteSpace + 1, sArray.lastIndex)
                reverse(sArray, startIndex, sArray.lastIndex)
            }


        }

        return String(sArray)
    }

    private fun reverse(s: CharArray, startIndex: Int, endIndex: Int) {
        var left = startIndex
        var right = endIndex

        while (left < right) {
            val temp = s[left]
            s[left] = s[right]
            s[right] = temp

            left++
            right--
        }
    }


    @Test
    fun test1() {
        val input = "Let's take LeetCode contest"

        val result = reverseWords(input)

        Truth.assertThat(result).isEqualTo("s'teL ekat edoCteeL tsetnoc")
    }

    @Test
    fun test2() {
        val input = "God Ding"

        val result = reverseWords(input)

        Truth.assertThat(result).isEqualTo("doG gniD")
    }

    @Test
    fun test3() {
        val input = "OneWord"

        val result = reverseWords(input)

        Truth.assertThat(result).isEqualTo("droWenO")
    }

    @Test
    fun test4() {
        val input = "  OneWord"

        val result = reverseWords(input)

        Truth.assertThat(result).isEqualTo("  droWenO")
    }

    @Test
    fun test5() {
        val input = "OneWord  "

        val result = reverseWords(input)

        Truth.assertThat(result).isEqualTo("droWenO  ")
    }

}
