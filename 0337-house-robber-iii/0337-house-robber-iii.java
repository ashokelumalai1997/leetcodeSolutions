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

class Result {
    int take;
    int notTake;

    public Result(int t, int nt) {
        this.take = t;
        this.notTake = nt;
    }
}
class Solution {

    private Result findTotalRob(TreeNode root) {
        if(root == null) {
            return new Result(0, 0);
        }

        Result left = findTotalRob(root.left);
        Result right = findTotalRob(root.right);

        int take = root.val + left.notTake + right.notTake;

        int notTake = Math.max(left.take, left.notTake) 
                        + Math.max(right.take, right.notTake);
        return new Result(take, notTake);
    }

    public int rob(TreeNode root) {
        Result res = findTotalRob(root);
        return Math.max(res.take, res.notTake);
    }
}