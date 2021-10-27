package com.onefivefour.codekatas.binarysearch

import com.google.common.truth.Truth
import org.junit.Test

/**
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.
 */
class BinarySearch {
    
    private var target = 0

    private fun search(nums: IntArray, target: Int): Int {
        this.target = target
        return binarySearch(nums, 0 .. nums.lastIndex)
    }
    
    private fun binarySearch(nums: IntArray, range: IntRange) : Int {
        
        // element not in list
        if (range.first > range.last) {
            return -1
        }
        
        // calculate new middle
        val size = range.last - range.first+1
        val middle = range.first + size / 2
        
        if (nums[middle] == target) return middle
        
        if (nums[middle] < target) return binarySearch(nums, middle+1 .. range.last)
        
        if (nums[middle] > target) return binarySearch(nums, range.first until middle)
        
        return -1          
        
    }


    @Test
    fun test1() {
        val input1 = intArrayOf(-1,0,3,5,9,12)
        val input2 = 9

        val result = search(input1, input2)

        Truth.assertThat(result).isEqualTo(4)
    }

    @Test
    fun test2() {
        val input1 = intArrayOf(-1,0,3,5,12)
        val input2 = 9

        val result = search(input1, input2)

        Truth.assertThat(result).isEqualTo(-1)
    }

    @Test
    fun test3() {
        val input1 = intArrayOf(-1,0,3,5,12)
        val input2 = 3

        val result = search(input1, input2)

        Truth.assertThat(result).isEqualTo(2)
    }

    @Test
    fun test4() {
        val input1 = intArrayOf(-10,-5,-1,0,3,5,12)
        val input2 = -5

        val result = search(input1, input2)

        Truth.assertThat(result).isEqualTo(1)
    }


}
