package com.onefivefour.codekatas.backtracking

import com.google.common.truth.Truth
import org.junit.Test

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
class LetterCombinationsOfAPhoneNumber {
    
    private val digitToLetters = mapOf(
        2 to "abc",
        3 to "def",
        4 to "ghi",
        5 to "jkl",
        6 to "mno",
        7 to "pqrs",
        8 to "tuv",
        9 to "xyz"
    )


    /**
     * Backtracking approach
     */
    private fun letterCombinations(digits: String): List<String> {

        if (digits.isEmpty()) return emptyList()

        val combinations = ArrayList<String>()
        val sb = StringBuilder()

        backtrack(digits, 0, sb, combinations)

        return combinations

    }

    private fun backtrack(digits: String, index: Int, sb: StringBuilder, combinations: ArrayList<String>) {

        if (sb.length == digits.length) {
            combinations.add(sb.toString())
            return
        }

        val letters = digitToLetters[digits[index] - '0'] ?: ""

        for (letter in letters) {
            sb.append(letter)
            backtrack(digits, index + 1, sb, combinations)
            sb.deleteCharAt(sb.lastIndex)
        }


    }



    /**
     * Non-Backtracking approach
     */
    private fun letterCombinations2(digits: String): List<String> {
        
        if (digits.isEmpty()) return emptyList()

        // split String into digits
        val digitList = digits.map{ it - '0' }

        var result = listOf("")

        for (digit in digitList) {
            
            val newElements = mutableListOf<String>()
            val letters = digitToLetters[digit] ?: continue
            
            for (letter in letters) {
                
                newElements.addAll(combine(result, letter))
                
                
            }
            
            result = newElements
            
        }


        return result
    }

    private fun combine(existingCombinations: List<String>, letterToAdd: Char): List<String> {
        return existingCombinations.map { "$it$letterToAdd" }
    }

    @Test
    fun test1() {
        val a1 = "23"

        val result = letterCombinations(a1)

        Truth.assertThat(result).containsExactly(
            "ad","ae","af","bd","be","bf","cd","ce","cf"
        )

    }
    
    
}