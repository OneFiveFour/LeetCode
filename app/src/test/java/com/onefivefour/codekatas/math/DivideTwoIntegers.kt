package com.onefivefour.codekatas.math

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. 
For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
 */
class DivideTwoIntegers {

    private val HALF_INT_MIN = Int.MIN_VALUE / 2

    private fun divide(dividend: Int, divisor: Int): Int {

        var divd = dividend
        var divs = divisor

        if (divd == Int.MIN_VALUE && divs == -1) {
            return Int.MAX_VALUE;
        }

        var negatives = 2
        if (divd > 0) {
            negatives--
            divd = -divd
        }

        if (divs > 0) {
            negatives--
            divs = -divs
        }


        var quotient = 0
        while (divs >= divd) {

            var powersOfTwo = -1

            var value = divs

            while (value >= HALF_INT_MIN && value + value >= divd) {
                value += value
                powersOfTwo += powersOfTwo
            }

            quotient += powersOfTwo
            divd -= value
        }


        if (negatives != 1) {
            return -quotient
        }

        return quotient
    }


    @Test
    fun test1() {
        val input1 = 10
        val input2 = 3

        val result = divide(input1, input2)

        assertThat(result).isEqualTo(3)
    }


    @Test
    fun test2() {
        val input1 = -2147483648
        val input2 = -1

        val result = divide(input1, input2)

        assertThat(result).isEqualTo(2147483647)
    }
    
}