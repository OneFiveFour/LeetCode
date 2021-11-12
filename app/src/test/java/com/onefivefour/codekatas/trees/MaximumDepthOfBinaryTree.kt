package com.onefivefour.codekatas.trees

import com.google.common.truth.Truth
import org.junit.Test

/**
You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

Return the merged tree.

Note: The merging process must start from the root nodes of both trees.
 */
class MaximumDepthOfBinaryTree {

    private fun maxDepth(root: TreeNode?): Int {
        return depth(root, 0)
    }

    private fun depth(newRoot: TreeNode?, level: Int): Int {
        if (newRoot == null) return level
        
        val levelLeft = depth(newRoot.left, level + 1)
        val levelRight = depth(newRoot.right, level + 1)
        
        return Math.max(levelLeft, levelRight)
    }

    @Test
    fun test1() {
        val input = TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3).apply {
                left = TreeNode(4)
                    .apply { left = TreeNode(5) }
            }
        }

        val result = maxDepth(input)

        Truth.assertThat(result).isEqualTo(4)
    }

}