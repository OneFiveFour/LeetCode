package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
 */
class SearchInRotatedSortedArray {


    private fun search(nums: IntArray, target: Int): Int {

        return find(nums, target, 0, nums.lastIndex)

    }


    private fun find(nums: IntArray, target: Int, left: Int, right: Int): Int {

        if (left > right) return -1

        if (nums[left] == target) return left

        if (nums[right] == target) return right

        val mid = (left + right) / 2

        if (nums[mid] == target) return mid

        val isBreakRight = nums[left] < nums[mid]

        return if (isBreakRight) {

            if (target > nums[left] && target < nums[mid]) {

                // target is left
                find(nums, target, left, mid - 1)

            } else {

                // target is right
                find(nums, target, mid + 1, right)
            }

        } else {

            if (target > nums[mid] && target < nums[right]) {

                // target is right
                find(nums, target, mid + 1, right)

            } else {

                // target is left
                find(nums, target, left, mid - 1)
            }


        }

    }


    @Test
    fun test1() {
        val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)

        val result = search(nums, 0)

        assertThat(result).isEqualTo(4)
    }


    @Test
    fun test2() {
        val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)

        val result = search(nums, 5)

        assertThat(result).isEqualTo(1)
    }


}