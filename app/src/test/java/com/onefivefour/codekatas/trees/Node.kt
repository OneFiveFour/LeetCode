package com.onefivefour.codekatas.trees


class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null

    override fun toString(): String {
        return super.toString()
//        return "${this.`val`}, ${this.next?.`val` ?: '#'}, ${left.toString()}, ${right.toString()}"
        
    }
}