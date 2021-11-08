package com.onefivefour.codekatas.bits

import com.google.common.truth.Truth.assertThat

import org.junit.Test

/**
Given an integer n, return true if it is a power of two. Otherwise, return false.
An integer n is a power of two, if there exists an integer x such that n == 2^x.
 */
class PowerOfTwo {

    // ////////////////////////
    // FIRST APPROACH
    // /////////////////
    fun isPowerOfTwo2(n: Int): Boolean {

        if (n < 1) return false

        var i = n
        while (true) {

            if (i % 2 == 1) {
                return i == 1
            } else if (i < 1) {
                return false
            }

            i = i shr 1
        }

    }

    // ////////////////////////
    // BEST APPROACH
    // /////////////////
    fun isPowerOfTwo(n: Int): Boolean {
        if (n < 1) return false
        return n and (n - 1) == 0
    }


    @Test
    fun test5() {
        val input = 0

        val result = isPowerOfTwo(input)

        assertThat(result).isFalse()
    }


    @Test
    fun test1() {
        val input = 1

        val result = isPowerOfTwo(input)

        assertThat(result).isTrue()
    }

    @Test
    fun test2() {
        val input = 2

        val result = isPowerOfTwo(input)

        assertThat(result).isTrue()
    }

    @Test
    fun test3() {
        val input = 13

        val result = isPowerOfTwo(input)

        assertThat(result).isFalse()
    }

    @Test
    fun test4() {
        val input = 16

        val result = isPowerOfTwo(input)

        assertThat(result).isTrue()
    }
}