package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 */
class IncreasingTripletSubsequence {


    private fun increasingTriplet(nums: IntArray): Boolean {
        var lowest = Int.MAX_VALUE
        var mid = Int.MAX_VALUE

        for (num in nums) {
            when {
                // new lowest value found. Even if we have a mid value at this point, 
                // it is enough for us to "know" that there is a sequence from the previous
                // lowest to the current mid. If anything, the sequence is only going lower
                // after this update
                num <= lowest -> lowest = num
                
                // new mid value found. Even if the previous mid value was in front of the current
                // lowest (because we found a new lowest after we found a mid value): This is just
                // creating a new possible subsequence which has lower numbers than the previous one.
                num <= mid -> mid = num
                
                // Whenever we reach this, at some point while updating lowest and mid, there was a time 
                // where "lowest < mid" && "indexOf(lowest) < indexOf(mid)". So we found a subsequence now.
                else -> return true
            }
        }

        return false
    }

    @Test
    fun test1() {
        val input = intArrayOf(1, 2, 3, 4, 5)

        val result = increasingTriplet(input)

        assertThat(result).isTrue()
    }

    @Test
    fun test2() {
        val input = intArrayOf(5, 4, 3, 2, 1)

        val result = increasingTriplet(input)

        assertThat(result).isFalse()
    }

    @Test
    fun test3() {
        val input = intArrayOf(2, 1, 5, 0, 4, 6)

        val result = increasingTriplet(input)

        assertThat(result).isTrue()
    }

    @Test
    fun test4() {
        val input = intArrayOf(20, 100, 10, 12, 5, 13)

        val result = increasingTriplet(input)

        assertThat(result).isTrue()
    }
}