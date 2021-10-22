package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 */
class ValidSudoku {


    private fun isValidSudoku2(board: Array<CharArray>): Boolean {

        val columns = Array(9) { CharArray(9) }

        val squares = Array(9) { Array(3) { CharArray(3) } }


        board.forEachIndexed rowLoop@{ rowIndex, column ->

            column.forEachIndexed colLoop@{ colIndex, fieldValue ->

                columns[colIndex][rowIndex] = fieldValue

                when {
                    (0..2).contains(rowIndex) -> {
                        when {
                            (0..2).contains(colIndex) -> squares[0][rowIndex % 3][colIndex % 3] = fieldValue
                            (3..5).contains(colIndex) -> squares[1][rowIndex % 3][colIndex % 3] = fieldValue
                            (6..8).contains(colIndex) -> squares[2][rowIndex % 3][colIndex % 3] = fieldValue
                        }
                    }
                    (3..5).contains(rowIndex) -> {
                        when {
                            (0..2).contains(colIndex) -> squares[3][rowIndex % 3][colIndex % 3] = fieldValue
                            (3..5).contains(colIndex) -> squares[4][rowIndex % 3][colIndex % 3] = fieldValue
                            (6..8).contains(colIndex) -> squares[5][rowIndex % 3][colIndex % 3] = fieldValue
                        }
                    }
                    (6..8).contains(rowIndex) -> {
                        when {
                            (0..2).contains(colIndex) -> squares[6][rowIndex % 3][colIndex % 3] = fieldValue
                            (3..5).contains(colIndex) -> squares[7][rowIndex % 3][colIndex % 3] = fieldValue
                            (6..8).contains(colIndex) -> squares[8][rowIndex % 3][colIndex % 3] = fieldValue
                        }
                    }
                }

            }

        }


        board.forEach rowLoop@{ row ->
            val rowValues = mutableListOf<Char>()
            row.forEach colLoop@{ char ->
                if (char == '.') return@colLoop
                if (rowValues.contains(char)) {
                    return false
                }
                rowValues.add(char)
            }
        }

        columns.forEach colLoop@{ column ->
            val colValues = mutableListOf<Char>()
            column.forEach rowLoop@{ char ->
                if (char == '.') return@rowLoop
                if (colValues.contains(char)) {
                    return false
                }
                colValues.add(char)
            }
        }

        for (square in squares) {
            val squareValues = mutableListOf<Char>()
            for (row in square) {
                for (char in row) {
                    if (char == '.') continue
                    if (squareValues.contains(char)) {
                        return false
                    }
                    squareValues.add(char)
                }
            }
        }


        return true

    }

    private fun isValidSudoku(board: Array<CharArray>): Boolean {
        val boardSize = board.size
        
        // we have 9 rows, 9 cols and 9 boxes
        val rows = IntArray(boardSize)
        val cols = IntArray(boardSize)
        val box = IntArray(boardSize)

        for (rowIndex in 0 until boardSize) {
            for (colIndex in 0 until boardSize) {
                
                val fieldValue = board[rowIndex][colIndex]
                
                val boxIndex = 3 * (rowIndex / 3) + (colIndex / 3)

                if (fieldValue == '.') continue
            
                val v = 1 shl (fieldValue - '0') // converts fieldValue into Int (see ascii table)
                
                // The 2D array is mapped to a 1D array holding integers
                // These integers are looked at in binary form
                // Each 1 of the 9 bits represents the second dimension
                // if there is already a 1 in one of the 3 IntArrays in the place where
                // a previous 1 was shifted to, we found a duplicate.
                if (rows[rowIndex] and v > 0) return false
                if (cols[colIndex] and v > 0) return false
                if (box[boxIndex] and v > 0) return false

                rows[rowIndex] = rows[rowIndex] or v
                cols[colIndex] = cols[colIndex] or v
                box[boxIndex] = box[boxIndex] or v
                
            }
        }
        
        return true
    }
    
    
    private fun isValidSudoku3(board: Array<CharArray>): Boolean {
        val seen = mutableSetOf<String>()
        for (i in board.indices) {
            
            for (j in board[0].indices) {
                
                // create strings that are unique to every of
                // the 3 types of checks
                val rowVal = "row#$i#${board[i][j]}"
                val colVal = "col#$j#${board[i][j]}"
                val blockVal = "block#${i/3}#${j/3}#${board[i][j]}"

                if (board[i][j] != '.') {
                    // if the unique string is already present in one of the sets -> false
                    if (!seen.add(rowVal) || !seen.add(colVal) || !seen.add(blockVal)) {
                        return false
                    }
                }
            }
        }
        return true
    }

    @Test
    fun test1() {
        val a1 = arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )

        val result = isValidSudoku(a1)

        assertThat(result).isEqualTo(true)
    }

    @Test
    fun test2() {
        val a1 = arrayOf(
            charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
        )

        val result = isValidSudoku(a1)

        assertThat(result).isEqualTo(false)
    }


}