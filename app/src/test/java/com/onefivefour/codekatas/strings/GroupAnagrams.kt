package com.onefivefour.codekatas.strings

import com.google.common.truth.Truth
import org.junit.Test

/**
 * Given an array of strings strs, group the anagrams together. 
 * You can return the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
 * typically using all the original letters exactly once.
 */
class GroupAnagrams {
    
    private fun groupAnagrams(strs: Array<String>): List<List<String>> {

        val map = HashMap<String, List<String>>()

        for (str in strs) {

            val temp = str
            val hash = str.toCharArray().sorted().joinToString("")

            map[hash] = (map[hash] ?: emptyList()) + temp

        }

        return map.values.toList()
    }


    @Test
    fun test1() {
        val input1 = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")

        val result = groupAnagrams(input1)

        Truth.assertThat(result).isEqualTo(
            listOf(
                listOf("bat"),
                listOf("nat", "tan"),
                listOf("ate", "eat", "tea")
            )
        )
    }

    @Test
    fun test2() {
        val input1 = arrayOf("ddddddddddg","dgggggggggg")

        val result = groupAnagrams(input1)

        Truth.assertThat(result).isEqualTo(
            listOf(
                listOf("dgggggggggg"),
                listOf("ddddddddddg")
            )
        )
    }


}
