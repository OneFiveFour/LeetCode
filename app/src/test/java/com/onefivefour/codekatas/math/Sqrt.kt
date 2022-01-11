package com.onefivefour.codekatas.math

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 */
class Sqrt {

    private fun mySqrt(x: Int): Int {

        if (x < 2) return x

        var mid = x / 2
        var left = 0
        var right = x

        var pow = mid * mid
        var lastPow = 0

        while (lastPow != pow && pow != x) {

            lastPow = pow

            if (pow > x) {
                right = mid
                mid = (left + mid) / 2
            } else {
                left = mid
                mid = (right + mid) / 2
            }

            pow = mid * mid
        }

        return mid
    }


    @Test
    fun test1() {
        val input1 = 25

        val result = mySqrt(input1)

        assertThat(result).isEqualTo(5)
    }




    @Test
    fun test2() {
        val input1 = 5

        val result = mySqrt(input1)

        assertThat(result).isEqualTo(2)
        
        
    }
    
}