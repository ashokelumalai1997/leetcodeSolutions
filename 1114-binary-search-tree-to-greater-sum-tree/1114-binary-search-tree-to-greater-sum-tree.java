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
    private void bstToGst(TreeNode root, int[] defaultSum){ 
        if(root == null) return;
        bstToGst(root.right, defaultSum);
        root.val += defaultSum[0];
        defaultSum[0] = root.val;
        bstToGst(root.left, defaultSum);
    }
    public TreeNode bstToGst(TreeNode root) {
        int[] a = {0};
        bstToGst(root, a);
        return root;
    }
}