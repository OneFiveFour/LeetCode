package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


/**
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */
class TopKFrequentElements {


    private fun topKFrequent2(nums: IntArray, k: Int): IntArray {

        val count = HashMap<Int, Int>()

        var maxFreq = Int.MIN_VALUE

        for (num in nums) {
            count[num] = count.getOrDefault(num, 0) + 1
            maxFreq = Math.max(maxFreq, count[num]!!)
        }


        val freq = HashMap<Int, ArrayList<Int>>()

        for ((key, value) in count) {
            freq[value] = freq.getOrDefault(value, ArrayList()).apply {
                add(key)
            }
        }
        
        val result = ArrayList<Int>()
        var found = 0

        while (found < k) {

            val elements = freq[maxFreq]?.take(k)

            if (elements != null && elements.isNotEmpty()) {
                result.addAll(elements)
                found += elements.size
            }

            maxFreq--
        }

        return result.toIntArray()


    }


    private fun topKFrequent(nums: IntArray, k: Int): IntArray {

        nums.sortDescending()

        val countMap = mutableMapOf<Int, Int>()
        nums.forEach { number ->
            countMap[number] = (countMap[number] ?: 0) + 1
        }
        val maxHeap = PriorityQueue<Int> { first, second ->
            countMap[first]!! - countMap[second]!!
        }
        countMap.forEach { (number, count) ->
            if (maxHeap.size < k) {
                maxHeap.add(number)
            } else if (count > countMap[maxHeap.peek()!!]!!) {
                maxHeap.poll()
                maxHeap.add(number)
            }
        }
        return maxHeap.toIntArray()


    }


    @Test
    fun test1() {
        val nums = intArrayOf(2, 0, 2, 1, 1, 0)

        val result = topKFrequent(nums, 2)

        assertThat(result).isEqualTo(intArrayOf(0, 1))
    }


}