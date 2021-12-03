package com.onefivefour.codekatas.trees

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class BinaryTreeZigzagLevelOrderTraversal {


    private fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {

        if (root == null) return emptyList()

        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        var ltr = false
        val result = ArrayList<ArrayList<Int>>()

        while (queue.isNotEmpty()) {

            ltr = !ltr

            val currentLevel = ArrayList<Int>()

            repeat(queue.size) {

                val currentNode = queue.removeFirst()

                currentLevel.add(currentNode.`val`)

                if (currentNode.left != null) queue.add(currentNode.left!!)
                if (currentNode.right != null) queue.add(currentNode.right!!)

            }

            if (currentLevel.isNotEmpty()) {
                if (!ltr) {
                    currentLevel.reverse()
                }
                result.add(currentLevel)
            }

        }

        return result
    }


    @Test
    fun test1() {
        val input = TreeNode(3).apply {
            left = TreeNode(9)
            right = TreeNode(20).apply {
                left = TreeNode(15)
                right = TreeNode(7)
            }
        }

        val result = zigzagLevelOrder(input)

        assertThat(result).isEqualTo(
            listOf(
                listOf(3),
                listOf(20, 9),
                listOf(15, 7)
            )
        )
    }

    @Test
    fun test2() {
        val input = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4)
            }
            right = TreeNode(3).apply {
                right = TreeNode(5)
            }
        }

        val result = zigzagLevelOrder(input)

        assertThat(result).isEqualTo(
            listOf(
                listOf(1),
                listOf(3, 2),
                listOf(4, 5)
            )
        )
    }

}