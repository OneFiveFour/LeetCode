package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.
If this is impossible, return -1.
 */
class RottingOranges {

    private fun orangesRotting(grid: Array<IntArray>): Int {

        if (grid.isEmpty() || grid.first().isEmpty()) return -1

        var minutes = 0
        var isBasketEmpty = true

        val qR = ArrayDeque<Int>() // queue for row coords
        val qC = ArrayDeque<Int>() // queue for col coords 
        val qM = ArrayDeque<Int>() // queue for minutes

        // put all rotten oranges as starting points into the queue
        for (rowIndex in grid.indices) {

            val row = grid[rowIndex]

            for (colIndex in row.indices) {

                val currentField = grid[rowIndex][colIndex]

                // early exit if we find an island
                if (currentField == 1) {
                    if (isIsland(grid, rowIndex, colIndex)) {
                        return -1
                    }
                    isBasketEmpty = false
                }

                // no island -> BFS this orange
                if (currentField == 2) {
                    qR.add(rowIndex)
                    qC.add(colIndex)
                    qM.add(0)
                }

            }

        }

        if (qR.isEmpty() && isBasketEmpty) {
            return 0
        }

        val dirX = intArrayOf(0, 1, 0, -1)
        val dirY = intArrayOf(-1, 0, 1, 0)

        while (qR.isNotEmpty()) {

            val curRow = qR.removeFirst()
            val curCol = qC.removeFirst()
            val curMinute = qM.removeFirst()

            for (i in dirX.indices) {

                val newRow = curRow + dirX[i]
                val newCol = curCol + dirY[i]

                if (newRow < 0 || newCol < 0 || newRow > grid.lastIndex || newCol > grid.first().lastIndex) continue

                val newValue = grid[newRow][newCol]
                if (newValue == 0 || newValue == 2) continue

                if (newValue == 1) {

                    grid[newRow][newCol] = 2
                    qR.add(newRow)
                    qC.add(newCol)

                    val newMinute = curMinute + 1
                    qM.add(newMinute)

                    if (newMinute > minutes) {
                        minutes = newMinute
                    }
                }
            }
        }

        
        // check if there are still good oranges in the basket
        for (rowIndex in grid.indices) {
            val row = grid[rowIndex]
            for (colIndex in row.indices) {
                if (grid[rowIndex][colIndex] == 1) return -1
            }
        }

        return minutes
    }

    private fun isIsland(grid: Array<IntArray>, rowIndex: Int, colIndex: Int): Boolean {

        val top = if (rowIndex == 0) 0 else grid[rowIndex - 1][colIndex]
        val right = if (colIndex == grid[0].lastIndex) 0 else grid[rowIndex][colIndex + 1]
        val bottom = if (rowIndex == grid.lastIndex) 0 else grid[rowIndex + 1][colIndex]
        val left = if (colIndex == 0) 0 else grid[rowIndex][colIndex - 1]

        return top == 0 && right == 0 && bottom == 0 && left == 0
    }


    @Test
    fun test1() {
        val input = arrayOf(
            intArrayOf(2, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 1, 1)
        )

        val result = orangesRotting(input)

        assertThat(result).isEqualTo(4)
    }

    @Test
    fun test2() {
        val input = arrayOf(
            intArrayOf(2, 1, 1),
            intArrayOf(0, 1, 1),
            intArrayOf(1, 0, 1)
        )

        val result = orangesRotting(input)

        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun test3() {
        val input = arrayOf(intArrayOf(0, 2))

        val result = orangesRotting(input)

        assertThat(result).isEqualTo(0)
    }

    @Test
    fun test4() {
        val input = arrayOf(intArrayOf(1, 1, 1, 1))

        val result = orangesRotting(input)

        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun test5() {
        val input = arrayOf(intArrayOf(0))

        val result = orangesRotting(input)

        assertThat(result).isEqualTo(0)
    }


}