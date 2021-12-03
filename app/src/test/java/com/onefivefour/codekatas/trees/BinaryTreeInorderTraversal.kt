package com.onefivefour.codekatas.trees

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class BinaryTreeInorderTraversal {
    
    val result = ArrayList<Int>()
    
    private fun inorderTraversal(root: TreeNode?): List<Int> {
        
        if (root == null) return emptyList()
        
        // left
        if (root.left != null) {
            inorderTraversal(root.left)
        }
        
        // root 
        result.add(root.`val`)
        
        // right
        if (root.right != null) {
            inorderTraversal(root.right)
        }
        
        return result
        
    }
    
    
    @Test
    fun test1() {
        val input = TreeNode(1).apply { 
            left = null
            right = TreeNode(2).apply { 
                left = TreeNode(3)
                right = null
            }
        }
        
        val result = inorderTraversal(input)
        
        assertThat(result).isEqualTo(listOf(1, 3, 2))
    }
    
    
    @Test
    fun test2() {
        val input = TreeNode(1).apply { 
            left = TreeNode(2)
        }
        
        val result = inorderTraversal(input)
        
        assertThat(result).isEqualTo(listOf(2,1))
    }
    
    
    @Test
    fun test3() {
        val input = TreeNode(1).apply { 
            right = TreeNode(2)
        }
        
        val result = inorderTraversal(input)
        
        assertThat(result).isEqualTo(listOf(1,2))
    }
    
}