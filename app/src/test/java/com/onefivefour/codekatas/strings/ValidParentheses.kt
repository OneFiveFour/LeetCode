package com.onefivefour.codekatas.strings

import com.google.common.truth.Truth
import org.junit.Test
import java.util.*

/**
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 */
class ValidParentheses {

    private fun isValid(s: String): Boolean {

        if (s.isEmpty()) return true
        if (s.length % 2 == 1) return false

        val expectedChar = Stack<Char>()

        for (char in s) {

            if (char == '(') expectedChar.push(')')
            if (char == '[') expectedChar.push(']')
            if (char == '{') expectedChar.push('}')

            if (expectedChar.isEmpty()) return false
            
            if (char == ')' && expectedChar.pop() != ')') return false
            if (char == ']' && expectedChar.pop() != ']') return false
            if (char == '}' && expectedChar.pop() != '}') return false

        }

        return expectedChar.isEmpty()

    }


    @Test
    fun test1() {
        val input = "()"

        val result = isValid(input)

        Truth.assertThat(result).isTrue()
    }

    @Test
    fun test2() {
        val input = "(()"

        val result = isValid(input)

        Truth.assertThat(result).isFalse()
    }

    @Test
    fun test3() {
        val input = "([)]"

        val result = isValid(input)

        Truth.assertThat(result).isFalse()
    }

    @Test
    fun test4() {
        val input = "()[]{}"

        val result = isValid(input)

        Truth.assertThat(result).isTrue()
    }

    @Test
    fun test5() {
        val input = ")}"

        val result = isValid(input)

        Truth.assertThat(result).isFalse()
    }


}