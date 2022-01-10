package com.onefivefour.codekatas.math

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.
 */
class HappyNumber {

    private fun isHappy(n: Int): Boolean {

        if (n == 1) return true

        val seen = HashSet<Int>()
        
        var curNumber = n

        while (curNumber != 1 && !seen.contains(curNumber)) {

            seen.add(curNumber)

            curNumber = calculate(curNumber)

        }

        return curNumber == 1

    }


    private fun calculate(n: Int) : Int {

        var from = n
        var to = 0

        while (from > 0) {

            val curDigit = from % 10
            from /= 10
            to += curDigit * curDigit

        }

        return to

    }


    @Test
    fun test1() {
        val input = 19

        val result = isHappy(input)

        assertThat(result).isTrue()
    }

    @Test
    fun test2() {
        val input = 4

        val result = isHappy(input)

        assertThat(result).isFalse()
    }
    
}