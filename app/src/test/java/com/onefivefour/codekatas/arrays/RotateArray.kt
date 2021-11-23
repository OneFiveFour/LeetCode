package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
Given an array, rotate the array to the right by k steps, where k is non-negative.
 */
class RotateArray {
    
    
    private fun rotate2(nums: IntArray, k: Int) {

        val copy = nums.copyOf()

        for (i in nums.indices) {
            nums[(i + k) % copy.size] = copy[i]
        }

    }
    
    private fun rotate(nums: IntArray, k: Int) {
        
        var shift = k
        while (shift > nums.size) {
            shift -= nums.size
        }

        var left = 0
        var right = nums.lastIndex - shift
        reverse(left, right, nums)


        left = nums.lastIndex - shift + 1
        right = nums.lastIndex
        reverse(left, right, nums)
        
        left = 0
        right = nums.lastIndex
        reverse(left, right, nums)
        
    }

    private fun reverse(left: Int, right: Int, nums: IntArray) {
        var right2 = right
        for (i in left..right2) {
            if (i >= right2) break

            val temp = nums[i]
            nums[i] = nums[right2]
            nums[right2] = temp
            right2--
        }
    }

    @Test
    fun test1() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val k = 3

        rotate(nums, k)

        assertThat(nums).isEqualTo(intArrayOf(5, 6, 7, 1, 2, 3, 4))

    }

    @Test
    fun test2() {
        val nums = intArrayOf(-1, -100, 3, 99)
        val k = 2

        rotate(nums, k)

        assertThat(nums).isEqualTo(intArrayOf(3, 99, -1, -100))

    }

    @Test
    fun test3() {
        val nums = intArrayOf(1, 2)
        val k = 3

        rotate(nums, k)

        assertThat(nums).isEqualTo(intArrayOf(2, 1))

    }

    @Test
    fun test4() {
        val nums = intArrayOf(1, 2, 3)
        val k = 4

        rotate(nums, k)

        assertThat(nums).isEqualTo(intArrayOf(3, 1, 2))

    }

    @Test
    fun test5() {
        val nums = intArrayOf(1, 2)
        val k = 5

        rotate(nums, k)

        assertThat(nums).isEqualTo(intArrayOf(2, 1))

    }
}