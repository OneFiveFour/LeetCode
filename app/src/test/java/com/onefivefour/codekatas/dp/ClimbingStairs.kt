package com.onefivefour.codekatas.dp

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
class ClimbingStairs {


    /**
     * DP approach:
     * 
     * Don't calculate things that are already calculated.
     * Bottom-Up from 1 to n
     */
    fun climbStairs(n: Int): Int {
        
        var one = 1
        var two = 1
        
        for (i in 1 until n) {
           
            val temp = one
            one += two
            two = temp
            
            
        }
        
        return one
    }
    
    /**
     * recursive "brute force" approach.
     * Time O(2^n), because 2 options per decision tree level, n levels
     */
    fun climbStairs2(n: Int): Int {
        
        if (n < 0) return 0
        
        if (n == 0) return 1

        // recurse into "climb 1 step" and "climb 2 steps"
        return climbStairs(n-1) + climbStairs(n-2)

    }



    @Test
    fun test1() {
        val a1 = 2

        val result = climbStairs(a1)

        assertThat(result).isEqualTo(2)
    }

    @Test
    fun test2() {
        val a1 = 3

        val result = climbStairs(a1)

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun test3() {
        val a1 = 6

        val result = climbStairs(a1)

        assertThat(result).isEqualTo(13)
    }

} 