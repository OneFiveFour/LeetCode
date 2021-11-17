package com.onefivefour.codekatas.dp

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
class HouseRobber {


    private fun rob(nums: IntArray): Int {

        if (nums.isEmpty()) return 0
        
        if (nums.size == 1) return nums[0]
        
        if (nums.size == 2) return Math.max(nums[0], nums[1])
        
        val profits = IntArray(nums.size)
        
        profits[0] = nums[0]
        profits[1] = Math.max(nums[0], nums[1])

        for (i in 2 .. nums.lastIndex) {
            profits[i] = Math.max(nums[i] + profits[i-2], profits[i-1])
        }

        return profits.last()
    }


    @Test
    fun test1() {
        val a1 = intArrayOf(1, 2, 3, 1)

        val result = rob(a1)

        assertThat(result).isEqualTo(4)
    }


    @Test
    fun test2() {
        val a1 = intArrayOf(2, 7, 9, 3, 1)

        val result = rob(a1)

        assertThat(result).isEqualTo(12)
    }


    @Test
    fun test3() {
        val a1 = intArrayOf(2, 7, 9, 3, 1, 5, 1, 1, 1, 8)

        val result = rob(a1)

        assertThat(result).isEqualTo(25)
    }


}