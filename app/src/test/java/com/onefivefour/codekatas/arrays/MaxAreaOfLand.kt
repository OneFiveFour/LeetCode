package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.
 */
class MaxAreaOfLand {

    private fun maxAreaOfIsland(grid: Array<IntArray>): Int {

        var biggestIsland = 0

        for (y in grid.indices) {

            val row = grid[y]

            for (x in row.indices) {

                val pixel = grid[y][x]

                if (pixel == 0) continue

                if (pixel == 2) continue

                if (pixel == 1) {
                    val size = measure(grid, x, y)
                    if (size > biggestIsland) {
                        biggestIsland = size
                    }
                }
            }
        }

        return biggestIsland
    }

    private fun measure(image: Array<IntArray>, x: Int, y: Int): Int {
        return if (x < 0 || y < 0 || x > image[0].lastIndex  || y > image.lastIndex) {
            0
        } else if (image[y][x] == 0 || image[y][x] == 2) {
            0
        } else {
            image[y][x] = 2
            val top = measure(image, x, y - 1)
            val bottom = measure(image, x, y + 1)
            val left = measure(image, x - 1, y)
            val right = measure(image, x + 1, y)
            1 + top + bottom + left + right
        }

    }


    @Test
    fun test1() {
        val input = arrayOf(
            intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
            intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
            intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
        )

        val result = maxAreaOfIsland(input)

        assertThat(result).isEqualTo(6)
    }

    @Test
    fun test2() {
        val input = arrayOf(
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0)
        )

        val result = maxAreaOfIsland(input)

        assertThat(result).isEqualTo(0)
    }


}