package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class NumberOfIslands {

    private val directions = listOf(
        1 to 0,
        -1 to 0,
        0 to 1,
        0 to -1
    )

    fun numIslands(grid: Array<CharArray>): Int {

        var numberOfIslands = 0

        for (rowIndex in grid.indices) {

            for (colIndex in grid[0].indices) {

                val curPoint = grid[rowIndex][colIndex]

                if (listOf('0', 'X').contains(curPoint)) {
                    continue
                }

                if (curPoint == '1') {
                    numberOfIslands++
                    fill(grid, rowIndex, colIndex)
                }
            }
        }

        return numberOfIslands
    }


    private fun fill(grid: Array<CharArray>, rowIndex: Int, colIndex: Int) {

        val stack = ArrayDeque<Pair<Int, Int>>()

        stack.add(rowIndex to colIndex)
        grid[rowIndex][colIndex] = 'X'

        while (stack.isNotEmpty()) {

            repeat(stack.size) {

                val curPoint = stack.removeFirst()
                val rI = curPoint.first
                val cI = curPoint.second

                for (direction in directions) {

                    val neighborRow = rI + direction.first
                    val neighborCol = cI + direction.second

                    if (isValidLand(grid, neighborRow, neighborCol)) {
                        grid[neighborRow][neighborCol] = 'X'
                        stack.add(neighborRow to neighborCol)
                    }

                }
            }
        }
    }


    private fun isValidLand(grid: Array<CharArray>, rowIndex: Int, colIndex: Int): Boolean {
        return rowIndex in grid.indices &&
                colIndex in grid[0].indices &&
                grid[rowIndex][colIndex] == '1'

    }


    @Test
    fun test1() {
        val input = arrayOf(
            charArrayOf('1', '1', '1', '1', '0'),
            charArrayOf('1', '1', '0', '1', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0')
        )

        val result = numIslands(input)
        
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun test2() {
        val input = arrayOf(
            charArrayOf('1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'),
            charArrayOf('0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'),
            charArrayOf('1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'),
            charArrayOf('1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),
            charArrayOf('1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),
            charArrayOf('1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'),
            charArrayOf('0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'),
            charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'),
            charArrayOf('1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'),
            charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),
            charArrayOf('0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'),
            charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),
            charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),
            charArrayOf('1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'),
            charArrayOf('1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'),
            charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'),
            charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'),
            charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),
            charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),
            charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1')
        )

        val result = numIslands(input)
        
        assertThat(result).isEqualTo(1)
    }
}