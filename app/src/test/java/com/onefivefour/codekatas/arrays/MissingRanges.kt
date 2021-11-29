package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
 *
You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are in the inclusive range.

A number x is considered missing if x is in the range [lower, upper] and x is not in nums.

Return the smallest sorted list of ranges that cover every missing number exactly. That is, no element of nums is in any of the ranges, and each missing number is in one of the ranges.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b

 */
class MissingRanges {


    private fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<String> {

        if (nums.isEmpty()) return listOf(formatRange(lower, upper))

        val result = mutableListOf<String>()

        var low = lower

        for (i in nums.indices) {

            val num = nums[i]

            if (i == 0 && num > low) {
                result.add(formatRange(low, num - 1))
            } else if (num > low + 1) {
                result.add(formatRange(low + 1, num - 1))
            }
            
            low = num
        }

        if (nums.last() < upper) {
            result.add(formatRange(nums.last() + 1, upper))
        }
        
        return result
    }

    private fun formatRange(lower: Int, upper: Int): String {
        if (lower == upper) return "$lower"
        return "$lower->$upper"
    }


    @Test
    fun test6() {
        val input1 = intArrayOf(-1)
        val input2 = -1
        val input3 = 0


        val result = findMissingRanges(input1, input2, input3)

        assertThat(result).isEqualTo(listOf("0"))
    }

    @Test
    fun test5() {
        val input1 = intArrayOf(-1)
        val input2 = -2
        val input3 = -1


        val result = findMissingRanges(input1, input2, input3)

        assertThat(result).isEqualTo(listOf("-2"))
    }

    @Test
    fun test1() {
        val input1 = intArrayOf(0, 1, 3, 50, 75)
        val input2 = 0
        val input3 = 99


        val result = findMissingRanges(input1, input2, input3)

        assertThat(result).isEqualTo(listOf("2", "4->49", "51->74", "76->99"))
    }

    @Test
    fun test2() {
        val input1 = intArrayOf()
        val input2 = 1
        val input3 = 1


        val result = findMissingRanges(input1, input2, input3)

        assertThat(result).isEqualTo(listOf("1"))
    }

    @Test
    fun test3() {
        val input1 = intArrayOf()
        val input2 = -3
        val input3 = -1


        val result = findMissingRanges(input1, input2, input3)

        assertThat(result).isEqualTo(listOf("-3->-1"))
    }

    @Test
    fun test4() {
        val input1 = intArrayOf(-1)
        val input2 = -1
        val input3 = -1


        val result = findMissingRanges(input1, input2, input3)

        assertThat(result).isEqualTo(emptyList<String>())
    }


}