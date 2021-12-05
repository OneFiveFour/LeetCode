package com.onefivefour.codekatas.trees

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 */
class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private var rootIndex = -1

    private fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode {

        rootIndex += 1

        val currentRootValue = preorder[rootIndex]

        val result = TreeNode(currentRootValue)

        if (inorder.size == 1) return result

        val splitAt = inorder.indexOf(currentRootValue)

        val leftStartIndex = splitAt
        if (leftStartIndex > 0) {
            val leftSubTree = inorder.copyOfRange(0, splitAt)
            result.left = buildTree(preorder, leftSubTree)
        }

        val rightStartIndex = splitAt + 1
        if (rightStartIndex < inorder.size) {
            val rightSubTree = inorder.copyOfRange(rightStartIndex, inorder.size)
            result.right = buildTree(preorder, rightSubTree)
        }

        return result

    }
    
    
    @Test
    fun test1() {
        val preorder = intArrayOf(1,2)
        val inorder = intArrayOf(1,2)
        
        val result = buildTree(preorder, inorder)
        
        assertThat(result.`val`).isEqualTo(1)
        assertThat(result.left?.`val`).isEqualTo(null)
        assertThat(result.right?.`val`).isEqualTo(2)
    }
    
    @Test
    fun test2() {
        val preorder = intArrayOf(1,2)
        val inorder = intArrayOf(2,1)
        
        val result = buildTree(preorder, inorder)
        
        assertThat(result.`val`).isEqualTo(1)
        assertThat(result.left?.`val`).isEqualTo(2)
        assertThat(result.right?.`val`).isEqualTo(null)
    }
    
    @Test
    fun test3() {
        val preorder = intArrayOf(3,9,20,15,7)
        val inorder = intArrayOf(9,3,15,20,7)
        
        val result = buildTree(preorder, inorder)
        
        assertThat(result.`val`).isEqualTo(3)
        assertThat(result.left?.`val`).isEqualTo(9)
        assertThat(result.right?.`val`).isEqualTo(20)
        assertThat(result.right?.left?.`val`).isEqualTo(15)
        assertThat(result.right?.right?.`val`).isEqualTo(7)
    }
    
    
}