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
class LongestCommonPrefix {

    private fun longestCommonPrefix(strs: Array<String>): String {

        if (strs.size == 1) return strs.first()
        
        if (strs.any { s -> s.isEmpty() }) return ""
     
        // find shortest String
        var shortestString = strs.first()
        
        for (i in 1 .. strs.lastIndex) {
            if (strs[i].length < shortestString.length) {
                shortestString = strs[i]
            }            
        }
        
        // iterate over shortest string
        for (i in shortestString.indices) {
            
            for (j in strs.indices) {
                
                // all good so far, next char
                if (strs[j][i] == shortestString[i]) continue
                
                // mismatch at the very first position -> no common prefix at all
                if (i == 0) return ""
                
                // found common prefix
                return shortestString.substring(0 until i)
                
            }
            
        }
        
        // whole shortest string is everywhere
        return shortestString
    }

    @Test
    fun test1() {
        val input1 = arrayOf("flower","flow","flight")

        val result = longestCommonPrefix(input1)
        
        Truth.assertThat(result).isEqualTo("fl")
    }

    @Test
    fun test2() {
        val input1 = arrayOf("dog","racecar","car")

        val result = longestCommonPrefix(input1)
        
        Truth.assertThat(result).isEqualTo("")
    }

    @Test
    fun test3() {
        val input1 = arrayOf("dog", "doggy", "dog")

        val result = longestCommonPrefix(input1)
        
        Truth.assertThat(result).isEqualTo("dog")
    }

    @Test
    fun test4() {
        val input1 = arrayOf("a", "ab")

        val result = longestCommonPrefix(input1)
        
        Truth.assertThat(result).isEqualTo("a")
    }


}
