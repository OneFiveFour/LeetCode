package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.
 */
class TwoSum2 {


    private fun twoSum(numbers: IntArray, target: Int): IntArray {

        var left = 0
        var right = numbers.lastIndex

        while (left < right) {

            val currentSum = numbers[left] + numbers[right]

            when {
                currentSum == target -> return intArrayOf(left + 1, right + 1)
                currentSum < target -> left++
                else -> right--
            }
        }

        return intArrayOf()

    }


    @Test
    fun test1() {
        val a1 = intArrayOf(2, 7, 11, 15)

        val result = twoSum(a1, 9)

        assertThat(result).isEqualTo(intArrayOf(1, 2))
    }

    @Test
    fun test2() {
        val a1 = intArrayOf(2, 3, 4)

        val result = twoSum(a1, 6)

        assertThat(result).isEqualTo(intArrayOf(1, 3))
    }

    @Test
    fun test3() {
        val a1 = intArrayOf(-1, 0)

        val result = twoSum(a1, -1)

        assertThat(result).isEqualTo(intArrayOf(1, 2))
    }

    @Test
    fun test4() {
        val a1 = intArrayOf(
            12,
            13,
            23,
            28,
            43,
            44,
            59,
            60,
            61,
            68,
            70,
            86,
            88,
            92,
            124,
            125,
            136,
            168,
            173,
            173,
            180,
            199,
            212,
            221,
            227,
            230,
            277,
            282,
            306,
            314,
            316,
            321,
            325,
            328,
            336,
            337,
            363,
            365,
            368,
            370,
            370,
            371,
            375,
            384,
            387,
            394,
            400,
            404,
            414,
            422,
            422,
            427,
            430,
            435,
            457,
            493,
            506,
            527,
            531,
            538,
            541,
            546,
            568,
            583,
            585,
            587,
            650,
            652,
            677,
            691,
            730,
            737,
            740,
            751,
            755,
            764,
            778,
            783,
            785,
            789,
            794,
            803,
            809,
            815,
            847,
            858,
            863,
            863,
            874,
            887,
            896,
            916,
            920,
            926,
            927,
            930,
            933,
            957,
            981,
            997
        )

        val result = twoSum(a1, 542)

        assertThat(result).isEqualTo(intArrayOf(24, 32))
    }


}