package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 */
class MissingNumber {


    private fun missingNumber(nums: IntArray): Int {

        val range = nums.size
        var sum = (range * (range + 1)) / 2

        for (num in nums) {
            sum -= num
        }

        return sum
    }


    @Test
    fun test1() {
        val a1 = intArrayOf(3, 0, 1)

        val result = missingNumber(a1)

        assertThat(result).isEqualTo(2)
    }

    @Test
    fun test2() {
        val a1 = intArrayOf(0, 1)

        val result = missingNumber(a1)

        assertThat(result).isEqualTo(2)
    }

    @Test
    fun test3() {
        val a1 = intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)

        val result = missingNumber(a1)

        assertThat(result).isEqualTo(8)
    }

    @Test
    fun test4() {
        val a1 = intArrayOf(0)

        val result = missingNumber(a1)

        assertThat(result).isEqualTo(1)
    }


}