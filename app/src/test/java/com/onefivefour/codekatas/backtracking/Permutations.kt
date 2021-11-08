package com.onefivefour.codekatas.backtracking

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
Given an array nums of distinct integers, return all the possible permutations.
You can return the answer in any order.
 */
class Permutations {
    
    // //////////////////////////////
    // SOLUTION BY SWAPPING ELEMENTS
    // /////////////////////////////
    fun IntArray.swap(i: Int, j: Int) {
        val temp = get(i)
        this[i] = this[j]
        this[j] = temp
    }


    fun permute1(nums: IntArray): List<List<Int>> {

        val result = ArrayList<List<Int>>()

        permute2(nums, 0, result)

        return result

    }

    private fun permute2(nums: IntArray, i: Int, result: ArrayList<List<Int>>) {

        if (i == nums.size) {
            result.add(nums.toList())
            return
        }

        for (j in i until nums.size) {

            nums.swap(j,i)

            permute2(nums, i+1, result)

            nums.swap(j,i)
        }

    }

    // //////////////////////////////
    // SOLUTION BY BACKTRACKING
    // /////////////////////////////
    fun permute2(nums: IntArray): List<List<Int>>? {
        
        val result = ArrayList<List<Int>>()
        
        backtracking(result, ArrayList(), nums)
        
        return result
        
    }

    private fun backtracking(result: ArrayList<List<Int>>, currentPermutation: MutableList<Int>, nums: IntArray) {
        
        if (currentPermutation.size == nums.size) {
            result.add(ArrayList(currentPermutation))
            return
        }
        
        
        for (num in nums) {
            if (currentPermutation.contains(num)) continue
            
            currentPermutation.add(num)
            
            backtracking(result, currentPermutation, nums)
            
            currentPermutation.remove(num)
        }
    }


    @Test
    fun test1() {
        val a1 = intArrayOf(1, 2, 3)

        val result = permute1(a1)

        assertThat(result.size).isEqualTo(6)

    }

}