package com.onefivefour.codekatas.arrays

import org.junit.Test

/**
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */
class RemoveDuplicates {


    @Test
    fun test() {
        val nums = intArrayOf(1,1,2)
        val expectedNums = intArrayOf(1,2)

        val k = removeDuplicates(nums)

        assert(k == expectedNums.size)

        for (i in 0 until k) {
            assert(nums[i] == expectedNums[i])
        }
    }

    private fun removeDuplicates(nums: IntArray): Int {

        if (nums.isEmpty()) return 0

        // the next index to be used for the next increasing number
        var nextIndexToUse = 1

        // current number to check for equality
        var currentValue = nums.first()

        nums.forEach { num ->
            if (num > currentValue) {
                nums[nextIndexToUse] = num
                nextIndexToUse++
                currentValue = num
            }
        }
        return nextIndexToUse
    }
}