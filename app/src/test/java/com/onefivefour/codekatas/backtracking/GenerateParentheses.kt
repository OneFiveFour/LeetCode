package com.onefivefour.codekatas.backtracking

import com.google.common.truth.Truth
import org.junit.Test

/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
class GenerateParentheses {



    fun generateParenthesis(n: Int): List<String?>? {
        val ans: MutableList<String?> = ArrayList()
        backtrack(ans, StringBuilder(), 0, 0, n)
        return ans
    }

    fun backtrack(ans: MutableList<String?>, cur: StringBuilder, open: Int, close: Int, max: Int) {
        if (cur.length == max * 2) {
            ans.add(cur.toString())
            return
        }
        if (open < max) {
            cur.append("(")
            backtrack(ans, cur, open + 1, close, max)
            cur.deleteCharAt(cur.length - 1)
        }
        if (close < open) {
            cur.append(")")
            backtrack(ans, cur, open, close + 1, max)
                cur.deleteCharAt(cur.length - 1)
        }
    }


    @Test
    fun test1() {
        val a1 = 1

        val result = generateParenthesis(a1)

        Truth.assertThat(result).containsExactly(
            "()"
        )

    }

    @Test
    fun test3() {
        val a1 = 3

        val result = generateParenthesis(a1)

        Truth.assertThat(result).containsExactly(
            "((()))", "(()())", "(())()", "()(())", "()()()"
        )

    }

    @Test
    fun test4() {
        val a1 = 4

        val result = generateParenthesis(a1)

        Truth.assertThat(result).containsExactly(
            "(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()",
            "(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"
        )

    }


}