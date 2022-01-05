package com.onefivefour.codekatas.dp

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
 */
class CoinChange {

    fun coinChange(coins: IntArray, amount: Int): Int {

        if (amount == 0) return 0

        if (coins.isEmpty()) return -1

        val dp = IntArray(amount + 1) { amount + 1 }

        dp[0] = 0

        for (i in 1..amount) {

            for (coin in coins) {

                if (coin > i) continue

                dp[i] = Math.min(1 + dp[i - coin], dp[i])

            }


        }

        return if (dp.last() == amount + 1) -1 else dp.last()

    }

    @Test
    fun test1() {
        val input1 = intArrayOf(1, 2, 5)
        val input2 = 9


        val result = coinChange(input1, input2)

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun test4() {
        val input1 = intArrayOf(1, 2, 5)
        val input2 = 100


        val result = coinChange(input1, input2)

        assertThat(result).isEqualTo(20)
    }


    @Test
    fun test2() {
        val input1 = intArrayOf(3)
        val input2 = 2


        val result = coinChange(input1, input2)

        assertThat(result).isEqualTo(-1)
    }


    @Test
    fun test3() {
        val input1 = intArrayOf(1)
        val input2 = 0


        val result = coinChange(input1, input2)

        assertThat(result).isEqualTo(0)
    }


} 