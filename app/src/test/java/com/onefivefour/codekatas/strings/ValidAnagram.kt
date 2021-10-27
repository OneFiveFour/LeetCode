package com.onefivefour.codekatas.strings

import com.google.common.truth.Truth
import org.junit.Test

/**
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */
class ValidAnagram {

    private fun isAnagram(s: String, t: String): Boolean {

        if (s.length != t.length) return false
        
        val mapS = hashMapOf<Char, Int>()
        val mapT = hashMapOf<Char, Int>()
        
        for (i in s.indices) {
            mapS[s[i]] = mapS[s[i]]?.plus(1) ?: 1
            mapT[t[i]] = mapT[t[i]]?.plus(1) ?: 1
        }
        
        mapS.forEach { (char, count) -> 
            if (mapT[char] != count) {
                return false
            }
        }
        
        return true
    }


    @Test
    fun test1() {
        val input1 = "anagram"
        val input2 = "nagaram"

        val result = isAnagram(input1, input2)

        Truth.assertThat(result).isEqualTo(true)
    }

    @Test
    fun test2() {
        val input1 = "rat"
        val input2 = "car"

        val result = isAnagram(input1, input2)

        Truth.assertThat(result).isEqualTo(false)
    }



}
