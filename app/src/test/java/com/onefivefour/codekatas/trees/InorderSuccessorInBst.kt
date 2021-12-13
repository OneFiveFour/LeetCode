package com.onefivefour.codekatas.trees

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.util.*

/**
 * Given the root of a binary search tree and a node p in it, return the in-order successor of that node in the BST. If the given node has no in-order successor in the tree, return null.

The successor of a node p is the node with the smallest key greater than p.val.
 */
class InorderSuccessorInBst {

    private val stack = ArrayDeque<TreeNode>()

    private fun inorderSuccessor(root: TreeNode?, p: TreeNode?): TreeNode? {

        if (root == null || p == null) return null

        if (root.`val` > p.`val`) {
            stack.addFirst(root)
            return inorderSuccessor(root.left, p)
            

        } else if (root.`val` < p.`val`) {
            stack.addFirst(root)
            return inorderSuccessor(root.right, p)

            
        } else if (root.`val` == p.`val`) {

            if (root.right != null) {
                return mostLeft(root.right!!)
            }

            if (stack.isEmpty()) {
                return null
            }

            var parent = stack.removeFirst()

            while (stack.isNotEmpty() && parent.`val` < root.`val`) {
                parent = stack.removeFirst()
            }

            return if (parent.`val` > p.`val`) parent else null

        }

        return null
    }

    private fun mostLeft(root: TreeNode): TreeNode? {
        if (root.left != null) return mostLeft(root.left!!)
        return root
    }


    @Test
    fun test1() {
        val input = TreeNode(2).apply { 
            left = TreeNode(1) 
            right = TreeNode(3)
        }
        
        val result = inorderSuccessor(input, TreeNode(1))
        
        assertThat(result?.`val`).isEqualTo(2)
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
        
        val result = inorderSuccessor(input, TreeNode(6))
        
        assertThat(result).isEqualTo(null)
    }
    
    
    @Test
    fun test3() {
        val input = TreeNode(6).apply { 
            left = TreeNode(2).apply { 
                left = TreeNode(0)
                right = TreeNode(4).apply { 
                    left = TreeNode(3)
                    right = TreeNode(5)
                }
            }
            right = TreeNode(8).apply { 
                left = TreeNode(8)
                right = TreeNode(9)
            }
        }
        
        val result = inorderSuccessor(input, TreeNode(2))
        
        assertThat(result?.`val`).isEqualTo(3)
    }
    
    
}