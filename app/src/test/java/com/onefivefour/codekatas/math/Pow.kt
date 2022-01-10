package com.onefivefour.codekatas.math

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
 */
class Pow {

    fun myPow(x: Double, n: Int): Double {

        if (n == 0) return 1.0

        val result = halfPower(x, n)

        return if (n < 0) (1 / result) else result

    }


    private fun halfPower(x: Double, n: Int) : Double {

        if (n == 0) return 1.0

        if (x == 0.0) return 0.0

        val result = halfPower(x, n/2)

        return if (n % 2 == 0){
            result * result
        } else {
            result * result * x
        }

    }


    @Test
    fun test1() {
        val input1 = 2.0
        val input2 = 10

        val result = myPow(input1, input2)

        assertThat(result).isEqualTo(1024)
    }


    
}