package com.onefivefour.codekatas.strings

import com.google.common.truth.Truth
import org.junit.Test

/**
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. 
Then for each group, say the number of characters, then say the character. 
To convert the saying into a digit string, replace the counts with a number and concatenate every saying.

countAndSay(1) -> 1
countAndSay(2) -> 11
countAndSay(3) -> 21
countAndSay(4) -> 1211
countAndSay(5) -> 111221
 
 
 */
class CountAndSay {

    private fun countAndSay(n: Int): String {

        return if (n == 1) {
            "1"
        } else {
            val previousTerm = countAndSay(n-1)
            processString(previousTerm)
        }
    }

    private fun processString(s: String): String {
        
        var result = ""
        
        var currentChar = s[0]
        
        var currentCount = 0
        
        for (i in s.indices) {
            
            if (s[i] == currentChar) {
                currentCount++
                
            } else {
                
                // store previous char
                result += "$currentCount$currentChar"
                
                // reset helper vars for next char
                currentChar = s[i]
                currentCount = 1
                
            }
            
        }

        // store last char
        result += "$currentCount$currentChar"
        
        return result
    }

    @Test
    fun test1() {
        val input = 1

        val result = countAndSay(input)

        Truth.assertThat(result).isEqualTo("1")
    }


    @Test
    fun test2() {
        val input = 2

        val result = countAndSay(input)

        Truth.assertThat(result).isEqualTo("11")
    }


    @Test
    fun test3() {
        val input = 3

        val result = countAndSay(input)

        Truth.assertThat(result).isEqualTo("21")
    }


    @Test
    fun test4() {
        val input = 4

        val result = countAndSay(input)

        Truth.assertThat(result).isEqualTo("1211")
    }


    @Test
    fun test5() {
        val input = 5

        val result = countAndSay(input)

        Truth.assertThat(result).isEqualTo("111221")
    }


}