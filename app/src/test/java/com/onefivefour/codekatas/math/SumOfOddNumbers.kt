package com.onefivefour.codekatas.math

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Given the triangle of consecutive odd numbers:

1
3     5
7     9    11
13    15    17    19
21    23    25    27    29
...
Calculate the sum of the numbers in the nth row of this triangle (starting at index 1) e.g.: (Input --> Output)

1 -->  1
2 --> 3 + 5 = 8
 */
class SumOfOddNumbers {
    

// 1       1               1
// 3       8            3     5
// 6      27         7     9    11
// 10     64      13    15    17    19
// 15    125   21    23    25    27    29
    private fun rowSumOddNumbers(num: Int) : Int {
        
        return Math.pow(num.toDouble(), 3.0).toInt()
        
    }


    @Test
    fun basicTests() {
        assertEquals(1, rowSumOddNumbers(1))
        assertEquals(8, rowSumOddNumbers(2))
        assertEquals(2197, rowSumOddNumbers(13))
        assertEquals(6859, rowSumOddNumbers(19))
        assertEquals(68921, rowSumOddNumbers(41))
        assertEquals(74088, rowSumOddNumbers(42))
        assertEquals(405224, rowSumOddNumbers(74))
        assertEquals(636056, rowSumOddNumbers(86))
        assertEquals(804357, rowSumOddNumbers(93))
        assertEquals(1030301, rowSumOddNumbers(101))
    }
}