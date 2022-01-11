package com.onefivefour.codekatas.math

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 */
class FactorialTrailingZeroes {

    private fun trailingZeroes(n: Int): Int {

        var zeroes = 0L

        var powerOfFive = 5L

        while (powerOfFive <= n) {
            zeroes += n / powerOfFive
            powerOfFive *= 5
        }

        return zeroes.toInt()

    }


    @Test
    fun test1() {
        val input1 = 10

        val result = trailingZeroes(input1)

        assertThat(result).isEqualTo(2)
    }


    @Test
    fun test2() {
        val input1 = 30

        val result = trailingZeroes(input1)

        assertThat(result).isEqualTo(7)
    }
    
}