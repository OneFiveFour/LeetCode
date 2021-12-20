package com.onefivefour.codekatas.backtracking

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
 */
class Subsets {


    fun subsets(nums: IntArray): List<List<Int>> {

        val subsets = ArrayList<List<Int>>()

        backtrack(nums, 0, ArrayList(), subsets)

        return subsets

    }


    private fun backtrack(nums: IntArray, index: Int, curSubset: ArrayList<Int>, subsets: ArrayList<List<Int>>) {

        if (index >= nums.size) {
            subsets.add(curSubset.toList())
            return
        }


        // include index-num in the subset
        curSubset.add(nums[index])
        backtrack(nums, index + 1, curSubset, subsets)

        // do not include index-num in the subset
        curSubset.remove(nums[index])
        backtrack(nums, index + 1, curSubset, subsets)

    }

    @Test
    fun test1() {
        val a1 = intArrayOf(1, 2, 3)

        val result = subsets(a1)

        assertThat(result).containsExactly(
            listOf<Int>(),
            listOf(1),
            listOf(2),
            listOf(1, 2),
            listOf(3),
            listOf(1, 3),
            listOf(2, 3),
            listOf(1, 2, 3)
        )

    }


}