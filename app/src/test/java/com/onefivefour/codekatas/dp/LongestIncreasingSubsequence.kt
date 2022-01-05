package com.onefivefour.codekatas.dp

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. 
For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 */
class LongestIncreasingSubsequence {

    fun lengthOfLIS(nums: IntArray): Int {

        if (nums.isEmpty()) return 0

        if (nums.size == 1) return 1

        val dp = IntArray(nums.size) { 1 }

        for (i in 1 .. nums.lastIndex) {

            for (k in i downTo 0) {

                if (dp[k] < dp[i]) {

                    dp[i] = Math.max(dp[k] + 1, dp[i])

                }

            }

        }

        var result = 1
        for (n in dp) {
            if (n > result) {
                result = n
            }
        }


        return result
    }

    @Test
    fun test1() {
        val input1 = intArrayOf(10,9,2,5,3,7,101,18)

        val result = lengthOfLIS(input1)

        assertThat(result).isEqualTo(4)
    }

    @Test
    fun test2() {
        val input1 = intArrayOf(0,1,0,3,2,3)

        val result = lengthOfLIS(input1)

        assertThat(result).isEqualTo(4)
    }

    @Test
    fun test3() {
        val input1 = intArrayOf(7,7,7,7,7,7,7)

        val result = lengthOfLIS(input1)

        assertThat(result).isEqualTo(1)
    }



} 