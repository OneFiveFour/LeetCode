package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 */
class IntersectionOfTwoArrays {


    private fun intersect(nums1: IntArray, nums2: IntArray): IntArray {

        val result = mutableListOf<Int>()

        if (nums1.size < nums2.size) {

            val copy = nums2.toMutableList()
            nums1.forEach { num ->
                if (copy.remove(num)) {
                    result.add(num)
                }
            }

        } else {
            val copy = nums1.toMutableList()
            nums2.forEach { num ->
                if (copy.remove(num)) {
                    result.add(num)
                }
            }
        }

        return result.toIntArray()
    }


    @Test
    fun testFixed1() {
        val nums1 = intArrayOf(1, 2, 2, 1)
        val nums2 = intArrayOf(2, 2)

        val result = intersect(nums1, nums2)

        assertThat(result).isEqualTo(intArrayOf(2, 2))
    }

    @Test
    fun testFixed2() {
        val nums1 = intArrayOf(4, 9, 5)
        val nums2 = intArrayOf(9, 4, 9, 8, 4)

        val result = intersect(nums1, nums2)

        assertThat(result).isEqualTo(intArrayOf(4, 9))
    }

    @Test
    fun testFixed3() {
        val nums1 = intArrayOf(1, 2, 2, 1)
        val nums2 = intArrayOf(2)

        val result = intersect(nums1, nums2)

        assertThat(result).isEqualTo(intArrayOf(2))
    }

    @Test
    fun testFixed4() {
        val nums1 = intArrayOf(1, 2)
        val nums2 = intArrayOf(1, 1)

        val result = intersect(nums1, nums2)

        assertThat(result).isEqualTo(intArrayOf(1))
    }


}