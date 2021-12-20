package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.
 */
class SortColors {


    private fun sortColors(nums: IntArray) {

        var zero = 0
        var one = 0
        var two = 0

        for (num in nums) {
            when (num) {
                0 -> zero++
                1 -> one++
                2 -> two++
            }
        }

        for (z in 0 until zero) {
            nums[z] = 0
        }

        for (o in zero until (zero + one)) {
            nums[o] = 1
        }
        
        for (t in (zero + one) until (zero + one + two)) {
            nums[t] = 2
        }          
    }
    
    


    @Test
    fun test1() {
        val nums = intArrayOf(2, 0, 2, 1, 1, 0)

        sortColors(nums)

        assertThat(nums).isEqualTo(intArrayOf(0, 0, 1, 1, 2, 2))
    }


}