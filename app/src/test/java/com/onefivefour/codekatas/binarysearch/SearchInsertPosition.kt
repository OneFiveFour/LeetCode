package com.onefivefour.codekatas.binarysearch

import com.google.common.truth.Truth
import org.junit.Test

/**
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
 */
class SearchInsertPosition {

    private var target = -1

    private fun searchInsert(nums: IntArray, target: Int): Int {
        this.target = target

        if (nums.isEmpty()) return 0

        if (target < nums.first()) return 0

        if (target > nums.last()) return nums.size

        return binarySearch(nums, 0..nums.lastIndex)
    }

    private fun binarySearch(nums: IntArray, range: IntRange): Int {

        if (range.first > range.last) {
            return range.first
        }

        // calculate new middle
        val size = range.last - range.first
        val middle = range.first + size / 2

        val value = nums[middle]
        if (value == target) return middle

        if (target < value) {
            return binarySearch(nums, range.first until middle)
        }

        return binarySearch(nums, middle + 1..range.last)
        

    }


    @Test
    fun test1() {
        val input1 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
        val input2 = 5

        val result = searchInsert(input1, input2)

        Truth.assertThat(result).isEqualTo(4)
    }

    @Test
    fun test2() {
        val input1 = intArrayOf(0, 1, 2, 3, 4, 6, 7, 8)
        val input2 = 5

        val result = searchInsert(input1, input2)

        Truth.assertThat(result).isEqualTo(5)
    }

    @Test
    fun test3() {
        val input1 = intArrayOf(0, 1, 3, 4, 5, 6, 7, 8)
        val input2 = 2

        val result = searchInsert(input1, input2)

        Truth.assertThat(result).isEqualTo(2)
    }

    @Test
    fun test4() {
        val input1 = intArrayOf(0, 1, 3, 4, 5)
        val input2 = 7

        val result = searchInsert(input1, input2)

        Truth.assertThat(result).isEqualTo(5)
    }

}
