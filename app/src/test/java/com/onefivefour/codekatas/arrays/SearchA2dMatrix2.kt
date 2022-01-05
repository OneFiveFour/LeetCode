package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
 */
class SearchA2dMatrix2 {


    private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

        if (matrix.size == 1 && matrix[0].size == 1) return matrix[0][0] == target

        val smallerEdge = Math.min(matrix.lastIndex, matrix[0].lastIndex)

        for (i in 0 .. smallerEdge) {

            if (find(matrix[i], target)) {
                return true
            }

            if (find(matrix.map { it[i] }.toIntArray(), target)) {
                return true
            }

        }

        return false
    }


    private fun find(nums: IntArray, target: Int) : Boolean {
        
        if (nums.isEmpty()) return false

        val mid = nums.lastIndex / 2

        if (nums[mid] == target) return true
        
        if (nums.size == 1) return false

        if (nums[mid] > target)  {
            val section = nums.copyOfRange(0, mid)
            return find(section, target)
        }

        if (nums[mid] < target) {
            val section = nums.copyOfRange(mid + 1, nums.size)
            return find(section, target)
        }

        return false
    }



    @Test
    fun test1() {
        val matrix = arrayOf(
            intArrayOf(1,4,7,11,15),
            intArrayOf(2,5,8,12,19),
            intArrayOf(3,6,9,16,22),
            intArrayOf(10,13,14,17,24),
            intArrayOf(18,21,23,26,30)
        )
        val target = 5

        val result = searchMatrix(matrix, target)

        assertThat(result).isTrue()
    }


    @Test
    fun test2() {
        val matrix = arrayOf(
            intArrayOf(1,4,7,11,15),
            intArrayOf(2,5,8,12,19),
            intArrayOf(3,6,9,16,22),
            intArrayOf(10,13,14,17,24),
            intArrayOf(18,21,23,26,30)
        )
        val target = 20

        val result = searchMatrix(matrix, target)

        assertThat(result).isFalse()
    }


    @Test
    fun test3() {
        val matrix = arrayOf(
            intArrayOf(-1,3)
        )
        val target = 3

        val result = searchMatrix(matrix, target)

        assertThat(result).isTrue()
    }


    @Test
    fun test4() {
        val matrix = arrayOf(
            intArrayOf(-1,3)
        )
        val target = 5

        val result = searchMatrix(matrix, target)

        assertThat(result).isFalse()
    }


    @Test
    fun test5() {
        val matrix = arrayOf(
            intArrayOf(-1),
            intArrayOf(5)
        )
        val target = 5

        val result = searchMatrix(matrix, target)

        assertThat(result).isTrue()
    }


    @Test
    fun test6() {
        val matrix = arrayOf(
            intArrayOf(-1),
            intArrayOf(5)
        )
        val target = 6

        val result = searchMatrix(matrix, target)

        assertThat(result).isFalse()
    }


}