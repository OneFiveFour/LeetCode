package com.onefivefour.codekatas.strings

import com.google.common.truth.Truth
import org.junit.Test

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 */
class ReverseString {

    private fun reverseString(s: CharArray) {

        var left = 0
        var right = s.lastIndex

        while (left< right) {
            val temp = s[left]
            s[left] = s[right]
            s[right] = temp

            left++
            right--
        }
        
    }


    @Test
    fun test1() {
        val input = charArrayOf('h','e','l','l','o')

        reverseString(input)

        Truth.assertThat(input).isEqualTo(charArrayOf('o','l','l','e','h'))
    }

}