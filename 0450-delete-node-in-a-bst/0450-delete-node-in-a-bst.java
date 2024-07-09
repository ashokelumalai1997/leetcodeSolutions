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
    private int findMin(TreeNode root) {
        // if(root == null) return -1;
        if(root.left != null) return findMin(root.left);
        return root.val;
    }
    private TreeNode deleteUtil(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) {
            if(root.left == null && root.right == null) {
                return null;
            } else if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else {
                int minVal = findMin(root.right);
                root.val = minVal;
                root.right = deleteUtil(root.right, minVal);
                return root;
            }
        }
        if(key <= root.val)
            root.left = deleteUtil(root.left, key);
        if(key >= root.val)
            root.right = deleteUtil(root.right, key);
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteUtil(root, key);
    }
}