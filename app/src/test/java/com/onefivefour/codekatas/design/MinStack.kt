package com.onefivefour.codekatas.design

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * Implement the MinStack class:
 * 
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * 
**/
class MinStack() {
    
    private val stack = mutableListOf<Int>()

    fun push(`val`: Int) {
        stack.add(`val`)
    }

    fun pop() {
        stack.removeAt(0)
    }

    fun top(): Int {
        return stack[0]
    }

    fun getMin(): Int {

        var minValue = Int.MAX_VALUE
        
        for (num in stack) {
            if (num < minValue) {
                minValue = num
            }
        }
        
        return minValue
        
    }

}