package com.onefivefour.codekatas.strings

import com.google.common.truth.Truth
import org.junit.Test

/**
 * Given a string s, find the first non-repeating character in it and return its index.
 * If it does not exist, return -1.
 */
class FirstUniqueCharacter {

    private fun firstUniqChar(s: String): Int {

        val map = HashMap<Char, Int>()

        for (char in s) {
            map[char] = map[char]?.plus(1) ?: 1
        }
        
        for (i in s.indices) {
            if (map[s[i]] == 1) return i
        }
        
        return -1

    }


    @Test
    fun test1() {
        val input = "leetcode"

        val result = firstUniqChar(input)

        Truth.assertThat(result).isEqualTo(0)
    }

    @Test
    fun test2() {
        val input = "loveleetcode"

        val result = firstUniqChar(input)

        Truth.assertThat(result).isEqualTo(2)
    }

    @Test
    fun test3() {
        val input = "aabb"

        val result = firstUniqChar(input)

        Truth.assertThat(result).isEqualTo(-1)
    }


}
