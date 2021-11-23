package com.onefivefour.codekatas.strings

import com.google.common.truth.Truth
import org.junit.Test

/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
 */
class ReverseInteger {

    private fun reverse(x: Int): Int {

        var result = 0

        var value = x

        while (value != 0) {

            val tail = value % 10
            val newResult = result * 10 + tail

            if ((newResult - tail) / 10 != result) {
                return 0
            }

            result = newResult
            value /= 10
        }

        return result

    }


    @Test
    fun test1() {
        val input = 123

        val result = reverse(input)

        Truth.assertThat(result).isEqualTo(321)
    }

    @Test
    fun test2() {
        val input = -123

        val result = reverse(input)

        Truth.assertThat(result).isEqualTo(-321)
    }

    @Test
    fun test3() {
        val input = -120

        val result = reverse(input)

        Truth.assertThat(result).isEqualTo(-21)
    }

    @Test
    fun test4() {
        val input = 0

        val result = reverse(input)

        Truth.assertThat(result).isEqualTo(0)
    }

    @Test
    fun test5() {
        val input = 964632499

        val result = reverse(input)

        Truth.assertThat(result).isEqualTo(0)
    }

}