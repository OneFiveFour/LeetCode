package com.onefivefour.codekatas.trees

import com.google.common.truth.Truth
import org.junit.Test

/**
You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

Return the merged tree.

Note: The merging process must start from the root nodes of both trees.
 */
class MergeBinaryTree {

    private fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        if (root1 == null && root2 == null) return null

        val value1 = root1?.`val` ?: 0
        val value2 = root2?.`val` ?: 0

        return TreeNode(value1 + value2).apply {
            left = mergeTrees(root1?.left, root2?.left)
            right = mergeTrees(root1?.right, root2?.right)
        }
    }

    @Test
    fun test1() {
        val input1 = TreeNode(1)
        val input2 = TreeNode(1).apply { left = TreeNode(2) }

        val result = mergeTrees(input1, input2)

        Truth.assertThat(result?.`val`).isEqualTo(2)
        Truth.assertThat(result?.left?.`val`).isEqualTo(2)
    }

    @Test
    fun test2() {
        val input1 = TreeNode(1)
            .apply {
                left = TreeNode(3).apply { left = TreeNode(5) }
                right = TreeNode(2)
            }
        val input2 = TreeNode(2).apply {
            left = TreeNode(1).apply { right = TreeNode(4) }
            right = TreeNode(3).apply { right = TreeNode(7) }
        }

        val result = mergeTrees(input1, input2)

        Truth.assertThat(result).isEqualTo(
            TreeNode(3).apply {
                left = TreeNode(4).apply { left = TreeNode(5); right = TreeNode(4) }
                right = TreeNode(5).apply { right = TreeNode(7) }
            }

        )
    }

}