package com.onefivefour.codekatas.dp

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.
 */
class JumpGame {


    fun canJump2(nums: IntArray): Boolean {
        if (nums.size == 0 || nums.size == 1) {
            return true
        }

        var canJumpTo = nums[0]

        for (i in 1 .. nums.lastIndex) {

            if (canJumpTo == 0) return false

            canJumpTo = Math.max(nums[i-1]-1, nums[i])

            if (i + canJumpTo >= nums.lastIndex) {
                return true
            }

            nums[i] = canJumpTo


        }

        return false
    }

    fun canJump(nums: IntArray): Boolean {
        
        
        
        return false
        
    }
    

    @Test
    fun test1() {
        val a1 = intArrayOf(2,3,1,1,4)

        val result = canJump(a1)

        assertThat(result).isTrue()
    }

    @Test
    fun test2() {
        val a1 = intArrayOf(3,2,1,0,4)

        val result = canJump(a1)

        assertThat(result).isFalse()
    }

    @Test
    fun test3() {
        val a1 = intArrayOf(0,1)

        val result = canJump(a1)

        assertThat(result).isFalse()
    }


} 