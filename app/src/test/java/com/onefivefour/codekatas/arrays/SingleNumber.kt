package com.onefivefour.codekatas.arrays

import org.junit.Test

import org.junit.Assert.*

/**
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */
class SingleNumber {


    private fun singleNumber(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        for (num in nums) {
            if (map.contains(num)) {
                map.remove(num)
            } else {
                map[num] = num
            }
        }
        return map.keys.first()
    }


    @Test
    fun testFixed1() {
        val nums = intArrayOf(2, 2, 1)

        val result = singleNumber(nums)

        assertEquals(1, result)
    }

    @Test
    fun testFixed2() {
        val nums = intArrayOf(4, 1, 2, 1, 2)

        val result = singleNumber(nums)

        assertEquals(4, result)
    }

    @Test
    fun testFixed3() {
        val nums = intArrayOf(1)

        val result = singleNumber(nums)

        assertEquals(1, result)
    }

}