package com.onefivefour.codekatas.trees

import com.google.common.truth.Truth
import org.junit.Test

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * * The left subtree of a node contains only nodes with keys less than the node's key.
 * * The right subtree of a node contains only nodes with keys greater than the node's key.
 * * Both the left and right subtrees must also be binary search trees.
 */
class ValidateBinarySearchTree {

    private fun isValidBST(root: TreeNode?): Boolean {

        if (root == null) return true

        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE)

    }

    private fun isValid(node: TreeNode?, min: Long, max: Long): Boolean {

        if (node == null) return true

        if (node.`val` <= min || node.`val` >= max) return false
        
        return isValid(node.left, min, (node.`val`).toLong()) && isValid(node.right, (node.`val`).toLong(), max)
    }

    @Test
    fun test1() {
        val input = TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3)
        }

        val result = isValidBST(input)

        Truth.assertThat(result).isFalse()
    }

    @Test
    fun test6() {
        val input = TreeNode(Int.MIN_VALUE).apply {
            left = TreeNode(Int.MIN_VALUE)
        }

        val result = isValidBST(input)

        Truth.assertThat(result).isFalse()
    }

    @Test
    fun test2() {
        val input = TreeNode(5).apply {
            left = TreeNode(1)
            right = TreeNode(4).apply {
                left = TreeNode(3)
                right = TreeNode(8)
            }
        }

        val result = isValidBST(input)

        Truth.assertThat(result).isFalse()
    }

    @Test
    fun test3() {
        val input = TreeNode(2).apply {
            left = TreeNode(1)
            right = TreeNode(3)
        }

        val result = isValidBST(input)

        Truth.assertThat(result).isTrue()
    }

    @Test
    fun test5() {
        val input = TreeNode(5).apply {
            left = TreeNode(4)
            right = TreeNode(6).apply {
                left = TreeNode(3)
                right = TreeNode(7)
            }
        }

        val result = isValidBST(input)

        Truth.assertThat(result).isFalse()
    }

    @Test
    fun test4() {
        val input = TreeNode(2).apply {
            left = TreeNode(2)
            right = TreeNode(2)
        }

        val result = isValidBST(input)

        Truth.assertThat(result).isFalse()
    }

}