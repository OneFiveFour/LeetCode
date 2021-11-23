package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.
 */
class PlusOne {


    private fun plusOne(digits: IntArray): IntArray {

        for (i in digits.lastIndex downTo 0) {

            if (digits[i] == 9) {
                digits[i] = 0
                if (i == 0) {
                    return intArrayOf(1) + digits
                }
            } else {
                digits[i] += 1
                return digits
            }
        }

        return digits
    }


    @Test
    fun test1() {
        val a1 = intArrayOf(1, 2, 3)

        val result = plusOne(a1)

        assertThat(result).isEqualTo(intArrayOf(1, 2, 4))
    }

    @Test
    fun test2() {
        val a1 = intArrayOf(4, 3, 2, 1)

        val result = plusOne(a1)

        assertThat(result).isEqualTo(intArrayOf(4, 3, 2, 2))
    }

    @Test
    fun test3() {
        val a1 = intArrayOf(0)

        val result = plusOne(a1)

        assertThat(result).isEqualTo(intArrayOf(1))
    }

    @Test
    fun test4() {
        val a1 = intArrayOf(9)

        val result = plusOne(a1)

        assertThat(result).isEqualTo(intArrayOf(1, 0))
    }


}