package com.onefivefour.codekatas.dp

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.
 */
class MaximumSubarray {


    private fun maxSubArray(nums: IntArray): Int {

        if (nums.isEmpty()) return 0
        
        var maxSum = nums.first()
        var curSum = 0
        
        for (num in nums) {
            
            if (curSum < 0) {
                curSum = 0
            }
            
            curSum += num
            if (curSum > maxSum) {
                maxSum = curSum
            }
            
        }
        
        return maxSum

    }


    @Test
    fun test1() {
        val a1 = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)

        val result = maxSubArray(a1)

        assertThat(result).isEqualTo(6)
    }


    @Test
    fun test2() {
        val a1 = intArrayOf(1)

        val result = maxSubArray(a1)

        assertThat(result).isEqualTo(1)
    }


    @Test
    fun test3() {
        val a1 = intArrayOf(5,4,-1,7,8)

        val result = maxSubArray(a1)

        assertThat(result).isEqualTo(23)
    }


}