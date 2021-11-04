package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill.
 */
class FloodFill {

    private fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        if (image[sr][sc] == newColor) return image
        val seedColor = image[sr][sc]
        fill(image, sr, sc, seedColor, newColor)
        return image
    }
    
    private fun fill(image: Array<IntArray>, sr: Int, sc: Int, seedColor: Int, newColor: Int) {
        if (sr < 0 || sc < 0 || sr > image.lastIndex || sc > image[0].lastIndex) return
        if (image[sr][sc] == newColor) return
        if (image[sr][sc] == seedColor) {
            image[sr][sc] = newColor
        } else {
            return
        }
        
        fill(image, sr+1, sc, seedColor, newColor)
        fill(image, sr-1, sc, seedColor, newColor)
        fill(image, sr, sc+1, seedColor, newColor)
        fill(image, sr, sc-1, seedColor, newColor)
        
    }
    


    private fun floodFillIterative(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        
        if (image[sr][sc] == newColor) return image

        val oldColor = image[sr][sc]

        val pixelsToFill = mutableListOf<Pair<Int, Int>>()
        pixelsToFill.add(sr to sc)

        while (pixelsToFill.isNotEmpty()) {
            
            val curPixel = pixelsToFill[0]
            image[curPixel.first][curPixel.second] = newColor
            
            pixelsToFill.remove(curPixel)
            
            // check left
            var row = Math.max(0, curPixel.first - 1)
            var col = curPixel.second
            if (image[row][col] == oldColor) pixelsToFill.add(row to col)
            
            // check right
            row = Math.min(image.lastIndex, curPixel.first + 1)
            if (image[row][col] == oldColor) pixelsToFill.add(row to col)
            
            // check top
            row = curPixel.first
            col = Math.max(0, curPixel.second - 1)
            if (image[row][col] == oldColor) pixelsToFill.add(row to col)
            
            // check bottom
            col = Math.min(image[0].lastIndex, curPixel.second + 1)
            if (image[row][col] == oldColor) pixelsToFill.add(row to col)
            
        }

        return image
    }


    @Test
    fun test1() {
        val image = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 1)
        )
        val sr = 1
        val sc = 1
        val newColor = 2

        val result = floodFill(image, sr, sc, newColor)

        assertThat(result).isEqualTo(
            arrayOf(
                intArrayOf(2, 2, 2),
                intArrayOf(2, 2, 0),
                intArrayOf(2, 0, 1)
            )
        )
    }

    @Test
    fun test2() {
        val image = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        val sr = 1
        val sc = 1
        val newColor = 2

        val result = floodFill(image, sr, sc, newColor)

        assertThat(result).isEqualTo(
            arrayOf(
                intArrayOf(2, 2, 2),
                intArrayOf(2, 2, 2),
                intArrayOf(2, 2, 2)
            )
        )
    }

    @Test
    fun test3() {
        val image = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        val sr = 1
        val sc = 1
        val newColor = 2

        val result = floodFill(image, sr, sc, newColor)

        assertThat(result).isEqualTo(
            arrayOf(
                intArrayOf(2, 2, 2),
                intArrayOf(2, 2, 2)
            )
        )
    }

    @Test
    fun test4() {
        val image = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0)
        )
        val sr = 1
        val sc = 1
        val newColor = 2

        val result = floodFill(image, sr, sc, newColor)

        assertThat(result).isEqualTo(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 2, 0)
            )
        )
    }

    @Test
    fun test5() {
        val image = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0)
        )
        val sr = 1
        val sc = 1
        val newColor = 1

        val result = floodFill(image, sr, sc, newColor)

        assertThat(result).isEqualTo(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0)
            )
        )
    }


}