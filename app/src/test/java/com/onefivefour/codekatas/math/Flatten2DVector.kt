package com.onefivefour.codekatas.math


/**
Design an iterator to flatten a 2D vector. It should support the next and hasNext operations.

Implement the Vector2D class:

Vector2D(int[][] vec) initializes the object with the 2D vector vec.
next() returns the next element from the 2D vector and moves the pointer one step forward. You may assume that all the calls to next are valid.
hasNext() returns true if there are still some elements in the vector, and false otherwise.
 */
class Flatten2DVector(private val vec: Array<IntArray>) {

    private var inner = 0
    private var outer = 0

    // If the current outer and inner point to an integer, this method does nothing.
    // Otherwise, inner and outer are advanced until they point to an integer.
    // If there are no more integers, then outer will be equal to vector.length
    // when this method terminates.
    private fun advanceToNext() {
        // While outer is still within the vector, but inner is over the
        // end of the inner list pointed to by outer, we want to move
        // forward to the start of the next inner vector.
        while (outer < vec.size && inner == vec[outer].size) {
            inner = 0
            outer++
        }
    }

    operator fun next(): Int {
        // As per Java specs, throw an exception if there's no next.
        // This will also ensure the pointers point to an integer otherwise.
        if (!hasNext()) throw NoSuchElementException()
        // Return current element and move inner so that is after the current
        // element.
        return vec[outer][inner++]
    }

    operator fun hasNext(): Boolean {
        // Ensure the position pointers are moved such they point to an integer,
        // or put outer = vector.length.
        advanceToNext()
        // If outer = vector.length then there are no integers left, otherwise
        // we've stopped at an integer and so there's an integer left.
        return outer < vec.size
    }
       
}