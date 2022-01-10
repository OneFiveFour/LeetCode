package com.onefivefour.codekatas.design


/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 */
class SerializeAndDeserializeBinaryTree {

    companion object {
        private const val NULL_NODE = Int.MIN_VALUE
        private const val DELIMITER = "|"
    }

    private val values = ArrayList<Int>()

    private var index = 0

    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {

        if (root == null) return ""

        values.clear()

        createValues(root)

        return values.joinToString(DELIMITER)

    }

    private fun createValues(node: TreeNode) {

        values.add(node.`val`)

        val nodeLeft = node.left
        if (nodeLeft != null) {
            createValues(nodeLeft)
        } else {
            values.add(NULL_NODE)
        }

        val nodeRight = node.right
        if (nodeRight != null) {
            createValues(nodeRight)
        } else {
            values.add(NULL_NODE)
        }

    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {

        if (data.isEmpty()) return null

        values.clear()
        index = 0

        val nodeValues = data.split(DELIMITER).map { it.toInt() }
        values.addAll(nodeValues)

        return buildNodes()
    }


    private fun buildNodes() : TreeNode? {

        if (index !in values.indices) return null

        if (values[index] == NULL_NODE) return null

        val result = TreeNode(values[index])

        index++
        result.left = buildNodes()

        index++
        result.right = buildNodes()

        return result

    }
    
}