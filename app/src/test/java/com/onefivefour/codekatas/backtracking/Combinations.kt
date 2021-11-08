package com.onefivefour.codekatas.backtracking

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.
 */
class Combinations {


    private fun combine(n: Int, k: Int): List<List<Int>> {
        
        if (n == 0) return arrayListOf(listOf())
        
        val result = ArrayList<List<Int>>()
        
        backtrack(result, 1, n, k, ArrayList())
        
        return result
        
    }

    
    private fun backtrack(result: ArrayList<List<Int>>, start: Int, n: Int, k: Int, currentCombination: ArrayList<Int>) {
        
        if (currentCombination.size == k) {
            val combination = ArrayList(currentCombination)
            result.add(combination)            
            return
        }
        
        for (i in start .. n) {
            currentCombination.add(i)
            backtrack(result, i+1, n, k, currentCombination)
            currentCombination.remove(i)
        }        
    }

    @Test
    fun test1() {
        val a1 = 4
        val a2 = 2

        val result = combine(a1, a2)

        assertThat(result[0]).isEqualTo(intArrayOf(1, 2))
                
    }

    @Test
    fun test2() {
        val a1 = 1
        val a2 = 1

        val result = combine(a1, a2)

        assertThat(result).isEqualTo(arrayOf(intArrayOf(1)))
    }


}