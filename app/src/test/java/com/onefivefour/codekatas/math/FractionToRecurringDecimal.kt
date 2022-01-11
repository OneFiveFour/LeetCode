package com.onefivefour.codekatas.math

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
 */
class FractionToRecurringDecimal {

    private fun fractionToDecimal(numerator: Int, denominator: Int): String {

        if (numerator == 0) return "0"

        val sb = StringBuilder()

        if ((numerator < 0) xor (denominator < 0)) {
            sb.append("-")
        }


        val dividend = Math.abs(numerator.toLong())
        val divisor = Math.abs(denominator.toLong())

        sb.append((dividend/divisor).toString())

        var rest = dividend % divisor

        if (rest == 0L) {
            return sb.toString()
        }


        sb.append(".")

        val seen = HashMap<Long, Int>()

        while (rest > 0) {

            if(seen.contains(rest)) {
                sb.insert(seen[rest]!!, "(")
                sb.append(")")
                break
            }

            seen[rest] = sb.length
            rest *= 10
            sb.append((rest/divisor).toString())
            rest %= divisor


        }


        return sb.toString()

    }


    @Test
    fun test1() {
        val input1 = 1
        val input2 = 2

        val result = fractionToDecimal(input1, input2)

        assertThat(result).isEqualTo("0.5")
    }


    @Test
    fun test2() {
        val input1 = 4
        val input2 = 333

        val result = fractionToDecimal(input1, input2)

        assertThat(result).isEqualTo("0.(012)")
    }


    
}