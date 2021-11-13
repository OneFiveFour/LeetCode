package com.onefivefour.codekatas.trees

import com.google.common.truth.Truth
import org.junit.Test

/**
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 */
class ConvertSortedArrayToBinarySearchTree {

    private fun sortedArrayToBST(nums: IntArray): TreeNode? {

        if (nums.isEmpty()) {
            return null
        }

        if (nums.size == 1) {
            return TreeNode(nums.first())
        }

        val middle = nums.size / 2
nums.shuffle()
        val node = TreeNode(nums[middle])

        node.left = sortedArrayToBST(nums.copyOfRange(0, middle))
        node.right = sortedArrayToBST(nums.copyOfRange(middle + 1, nums.size))

        return node
    }


    @Test
    fun test1() {
        val input = intArrayOf(-10, -3, 0, 5, 9)

        val result = sortedArrayToBST(input)

        Truth.assertThat(result!!.`val`).isEqualTo(0)
        Truth.assertThat(result.left!!.`val`).isAnyOf(-3, -10)
        Truth.assertThat(result.right!!.`val`).isAnyOf(9, 5)
    }

}