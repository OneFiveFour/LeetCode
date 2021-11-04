package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
 */
class Matrix01 {

    private fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {

        if (mat.isEmpty() || mat[0].isEmpty()) return mat
        
        val queue = ArrayDeque<Pair<Int, Int>>()
        
        for (rowIndex in mat.indices) {
            
            val row = mat[rowIndex]
            
            for (colIndex in row.indices) {
                
                if (row[colIndex] == 0) {
                    // it's a zero -> add to queue to update distances from here
                    queue.add(rowIndex to colIndex)
                } else {
                    // it's not a zero -> assume maximum distance for now
                    mat[rowIndex][colIndex] = Int.MAX_VALUE
                }
                
            }
        }

        val directions = arrayOf(
            intArrayOf(-1, 0), 
            intArrayOf(1, 0), 
            intArrayOf(0, -1), 
            intArrayOf(0, 1)
        )
        while (queue.isNotEmpty()) {
            
            val currentPoint = queue.removeFirst()
            
            for (dir in directions) {
                
                val curX = currentPoint.first + dir[0]
                val curY = currentPoint.second + dir[1]

                // sanity checks
                if (curX < 0 || curY < 0 || curX > mat.lastIndex || curY > mat[0].lastIndex) continue
                
                // we already found a shorter distance earlier
                if (mat[curX][curY] <= mat[currentPoint.first][currentPoint.second] + 1) continue
                
                // the current distance is smaller than the one currently set -> update the distance
                mat[curX][curY] = mat[currentPoint.first][currentPoint.second] + 1
                
                // add current point to queue to continue search from this point
                queue.add(curX to curY)
                
            }
            
            
        }
        
        
        return mat
    }
    
    

    @Test
    fun test1() {
        val image = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 0)
        )
       

        val result = updateMatrix(image)

        assertThat(result).isEqualTo(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(0, 0, 0)
            )
        )
    }


    @Test
    fun test2() {
        val image = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 1)
        )
       

        val result = updateMatrix(image)

        assertThat(result).isEqualTo(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(1, 2, 1)
            )
        )
    }


    @Test
    fun test3() {
        val image = arrayOf(
            intArrayOf(0, 0, 1, 0, 0),
            intArrayOf(0, 0, 1, 0, 0),
            intArrayOf(1, 1, 1, 1, 1),
            intArrayOf(0, 0, 1, 0, 0),
            intArrayOf(0, 0, 1, 0, 0)
        )
       

        val result = updateMatrix(image)

        assertThat(result).isEqualTo(
            arrayOf(
                intArrayOf(0, 0, 1, 0, 0),
                intArrayOf(0, 0, 1, 0, 0),
                intArrayOf(1, 1, 2, 1, 1),
                intArrayOf(0, 0, 1, 0, 0),
                intArrayOf(0, 0, 1, 0, 0)
            )
        )
    }



}