package com.onefivefour.codekatas.bits

import com.google.common.truth.Truth.assertThat

import org.junit.Test

/**
Reverse bits of a given 32 bits unsigned integer.

Note:

Note that in some languages, such as Java, there is no unsigned integer type.
In this case, both input and output will be given as a signed integer type.
They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation.
Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 */
class ReverseBits {

    // you need treat n as an unsigned value
    fun reverseBits(n: Int): Int {

        var result = 0

        for (i in 0..31) {

            var bit = (n shr i) and 1
            bit = bit shl (31 - i)
            result = result or bit

        }
        
        return result

    }


    @Test
    fun test1() {
        val input1 = 0b00000010100101000001111010011100

        val result = reverseBits(input1)

        assertThat(result).isEqualTo(0b00111001011110000010100101000000)
    }


}