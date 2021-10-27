package com.onefivefour.codekatas.strings

import com.google.common.truth.Truth
import org.junit.Test
import java.lang.NumberFormatException

/**
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

1. Read in and ignore any leading whitespace.
2. Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
3. Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
5. If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -2^31 should be clamped to -2^31, and integers greater than 2^31 - 1 should be clamped to 2^31 - 1.
6. Return the integer as the final result.

Note:
Only the space character ' ' is considered a whitespace character.
Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 */
class StringToInteger {

    private fun myAtoi(s: String): Int {

        val validChars = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

        var left = 0

        var sign = 1

        while (left < s.length) {

            val currentChar = s[left]

            // read until no whitespace
            if (currentChar == ' ') {
                left++
                continue
            }

            // check for sign
            if (currentChar == '-') {
                left++
                sign = -1
                break

            } else if (currentChar == '+') {
                left++
                break

            } else if (!validChars.contains(currentChar)) {
                return 0

            } else {
                break
                
            }
        }


        // collect number
        var numberAsString = ""
        while (left < s.length && validChars.contains(s[left])) {
            numberAsString += s[left]
            left++
        }

        // check if there was a number
        if (numberAsString.isEmpty()) {
            return 0
        }

        return try {
            Math.min(numberAsString.toInt(), Int.MAX_VALUE) * sign
        } catch (e: NumberFormatException) {
            if (sign == -1) Int.MIN_VALUE else Int.MAX_VALUE
        }
    }


    @Test
    fun test1() {
        val input1 = "42"

        val result = myAtoi(input1)

        Truth.assertThat(result).isEqualTo(42)
    }

    @Test
    fun test2() {
        val input1 = "   -42"

        val result = myAtoi(input1)

        Truth.assertThat(result).isEqualTo(-42)
    }

    @Test
    fun test3() {
        val input1 = "4193 with words"

        val result = myAtoi(input1)

        Truth.assertThat(result).isEqualTo(4193)
    }

    @Test
    fun test4() {
        val input1 = "words and 987"

        val result = myAtoi(input1)

        Truth.assertThat(result).isEqualTo(0)
    }

    @Test
    fun test5() {
        val input1 = "-91283472332"

        val result = myAtoi(input1)

        Truth.assertThat(result).isEqualTo(-2147483648)
    }

    @Test
    fun test6() {
        val input1 = "+-12"

        val result = myAtoi(input1)

        Truth.assertThat(result).isEqualTo(0)
    }


}
