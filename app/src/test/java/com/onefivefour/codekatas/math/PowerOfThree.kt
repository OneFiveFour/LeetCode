package com.onefivefour.codekatas.math

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
 * Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3^x.
 */
class PowerOfThree {


    private fun isPowerOfThree(n: Int): Boolean {

        if (n == 1) return true
        if (n < 2) return false

        // 3^0 = 1
        // 3^1 = 3
        // 3^2 = 9
        // 3^3 = 27
        // 3^4 = 81
        // divide by 3 until x % 3 == 1
        
        var i = n
        while (i % 3 == 0) {
            i /= 3
        }
        
        return i == 1
        
    }


    @Test
    fun test1() {
        val input = 27

        val result = isPowerOfThree(input)

        assertThat(result).isTrue()
    }


    @Test
    fun test2() {
        val input = 0

        val result = isPowerOfThree(input)

        assertThat(result).isFalse()
    }

    @Test
    fun test3() {
        val input = 9

        val result = isPowerOfThree(input)

        assertThat(result).isTrue()
    }

    @Test
    fun test4() {
        val input = 45

        val result = isPowerOfThree(input)

        assertThat(result).isFalse()
    }

    @Test
    fun test5() {
        val input = 19684

        val result = isPowerOfThree(input)

        assertThat(result).isFalse()
    }


}