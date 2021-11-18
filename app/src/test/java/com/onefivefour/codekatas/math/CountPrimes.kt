package com.onefivefour.codekatas.math

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 */
class CountPrimes {

    /**
     * Sieve of Eratosthenes
     */
    fun countPrimes(n: Int): Int {
        
        if (n < 3) return 0
        
        val seen = BooleanArray(n)
        
        var count = 0
        
        for (num in 2 until n) {
            if (seen[num]) continue
            
            count++
            
            for (notPrime in num until n step num) {
                seen[notPrime] = true
            }
            
        }
        
        return count
    }
    
    
    @Test
    fun test1() {
        val input = 20
        
        val result = countPrimes(input)
        
        assertThat(result).isEqualTo(8)        
    }
    
    
    @Test
    fun test2() {
        val input = 10
        
        val result = countPrimes(input)
        
        assertThat(result).isEqualTo(4)
    }
    
    
    @Test
    fun test3() {
        val input = 1
        
        val result = countPrimes(input)
        
        assertThat(result).isEqualTo(0)
    }
    
    
    @Test
    fun test4() {
        val input = 0
        
        val result = countPrimes(input)
        
        assertThat(result).isEqualTo(0)
    }


    @Test
    fun test5() {
        val input = 2

        val result = countPrimes(input)

        assertThat(result).isEqualTo(0)
    }


    @Test
    fun test6() {
        val input = 499979

        val result = countPrimes(input)

        assertThat(result).isEqualTo(41537)
    }
    
}