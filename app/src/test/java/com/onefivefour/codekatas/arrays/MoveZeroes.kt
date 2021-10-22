package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.
 */
class MoveZeroes {


    private fun moveZeroes(digits: IntArray) {

        var nonZeroIndex = 0

        for (i in digits.indices) {
            if (digits[i] != 0) {
                digits[nonZeroIndex] = digits[i]
                nonZeroIndex++
            }
        }
        
        for (i in nonZeroIndex until digits.size) {
            digits[i] = 0
        }

    }


    @Test
    fun test1() {
        val a1 = intArrayOf(0, 1, 0, 3, 12)

        moveZeroes(a1)

        assertThat(a1).isEqualTo(intArrayOf(1, 3, 12, 0, 0))
    }

    @Test
    fun test2() {
        val a1 = intArrayOf(0)

        moveZeroes(a1)

        assertThat(a1).isEqualTo(intArrayOf(0))
    }

    @Test
    fun test3() {
        val a1 = intArrayOf(0, 1, 0, 0, 0, 3, 12)

       moveZeroes(a1)

        assertThat(a1).isEqualTo(intArrayOf(1, 3, 12, 0, 0, 0, 0))
    }

    @Test
    fun test4() {
        val a1 = intArrayOf(0, 0, 1)

        moveZeroes(a1)

        assertThat(a1).isEqualTo(intArrayOf(1, 0, 0))
    }

    @Test
    fun test5() {
        val a1 = intArrayOf(1, 0)

        moveZeroes(a1)

        assertThat(a1).isEqualTo(intArrayOf(1, 0))
    }

}