package com.onefivefour.codekatas.arrays

import org.junit.Test

import org.junit.Assert.*

/**
 * Given two arrays a and b write a function comp(a, b) (orcompSame(a, b)) that checks whether the two arrays have the "same" elements, with the same multiplicities. 
 * "Same" means, here, that the elements in b are the elements in a squared, regardless of the order.
 */
class AreTheyTheSame {


    private fun comp(a: IntArray?, b: IntArray?): Boolean {
        a ?: return false
        b ?: return false
        if (a.size != b.size) return false
        
        val squaredValues = a.map { it * it }.sorted()
        
        return squaredValues == b.sorted()
        
    }


    @Test
    fun testFixed1() {
        val a1 = intArrayOf(121,      161        )
        val a2 = intArrayOf(14641,  25921)

        assertEquals(true, comp(a1, a2))
    }

    @Test
    fun testFixed2() {
        val a1 = intArrayOf(121, 144, 19, 161, 19, 144, 19, 11)
        val a2 = intArrayOf(121, 14641, 20736, 361, 25921, 361, 20736, 361)

        assertEquals(true, comp(a1, a2))
    }

    
    @Test
    fun testRandom1() {
        val a1 = intArrayOf( 22,  30,  30,   32,   69,   80,   83)
        val a2 = intArrayOf(484, 900,      1024, 4761, 6400, 6889)

        assertEquals(false, comp(a1, a2))
    }

    
    @Test
    fun testRandom2() {
        val a1 = intArrayOf( 22,  30,  30,   32,   69,   80,   83)
        val a2 = intArrayOf(484, 900, 901, 1024, 4761, 6400, 6889)

        assertEquals(false, comp(a1, a2))
    }
    
}