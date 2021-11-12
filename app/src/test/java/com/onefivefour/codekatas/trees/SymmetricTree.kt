package com.onefivefour.codekatas.trees

import com.google.common.truth.Truth
import org.junit.Test

/**
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
class SymmetricTree {

    private fun isSymmetric(root: TreeNode?): Boolean {

        if (root == null) return true

        if (root.left?.`val` != root.right?.`val`) return false

        return compare(root.left, root.right)
    }
    
    private fun compare(root1: TreeNode?, root2: TreeNode?): Boolean {
        
        if (root1 == null && root2 == null) return true
        
        if (root1?.`val` != root2?.`val`) return false
        
        return compare(root1?.left, root2?.right) && compare(root1?.right, root2?.left)
        
    }


    @Test
    fun test1() {
        val input = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4)
                right = TreeNode(5)
            }
            right = TreeNode(2).apply {
                left = TreeNode(5)
                right = TreeNode(4)
            }
        }

        val result = isSymmetric(input)

        Truth.assertThat(result).isTrue()
    }


    @Test
    fun test2() {
        val input = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4)
                right = TreeNode(5)
            }
            right = TreeNode(2).apply {
                left = TreeNode(99)
                right = TreeNode(5)
            }
        }

        val result = isSymmetric(input)

        Truth.assertThat(result).isFalse()
    }

    @Test
    fun test3() {
        val input = TreeNode(1).apply {
            left = TreeNode(2).apply { right = TreeNode(3) }
            right = TreeNode(2).apply { right = TreeNode(3) }
        }

        val result = isSymmetric(input)

        Truth.assertThat(result).isFalse()
    }

}