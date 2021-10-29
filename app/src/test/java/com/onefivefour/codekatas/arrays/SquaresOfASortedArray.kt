package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
Given an array, rotate the array to the right by k steps, where k is non-negative.
 */
class SquaresOfASortedArray {


    private fun sortedSquares(nums: IntArray): IntArray {

        val result = IntArray(nums.size)

        var currentIndex = 0
        var right = 0

        // find last non-negative index, while already squaring all elements
        for (k in nums.indices) {
            if (nums[k] < 0) {
                right++
            }
            nums[k] = nums[k] * nums[k]
        }

        // set left next to right
        var left = right - 1
        
        // compare left and right until one of them reaches the end of the array
        while (left >= 0 && right <= nums.lastIndex) {
            
            if (nums[left] < nums[right]) {
                result[currentIndex] = nums[left]
                left--
                
            } else {
                result[currentIndex] = nums[right]
                right++
                
            }
            
            currentIndex++
        }
        
        // either finish left pointer
        while (left >= 0) {
            result[currentIndex] = nums[left]
            left--
            currentIndex++
        }
        
        
        // or right pointer
        while (right <= nums.lastIndex) {
            result[currentIndex] = nums[right]
            right++
            currentIndex++
        }
        
        return result
    }


    @Test
    fun test1() {
        val nums = intArrayOf(-4, -1, 0, 3, 10)

        val result = sortedSquares(nums)

        assertThat(result).isEqualTo(intArrayOf(0, 1, 9, 16, 100))
    }

    @Test
    fun test2() {
        val nums = intArrayOf(-7, -3, 2, 3, 11)

        val result = sortedSquares(nums)

        assertThat(result).isEqualTo(intArrayOf(4, 9, 9, 49, 121))
    }

    @Test
    fun test3() {
        val nums = intArrayOf(-1)

        val result = sortedSquares(nums)

        assertThat(result).isEqualTo(intArrayOf(1))
    }

    @Test
    fun test4() {
        val nums = intArrayOf(2)

        val result = sortedSquares(nums)

        assertThat(result).isEqualTo(intArrayOf(4))
    }

    @Test
    fun test5() {
        val nums = intArrayOf(0, 2)

        val result = sortedSquares(nums)

        assertThat(result).isEqualTo(intArrayOf(0, 4))
    }
}