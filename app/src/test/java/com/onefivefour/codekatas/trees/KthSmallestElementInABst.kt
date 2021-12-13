package com.onefivefour.codekatas.trees

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.util.*

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
class KthSmallestElementInABst {


    /**
     * Iterative approach
     */
    private fun kthSmallest(root: TreeNode?, k: Int): Int {
        
        val stack = LinkedList<TreeNode>()
        var node = root
        var n = k
        
        while (true) {
            
            while (node != null) {
                stack.add(node)
                node = node.left
            }
            
            node = stack.removeLast()
            n--
            if (n == 0) return node.`val`
            
            node = node.right
            
        }
    }

    /**
     * recursive approach
     */
    private fun kthSmallest2(root: TreeNode?, k: Int): Int {
        
        val inorder = traverseInorder(root)
        
        return inorder[k-1]
        
    }
    
    
    private fun traverseInorder(root: TreeNode?) : IntArray {
        
        if (root == null) return intArrayOf()
        
        val result = mutableListOf<Int>()
        
        if (root.left != null) {
            result.addAll(traverseInorder(root.left).toList())
        }
        
        result += root.`val`
        
        if (root.right != null) {
            result.addAll(traverseInorder(root.right).toList())
        }
        
        return result.toIntArray()
    }
    
    
    @Test
    fun test1() {
        val input = TreeNode(3).apply { 
            left = TreeNode(1).apply { 
                right = TreeNode(2)
            }
            right = TreeNode(4)
        }
        
        val result = kthSmallest(input, 1)
        
        assertThat(result).isEqualTo(1)
    }
    
    
    @Test
    fun test2() {
        val input = TreeNode(5).apply { 
            left = TreeNode(3).apply { 
                left = TreeNode(2).apply { 
                    left = TreeNode(1)
                }
                right = TreeNode(3)
            }
            right = TreeNode(6)
        }
        
        val result = kthSmallest(input, 3)
        
        assertThat(result).isEqualTo(3)
    }
    
    
}