package com.onefivefour.codekatas.trees

import com.google.common.truth.Truth
import org.junit.Test

/**
Given the root of a binary tree, return the sum of all left leaves.
 */
class SumOfLeftLeaves {

    private fun sumOfLeftLeaves(root: TreeNode?): Int {

        if (root == null) return 0

        return sumLeft(root, false)
    }


    private fun sumLeft(root: TreeNode?, isLeft: Boolean): Int {
        
        if (root == null) return 0
        
        if (root.left == null && root.right == null && isLeft) {
            return root.`val`
        }
        
        
        return sumLeft(root.left, true) + sumLeft(root.right, false)
        
    }
   
    @Test
    fun test1() {
        val input1 = TreeNode(1)
        input1.left = TreeNode(2).apply { left = TreeNode(4); right = TreeNode(5) }
        input1.right = TreeNode(3).apply { left = TreeNode(6); right = TreeNode(7) }

        val result = sumOfLeftLeaves(input1)
        
        println(result.toString())
        
        Truth.assertThat(result).isEqualTo(10)
    }

    @Test
    fun test2() {
        val input1 = TreeNode(1)

        val result = sumOfLeftLeaves(input1)

        Truth.assertThat(result).isEqualTo(0)
    }


}