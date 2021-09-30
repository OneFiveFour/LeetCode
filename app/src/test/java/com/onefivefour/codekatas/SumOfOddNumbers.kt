package com.onefivefour.codekatas

import org.junit.Test

import org.junit.Assert.*
import kotlin.math.pow

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
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