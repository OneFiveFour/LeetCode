package com.onefivefour.codekatas.arrays

import org.junit.Test

import org.junit.Assert.*

/**
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */
class AreThereDuplicates {


    private fun containsDuplicate(nums: IntArray): Boolean {
        val memory = HashMap<Int, Boolean>()
        nums.forEach { num ->
            if (memory[num] == true) {
                return true
            } else {
                memory[num] = true
            }
        }
        return false
    }


    @Test
    fun testFixed1() {
        val nums = intArrayOf(1,2,3,1)
        
        val result = containsDuplicate(nums)

        assertEquals(true, result)
    }

    @Test
    fun testFixed2() {
        val nums = intArrayOf(1,2,3,4)
        
        val result = containsDuplicate(nums)

        assertEquals(false, result)
    }

    @Test
    fun testFixed3() {
        val nums = intArrayOf(1,1,1,3,3,4,3,2,4,2)
        
        val result = containsDuplicate(nums)

        assertEquals(true, result)
    }

}