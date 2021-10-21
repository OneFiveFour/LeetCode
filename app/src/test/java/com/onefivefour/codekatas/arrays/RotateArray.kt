package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
Given an array, rotate the array to the right by k steps, where k is non-negative.
 */
class RotateArray {


    @Test
    fun test1() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val k = 3

        val result = rotate(nums, k)

        assertThat(result).isEqualTo(intArrayOf(5, 6, 7, 1, 2, 3, 4))

    }

    @Test
    fun test2() {
        val nums = intArrayOf(-1, -100, 3, 99)
        val k = 2

        val result = rotate(nums, k)

        assertThat(result).isEqualTo(intArrayOf(3, 99, -1, -100))

    }

    @Test
    fun test3() {
        val nums = intArrayOf(1, 2)
        val k = 3

        val result = rotate(nums, k)

        assertThat(result).isEqualTo(intArrayOf(2, 1))

    }

    @Test
    fun test4() {
        val nums = intArrayOf(1, 2, 3)
        val k = 4

        val result = rotate(nums, k)

        assertThat(result).isEqualTo(intArrayOf(3, 1, 2))

    }

    @Test
    fun test5() {
        val nums = intArrayOf(1, 2)
        val k = 5

        val result = rotate(nums, k)

        assertThat(result).isEqualTo(intArrayOf(2, 1))

    }

    private fun rotate(nums: IntArray, k: Int): IntArray {

        val copy = nums.copyOf()

        for (i in nums.indices) {
            nums[(i + k) % copy.size] = copy[i]
        }

        return nums
    }
}