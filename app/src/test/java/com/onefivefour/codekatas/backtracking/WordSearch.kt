package com.onefivefour.codekatas.backtracking

import com.google.common.truth.Truth
import org.junit.Test

/**
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
class WordSearch {

    companion object {
        private const val USED = '_'
    }

    private val directions = listOf(
        -1 to 0,
        1 to 0,
        0 to 1,
        0 to -1
    )

    private lateinit var board: Array<CharArray>

    private lateinit var word: String

    private fun exist(board: Array<CharArray>, word: String): Boolean {

        this.board = board
        this.word = word

        for (rowIndex in board.indices) {

            for (colIndex in board[rowIndex].indices) {

                if (backtrack(0, rowIndex, colIndex)) {
                    return true
                }

            }

        }

        return false

    }

    private fun backtrack(index: Int, rI: Int, cI: Int): Boolean {

        if (!isValid(rI, cI)) {
            // indices are our of bounds
            return false
        }

        if (board[rI][cI] == USED) {
            // cell was already used
            return false
        }
        
        if (index == word.lastIndex && board[rI][cI] == word.last()) {
            // we found the word
            return true
        }

        if (board[rI][cI] != word[index]) {
            // wrong letter in the cell for the current index
            return false
        }

        // current cell has everything we need -> possible candidate
        // mark it as used
        board[rI][cI] = USED
        var found = false

        for (direction in directions) {

            val rowDirection = rI + direction.first
            val colDirection = cI + direction.second

            found = backtrack(index + 1, rowDirection, colDirection)

            if (found) break

        }

        board[rI][cI] = word[index]

        return found
    }


    private fun isValid(rowDirection: Int, colDirection: Int): Boolean {
        return rowDirection in board.indices && colDirection in board[0].indices
    }


    @Test
    fun test1() {
        val input1 = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E')
        )
        val input2 = "ABCCED"

        val result = exist(input1, input2)

        Truth.assertThat(result).isTrue()

    }

    @Test
    fun test2() {
        val input1 = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E')
        )
        val input2 = "ABCB"

        val result = exist(input1, input2)

        Truth.assertThat(result).isFalse()

    }

    @Test
    fun test3() {
        val input1 = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E')
        )
        val input2 = "SEE"

        val result = exist(input1, input2)

        Truth.assertThat(result).isTrue()

    }

    @Test
    fun test4() {
        val input1 = arrayOf(
            charArrayOf('a')
        )
        val input2 = "a"

        val result = exist(input1, input2)

        Truth.assertThat(result).isTrue()

    }


}