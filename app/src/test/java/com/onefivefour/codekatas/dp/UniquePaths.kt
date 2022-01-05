package com.onefivefour.codekatas.dp

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */
class UniquePaths {


    fun uniquePaths(m: Int, n: Int): Int {
        
        val matrix = Array(m) { IntArray(n) { 0 } }
        
        matrix[0][0] = 1
        
        for (r in matrix.indices) {
            
            for (c in matrix[0].indices) {
                
                if (r == 0 && c == 0) continue 
                
                val upValue = if (r == 0) 0 else (matrix[r-1][c])
                val leftValue = if (c == 0) 0 else (matrix[r][c-1])
                matrix[r][c] = upValue + leftValue
                
            }
            
        }
        
        return matrix[m-1][n-1]
        
    }

    private fun countPaths2(m: Int, n: Int, curM: Int, curN: Int): Int {
        
        if (curM > m || curN > n) {
            return 0
        }
        
        if (curM == m && curN == n) {
            return 1
        }

        return countPaths2(m, n, curM + 1, curN) + countPaths2(m, n, curM, curN + 1)


    }

    @Test
    fun test1() {
        val input1 = 3
        val input2 = 7


        val result = uniquePaths(input1, input2)

        assertThat(result).isEqualTo(28)
    }


    @Test
    fun test2() {
        val input1 = 3
        val input2 = 2


        val result = uniquePaths(input1, input2)

        assertThat(result).isEqualTo(3)
    }


    @Test
    fun test3() {
        val input1 = 19
        val input2 = 13


        val result = uniquePaths(input1, input2)

        assertThat(result).isEqualTo(86493225)
    }


} 