package com.onefivefour.codekatas.bits

import com.google.common.truth.Truth.assertThat

import org.junit.Test

/**
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.
 */
class HammingDistance {

    fun hammingDistance(x: Int, y: Int): Int {
        
        if (x == y) return 0
        
        var diff = x xor y
        
        var count = 0
        
        while (diff > 0) {
            if (diff % 2 == 1) {
                count++
            }
            diff = diff shr 1
        }
        
        return count
    }


    @Test
    fun test1() {
        val input1 = 1
        val input2 = 4

        val result = hammingDistance(input1, input2)

        assertThat(result).isEqualTo(2)
    }
    
    @Test
    fun test2() {
        val input1 = 3
        val input2 = 1

        val result = hammingDistance(input1, input2)

        assertThat(result).isEqualTo(1)
    }
    
}