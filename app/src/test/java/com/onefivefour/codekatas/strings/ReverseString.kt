package com.onefivefour.codekatas.strings

import com.google.common.truth.Truth
import org.junit.Test

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 */
class ReverseString {

    private fun reverseString(s: CharArray) {
       
        val midPoint = (s.size / 2) - 1
        if (midPoint < 0) return
        var reverseIndex = s.lastIndex
        
        for (i in 0 .. midPoint) {
            val temp = s[i]
            s[i] = s[reverseIndex]
            s[reverseIndex] = temp            
            reverseIndex--    
        }
        
    }


    @Test
    fun test1() {
        val input = charArrayOf('h','e','l','l','o')

        reverseString(input)

        Truth.assertThat(input).isEqualTo(charArrayOf('o','l','l','e','h'))
    }

}