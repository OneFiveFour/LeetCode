package com.onefivefour.codekatas.trees

import com.google.common.truth.Truth
import org.junit.Test

/**
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
class BinaryTreeLevelOrderTraversal {

    private fun levelOrder(root: TreeNode?): List<List<Int>> {

        if (root == null) return emptyList()

        var currentLevel = 1
        val currentLevelValues = mutableListOf<Int>()
        val result = mutableListOf<List<Int>>()
        val queue = ArrayDeque<Pair<Int, TreeNode>>()
        queue.add(currentLevel to root)


        while (queue.isNotEmpty()) {
            
            val currentPair = queue.removeFirst()
            
            if (currentPair.first > currentLevel) {
                // new level reached -> flush list into result, increase level
                result.add(currentLevelValues.toList())
                currentLevelValues.clear()
                currentLevel++
            }

            val currentNode = currentPair.second
            
            currentLevelValues.add(currentNode.`val`)

            if (currentNode.left != null) {
                queue.add(currentLevel + 1 to currentNode.left!!)
            }
            
            if (currentNode.right != null) {
                queue.add(currentLevel + 1 to currentNode.right!!)
            }
            

        }

        result.add(currentLevelValues.toList())

        return result

    }


    @Test
    fun test1() {
        val input = TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3).apply {
                left = TreeNode(4).apply { 
                    left = TreeNode(5) 
                }
            }
        }

        val result = levelOrder(input)

        Truth.assertThat(result[0][0]).isEqualTo(1)
        Truth.assertThat(result[1][0]).isEqualTo(2)
        Truth.assertThat(result[2][0]).isEqualTo(4)
        Truth.assertThat(result[3][0]).isEqualTo(5)
    }

}