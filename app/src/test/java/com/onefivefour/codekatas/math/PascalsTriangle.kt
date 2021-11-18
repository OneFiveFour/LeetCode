package com.onefivefour.codekatas.math

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

        1
      1
    1   4
  1   3
1   2   6
  1   3
    1   4
      1
        1
 */
class PascalsTriangle {

    fun generate(numRows: Int): List<List<Int>> {
        
        
        if (numRows == 2) return listOf(listOf(1), listOf(1,1))
        if (numRows == 1) return listOf(listOf(1))
        
        val result = generate(numRows - 1).toMutableList()
        
        val current = mutableListOf<Int>()
        current.add(1)

        val previousRow = result.last()
        for (i in 0 until previousRow.lastIndex) {
            
            val one = previousRow[i]
            val two = previousRow[i + 1]
            
            current.add(one + two)
            
        }
        
        current.add(1)
        result.add(current)
        
        return result
    }
    
    
    @Test
    fun test1() {
        val input = 1
        
        val result = generate(input)
        
        assertThat(result).isEqualTo(listOf(listOf(1)))        
    }
    
    
    @Test
    fun test2() {
        val input = 5
        
        val result = generate(input)
        
        assertThat(result).isEqualTo(listOf(listOf(1)))        
    }
    
    
}