package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 */
class RotateImage {


    private fun rotate(matrix: Array<IntArray>) {
        
        var left = 0
        var right = matrix.lastIndex
        
        while (left < right) {
            
            for (i in 0 until (right-left)) {
                
                val top = left
                val bottom = right

                val temp = matrix[top][left + i]

                matrix[top][left + i] = matrix[bottom - i][left]

                matrix[bottom - i][left] = matrix[bottom][right - i]

                matrix[bottom][right - i] = matrix[top + i][right]

                matrix[top + i][right] = temp
            }
            
            left += 1
            right -= 1
            
        }
        
        
        
    }


    @Test
    fun test1() {
        val input = arrayOf(
            intArrayOf(0)
        )

        rotate(input)

        assertThat(input).isEqualTo(arrayOf(intArrayOf(0)))
    }
    
    
    @Test
    fun test2() {
        val input = arrayOf(
            intArrayOf(1,2),
            intArrayOf(3,4)
        )

        rotate(input)

        assertThat(input).isEqualTo(
            arrayOf(
                intArrayOf(3,1),
                intArrayOf(4,2)
            )
        )
    }
    
    
    @Test
    fun test3() {
        val input = arrayOf(
            intArrayOf(1,2,3),
            intArrayOf(4,5,6),
            intArrayOf(7,8,9)
        )

        rotate(input)

        assertThat(input).isEqualTo(
            arrayOf(
                intArrayOf(7,4,1),
                intArrayOf(8,5,2),
                intArrayOf(9,6,3)
            )
        )
    }
    
    @Test
    fun test4() {
        val input = arrayOf(
            intArrayOf(1,  2, 3, 4),
            intArrayOf(5,  6, 7, 8),
            intArrayOf(9 ,10,11,12),
            intArrayOf(13,14,15,16)
        )

        rotate(input)

        assertThat(input).isEqualTo(
            arrayOf(
                intArrayOf(13, 9, 5, 1),
                intArrayOf(14,10, 6, 2),
                intArrayOf(15,11, 7, 3),
                intArrayOf(16,12, 8, 4)
            )
        )
    }

}