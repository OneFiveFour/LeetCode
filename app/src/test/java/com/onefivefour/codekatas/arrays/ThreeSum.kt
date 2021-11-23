package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.util.*


/**
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 */
class ThreeSum {


    private fun threeSum(nums: IntArray): List<List<Int>> {

        if (nums.size < 3) return emptyList()

        Arrays.sort(nums)

        val result = arrayListOf<List<Int>>()

        for (i in nums.indices) {
            
            if (i > 0 && nums[i] == nums[i-1]) continue
            
            var left = i + 1
            var right = nums.lastIndex

            val target = 0 - nums[i]

            while (left < right) {

                val sum = nums[left] + nums[right]

                when {
                    sum == target -> {
                        result.add(listOf(nums[i], nums[left], nums[right]))

                        while (left < right && nums[left] == nums[left+1]) left++
                        while (right < right && nums[right] == nums[right - 1]) right--

                        left++
                        right--

                    }
                    sum < target -> left++
                    else -> right--
                }

            }

        }

        return result
       

    }
    


    @Test
    fun test1() {
        val a1 = intArrayOf(-1,0,1,2,-1,-4)

        val result = threeSum(a1)

        assertThat(result).isEqualTo(listOf(listOf(-1,-1,2),listOf(-1,0,1)))
    }



}