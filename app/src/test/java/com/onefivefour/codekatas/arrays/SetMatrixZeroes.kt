package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
 *
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
 * 
 * You must do it in place.
 */
class SetMatrixZeroes {


    private fun setZeroes(matrix: Array<IntArray>) {

        val rowIndices = hashSetOf<Int>()
        val colIndices = hashSetOf<Int>()
        
        for (rowIndex in matrix.indices) {
            for (colIndex in matrix[rowIndex].indices) {
                
                val value = matrix[rowIndex][colIndex]
                
                if (value == 0) {
                    rowIndices.add(rowIndex)
                    colIndices.add(colIndex)
                }
            }
        }
        
        for (rowIndex in matrix.indices) {
            for (colIndex in matrix[rowIndex].indices) {
                if (rowIndices.contains(rowIndex) || colIndices.contains(colIndex)) {
                    matrix[rowIndex][colIndex] = 0
                }
            }
        }

    }
    


    @Test
    fun test1() {
        val a1 = arrayOf(
            intArrayOf(1,1,1),
            intArrayOf(1,0,1),
            intArrayOf(1,1,1)
        )

        setZeroes(a1)

        assertThat(a1).isEqualTo(arrayOf(
            intArrayOf(1,0,1),
            intArrayOf(0,0,0),
            intArrayOf(1,0,1)
        ))
    }

    @Test
    fun test2() {
        val a1 = arrayOf(
            intArrayOf(0,1,2,0),
            intArrayOf(3,4,5,2),
            intArrayOf(1,3,1,5)
        )

        setZeroes(a1)

        assertThat(a1).isEqualTo(arrayOf(
            intArrayOf(0,0,0,0),
            intArrayOf(0,4,5,0),
            intArrayOf(0,3,1,0)
        ))
    }



}