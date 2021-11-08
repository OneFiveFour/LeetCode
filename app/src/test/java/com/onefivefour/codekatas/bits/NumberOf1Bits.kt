package com.onefivefour.codekatas.bits

import com.google.common.truth.Truth.assertThat

import org.junit.Test

/**
Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Note:

Note that in some languages, such as Java, there is no unsigned integer type.
In this case, the input will be given as a signed integer type.
It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation.
Therefore, in Example 3, the input represents the signed integer. -3.
 */
class NumberOf1Bits {

    // ////////////////////////
    // BEST APPROACH
    // //////////////////////
    fun hammingWeight(n: Int): Int {
        var ret = 0
        var n1 = n
        while(n1 != 0){
            ret++
            n1 = n1 and (n1-1)
        }
        return ret
    }
    
    
    // ////////////////////////
    // FIRST APPROACH
    // //////////////////////
    fun hammingWeight2(n: Int): Int {
        var count = 0
        for (i in 0..31) {
            if ((n shr i) and 1 == 1) {
                ++count
            }
        }
        return count
    }


    @Test
    fun test1() {
        val input = 0b00000000000000000000000000001011

        val result = hammingWeight(input)

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun test2() {
        val input = 0b00000000000000000000000010000000

        val result = hammingWeight(input)

        assertThat(result).isEqualTo(1)
    }


}