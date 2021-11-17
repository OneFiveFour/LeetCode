package com.onefivefour.codekatas.design

import kotlin.random.Random


/**
 * Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.
 * Implement the Solution class:
 * Solution(int[] nums) Initializes the object with the integer array nums.
 * int[] reset() Resets the array to its original configuration and returns it.
 * int[] shuffle() Returns a random shuffling of the array.
**/
class Solution(private val nums: IntArray) {
    
    

    fun reset(): IntArray {
        return nums
    }

    fun shuffle(): IntArray {
        
        val result = nums.copyOf()
        
        for (i in result.indices) {
            
            val randomIndex = i + Random.nextInt(result.lastIndex - i)
            val temp = result[i]
            result[i] = result[randomIndex]
            result[randomIndex] = temp            
            
        }
        
        return result
        
    }

}