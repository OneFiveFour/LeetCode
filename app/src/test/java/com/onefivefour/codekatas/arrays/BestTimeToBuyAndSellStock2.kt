package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve
 */
class BestTimeToBuyAndSellStock2 {


    @Test
    fun test1() {
        val prices = intArrayOf(7,1,5,3,6,4)
        val maxProfit = maxProfit(prices)
        assertThat(maxProfit).isEqualTo(7)
    }
    
    @Test
    fun test2() {
        val prices = intArrayOf(1,2,3,4,5)
        val maxProfit = maxProfit(prices)
        assertThat(maxProfit).isEqualTo(4)
    }
    
    @Test
    fun test3() {
        val prices = intArrayOf(7,6,4,3,1)
        val maxProfit = maxProfit(prices)
        assertThat(maxProfit).isEqualTo(0)
    }

    private fun maxProfit(prices: IntArray): Int {
        
        var profit = 0
        
        var boughtFor = 0
        
        var holding = false
        
        for (i in prices.indices) {
            
            val isLastDay = i == prices.size-1

            if (isLastDay) {
                if (holding) {
                    // sell on last day
                    profit += (prices[i] - boughtFor)
                }
                return profit
            }

            val isGoingDown = prices[i] > prices[i + 1]
            val isGoingUp = prices[i] < prices[i + 1]

            if (isGoingDown && holding) {
                // sell
                profit += (prices[i] - boughtFor)
                holding = false
            }
            
            if (isGoingUp && !holding) {
                // buy stock
                boughtFor = prices[i]
                holding = true
            }
            
        }
        
        return profit
    }
}