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
    private TreeNode getLCANode(TreeNode root, int p, int q){
        if(root == null) return null;
        if(root.val == p || root.val == q) return root;
        TreeNode left = getLCANode(root.left, p, q);
        TreeNode right = getLCANode(root.right, p, q);
        if(left != null && right != null) return root;
        if(left != null) return left;
        return right;
    }
    private int getDistance(TreeNode a, int b){
        if(a == null) return -1;
        if(a.val == b) return 0;
        int left = getDistance(a.left, b);
        if(left != -1) return 1 + left;
        int right = getDistance(a.right, b);
        if(right != -1) return 1 + right;
        return -1;
    }
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode LCA = getLCANode(root, p, q);
        int distanceToP = getDistance(LCA, p);
        int distanceToQ = getDistance(LCA, q);
        return distanceToP + distanceToQ;
    }
}