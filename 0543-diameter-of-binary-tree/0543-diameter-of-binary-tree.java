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
    int heightOfBinaryTree(TreeNode root){
        if(root==null){
            return -1;
        }
        int left = heightOfBinaryTree(root.left);
        int right = heightOfBinaryTree(root.right);
        return 1+Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return -1;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int hleft = heightOfBinaryTree(root.left);
        int hright = heightOfBinaryTree(root.right);
        int pathRoot = hleft+hright+2;
        return Math.max(pathRoot,Math.max(left,right));
    }
}