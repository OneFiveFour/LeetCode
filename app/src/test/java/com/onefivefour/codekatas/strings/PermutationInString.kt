package com.onefivefour.codekatas.strings

import com.google.common.truth.Truth
import org.junit.Test

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 */
class PermutationInString {

    private fun checkInclusion(s1: String, s2: String): Boolean {

        if (s2.length < s1.length) return false

        val s1Hash = IntArray(26)
        val windowHash = IntArray(26)
        
        var right = 0 
        var left = 0
        
        while (right < s1.length) {
            s1Hash[s1[right] - 'a'] += 1
            windowHash[s2[right] - 'a'] += 1
            right++
        }
        
        right--
        
        while (right < s2.length) {
            if (isEqual(s1Hash, windowHash)) return true
            right++
            if (right > s2.lastIndex) return false
            windowHash[s2[right] - 'a'] += 1
            windowHash[s2[left] - 'a'] -= 1
            left++
        }
        
        return false
    }
    
    
    private fun isEqual(s1Hash: IntArray, windowHash: IntArray): Boolean {
        for (i in s1Hash.indices) {
            if (s1Hash[i] != windowHash[i]) return false
        }
        return true
    }

    @Test
    fun test1() {
        val input1 = "ab"
        val input2 = "eidbaooo"

        val result = checkInclusion(input1, input2)

        Truth.assertThat(result).isEqualTo(true)
    }

    @Test
    fun test2() {
        val input1 = "ab"
        val input2 = "eidboaoo"

        val result = checkInclusion(input1, input2)

        Truth.assertThat(result).isEqualTo(false)
    }

    @Test
    fun test3() {
        val input1 = "adc"
        val input2 = "dcda"

        val result = checkInclusion(input1, input2)

        Truth.assertThat(result).isEqualTo(true)
    }


}
