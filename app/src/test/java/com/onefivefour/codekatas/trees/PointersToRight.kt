package com.onefivefour.codekatas.trees

import com.google.common.truth.Truth
import org.junit.Test

/**
You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

Return the merged tree.

Note: The merging process must start from the root nodes of both trees.
 */
class PointersToRight {

    private fun connect(root: Node?): Node? {
        if (root == null) return null
        root.next = null
        
        return connect(root, root.left, root.right)
    }


    private fun connect(root: Node?, left: Node?, right: Node?): Node? {
        if (root == null) return null

        left?.next = right

        connect(left,  left?.left,  left?.right )
        connect(left,  left?.right, right?.left )
        connect(right, right?.left, right?.right)

        return root
    }


    @Test
    fun test1() {
        val input1 = Node(1)
        input1.left = Node(2).apply { left = Node(4); right = Node(5) }
        input1.right = Node(3).apply { left = Node(6); right = Node(7) }

        val result = connect(input1)
        
        println(result.toString())
        
        Truth.assertThat(result?.next).isEqualTo(null)
    }

    @Test
    fun test2() {
        val input1 = Node(0)

        val result = connect(input1)

        Truth.assertThat(result).isEqualTo(null)
    }


}