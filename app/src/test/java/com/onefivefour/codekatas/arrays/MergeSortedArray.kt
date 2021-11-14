package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
class MergeSortedArray {


    /**
     * O(m + n) time
     */
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {

        if (nums2.isEmpty()) return

        var p1 = m - 1 // pointer to highest value of nums1
        var p2 = n - 1 // pointer to highest value of nums2
        var curPos = nums1.lastIndex // pointer to current sort field

        while (curPos >= 0) {

            if (p2 < 0) return // nothing left to merge

            if (p1 < 0) {
                nums1[curPos] = nums2[p2]
                p2--
            } else if (nums1[p1] >= nums2[p2]) {
                // num1 value is greater or equal
                nums1[curPos] = nums1[p1]
                nums1[p1] = 0
                p1--
            } else {
                // nums2 value is greater
                nums1[curPos] = nums2[p2]
                p2--
            }

            curPos--

        }


    }


    /**
     * Time O(2(m+n))
     * Space O(2(m+n))
     */
    private fun merge2(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {

        if (nums2.isEmpty()) return

        val result = IntArray(m + n)

        var p1 = 0
        var p2 = 0
        var r = 0

        while (r < result.size) {

            if (p1 >= m) {
                result[r] = nums2[p2]
                p2++
            } else if (p2 > nums2.lastIndex) {
                result[r] = nums1[p1]
                p1++
            } else if (nums2[p2] < nums1[p1]) {
                result[r] = nums2[p2]
                p2++
            } else {
                result[r] = nums1[p1]
                p1++
            }

            r++
        }

        r = 0
        while (r < result.size) {
            nums1[r] = result[r]
            r++
        }

    }


    @Test
    fun test1() {
        val input1 = intArrayOf(1, 2, 3, 0, 0, 0)
        val input2 = intArrayOf(2, 5, 6)

        merge(input1, 3, input2, 3)

        assertThat(input1).isEqualTo(intArrayOf(1, 2, 2, 3, 5, 6))
    }


    @Test
    fun test2() {
        val input1 = intArrayOf(1)
        val input2 = intArrayOf()

        merge(input1, 1, input2, 0)

        assertThat(input1).isEqualTo(intArrayOf(1))
    }

    @Test
    fun test3() {
        val input1 = intArrayOf(0)
        val input2 = intArrayOf(1)

        merge(input1, 0, input2, 1)

        assertThat(input1).isEqualTo(intArrayOf(1))
    }


    @Test
    fun test4() {
        val input1 = intArrayOf(2, 0)
        val input2 = intArrayOf(1)

        merge(input1, 1, input2, 1)

        assertThat(input1).isEqualTo(intArrayOf(1, 2))
    }

    @Test
    fun test5() {
        val input1 = intArrayOf(-1, 0, 0, 3, 3, 3, 0, 0, 0)
        val input2 = intArrayOf(1, 2, 2)

        merge(input1, 6, input2, 3)

        assertThat(input1).isEqualTo(intArrayOf(-1, 0, 0, 1, 2, 2, 3, 3, 3))
    }

    @Test
    fun test6() {
        val input1 = intArrayOf(4, 5, 6, 0, 0, 0)
        val input2 = intArrayOf(1, 2, 3)

        merge(input1, 3, input2, 3)

        assertThat(input1).isEqualTo(intArrayOf(1, 2, 3, 4, 5, 6))
    }


}