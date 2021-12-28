package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */
class MergeIntervals {


    private fun merge(intervals: Array<IntArray>): Array<IntArray> {

        if (intervals.isEmpty()) return emptyArray()

        intervals.sortBy { it[0] }

        val result = ArrayList<IntArray>()

        for (interval in intervals) {

            if (result.isEmpty() || result.last()[1] < interval[0]) {
                result.add(interval)

            } else {
                result.last()[1] = Math.max(interval[1], result.last()[1])

            }

        }

        return result.toTypedArray()

    }


    @Test
    fun test1() {
        val nums = arrayOf(
            intArrayOf(1,3),
            intArrayOf(2,6),
            intArrayOf(8,10),
            intArrayOf(15,18),
        )
        
        val result = merge(nums)

        assertThat(result[0][0]).isEqualTo(1)
        assertThat(result[0][1]).isEqualTo(6)
    }

}