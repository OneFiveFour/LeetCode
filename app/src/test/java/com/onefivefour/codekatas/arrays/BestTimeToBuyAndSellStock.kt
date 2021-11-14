package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
class BestTimeToBuyAndSellStock {


    fun maxProfit(prices: IntArray): Int {

        if (prices.size <= 1) return 0

        var left = 0
        var right = 1

        var maxProfit = 0

        while (right <= prices.lastIndex) {

            if (prices[left] > prices[right]) {
                left = right
                right++
            } else if (prices[left] <= prices[right]) {
                maxProfit = Math.max(prices[right] - prices[left], maxProfit)
                right++
            }


        }

        return maxProfit
    }


    /**
     * Brute force, O(n^2)
     */
    fun maxProfit2(prices: IntArray): Int {

        var maxProfit = 0

        for (i in prices.indices) {

            val boughtAt = prices[i]

            for (j in i + 1 until prices.size) {

                val profit = prices[j] - boughtAt

                if (profit > maxProfit) {
                    maxProfit = profit
                }

            }

        }


        return maxProfit
    }


    @Test
    fun test1() {
        val a1 = intArrayOf(7, 1, 5, 3, 6, 4)

        val result = maxProfit(a1)

        assertThat(result).isEqualTo(5)
    }

    @Test
    fun test2() {
        val a1 = intArrayOf(7, 6, 4, 3, 1)

        val result = maxProfit(a1)

        assertThat(result).isEqualTo(0)
    }

} 