package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 */
class TwoSum {


    private fun twoSum(nums: IntArray, target: Int) : IntArray {

        
        for (left in 0 until nums.lastIndex) {
            for (right in left+1..nums.lastIndex) {
                if (nums[left] + nums[right] == target) {
                    return intArrayOf(left, right)
                }
            }
        }
        
        return intArrayOf(-1, -1)
        
    }


    @Test
    fun test1() {
        val a1 = intArrayOf(2,7,11,15)

        val result = twoSum(a1, 9)

        assertThat(result).isEqualTo(intArrayOf(0,1))
    }

    @Test
    fun test2() {
        val a1 = intArrayOf(3,2,4)

        val result = twoSum(a1, 6)

        assertThat(result).isEqualTo(intArrayOf(1,2))
    }

    @Test
    fun test3() {
        val a1 = intArrayOf(3,3)

        val result = twoSum(a1, 6)

        assertThat(result).isEqualTo(intArrayOf(0,1))
    }


}