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


class Solution {

    static class Result {
        int leftVal;
        int rightVal;
        int max;

        public Result(int l, int r, int m) {
            this.leftVal = l;
            this.rightVal = r;
            this.max = m;
        }
    }

    private Result getMaxZZ(TreeNode root) {
        if(root == null) {
            return new Result(-1, -1, -1);
        }

        if(root.left == null && root.right == null) {
            return new Result(0, 0, 0);
        }

        Result left = getMaxZZ(root.left);

        Result right = getMaxZZ(root.right);

        int maxThroughLeft = left.rightVal + 1;
        int maxThroughRight = right.leftVal + 1;
        int maxOverall = Math.max(left.max, right.max);
        maxOverall = Math.max(maxThroughLeft, maxOverall);
        maxOverall = Math.max(maxThroughRight, maxOverall);
        return new Result(maxThroughLeft, maxThroughRight, maxOverall);
    }
    public int longestZigZag(TreeNode root) {
        Result res = getMaxZZ(root);
        return res.max;
    }
}



    // maxZigZagPath
    // max zigZagPathLenFrom current node 

    //                         a

    //                 b               c
    //         d               e
    //                             f
    //                         g
    //                             h