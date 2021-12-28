package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.util.*


/**
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
class KthLargestElementInAnArray {


    private fun findKthLargest2(nums: IntArray, k: Int): Int {
        nums.sortDescending()
        return nums[k - 1]
    }


    private fun findKthLargest(nums: IntArray, k: Int): Int {

        val priorityQueue = PriorityQueue<Int> { first, second ->
            second - first
        }

        for (num in nums) {
            priorityQueue.add(num)
        }
        
        for (i in 0 until k - 1) {
            print(priorityQueue.poll()!!)
        }

        return priorityQueue.poll()!!
    }


    @Test
    fun test1() {
        val nums = intArrayOf(6, 8, 5, 1, 2, 3)

        val result = findKthLargest(nums, 2)

        assertThat(result).isEqualTo(6)
    }


}