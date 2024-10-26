/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
1. have a int[] maxHeightBefore = new int[n]
2. traverse root left to right, keep track of current distance from root, maximum distance so far
3. On visiting a node, update the nodes maxHeightBefore with max so far, update current and max so far
4. Do the same right to left
*/

class Solution {
    HashMap<Integer, Integer> maxHeightBefore;
    int maxHeightSoFar;

    private void traverseLeftToRight(TreeNode root, int currentHeight) {
        if(root == null) return;
        maxHeightBefore.put(root.val, maxHeightSoFar);
        maxHeightSoFar = Math.max(maxHeightSoFar, 1 + currentHeight);
        traverseLeftToRight(root.left, currentHeight + 1);
        traverseLeftToRight(root.right, currentHeight + 1);
    }

    private void traverseRightToLeft(TreeNode root, int currentHeight) {
        if(root == null) return;
        if(maxHeightBefore.get(root.val) < maxHeightSoFar)
            maxHeightBefore.put(root.val, maxHeightSoFar);
        maxHeightSoFar = Math.max(maxHeightSoFar, 1 + currentHeight);
        traverseRightToLeft(root.right, currentHeight + 1);
        traverseRightToLeft(root.left, currentHeight + 1);
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        maxHeightBefore = new HashMap<>();
        maxHeightSoFar = -1;
        traverseLeftToRight(root, -1);
        maxHeightSoFar = -1;
        traverseRightToLeft(root, -1);
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            res[i] = maxHeightBefore.get(queries[i]);
        }
        return res;
    }
}


// Given

// Binary tree has n nodes from 1 to n
// TreeNode root

// int[] Queries [n]


// Function:
// perform m independent queries 

// For a query i in queries:
//     remove subtree rooted at value queries[i]

// return answer[] of size m, answer[i] = height of the tree after performing ith query



// (ch = 1, mh = 3)


