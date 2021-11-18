package com.onefivefour.codekatas.math

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. 
However, the numeral for four is not IIII. Instead, the number four is written as IV. 
Because the one is before the five we subtract it making four. 
The same principle applies to the number nine, which is written as IX. 
There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.
 */
class RomanToInteger {
    fun romanToInt(s: String): Int {

        if (s.isEmpty()) return 0
        
        var result = 0
        
        for (charIndex in s.lastIndex downTo 0) {
            
            val char = s[charIndex]
            
            result += when (char) {
                'I' -> if (result == 5 || result == 10) -1 else 1
                'V' ->  5
                'X' ->  if (result / 10 == 5 || result / 10 == 10) -10 else 10
                'L' ->  50
                'C' ->  if (result / 100 == 5 || result / 100 == 10) -100 else 100
                'D' ->  500
                'M' ->  1000
                else -> 0
            }
            
            
        }
        
        return result
    }



    @Test
    fun test1() {
        val input = "III"
        
        val result = romanToInt(input)
        
        assertThat(result).isEqualTo(3)
    }


    @Test
    fun test2() {
        val input = "IV"
        
        val result = romanToInt(input)
        
        assertThat(result).isEqualTo(4)
    }


    @Test
    fun test3() {
        val input = "IX"
        
        val result = romanToInt(input)
        
        assertThat(result).isEqualTo(9)
    }


    @Test
    fun test4() {
        val input = "LVIII"
        
        val result = romanToInt(input)
        
        assertThat(result).isEqualTo(58)
    }


    @Test
    fun test5() {
        val input = "MCMXCIV"

        val result = romanToInt(input)

        assertThat(result).isEqualTo(1994)
    }


    @Test
    fun test6() {
        val input = "MMMCMXCIX"

        val result = romanToInt(input)

        assertThat(result).isEqualTo(3999)
    }
}