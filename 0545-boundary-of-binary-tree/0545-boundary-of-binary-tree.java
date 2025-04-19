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
    TreeNode roota = null;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        roota = root;
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        // Add root
        result.add(root.val);
        
        // If root is a leaf node, return early
        if (root.left == null && root.right == null) return result;
        
        // Get left boundary (excluding leaf nodes)
        getLeftBoundary(root.left, result);
        
        // Get leaf nodes
        getLeaves(root, result);
        
        // Get right boundary in reverse order (excluding leaf nodes)
        List<Integer> rightBoundary = new ArrayList<>();
        getRightBoundary(root.right, rightBoundary);
        Collections.reverse(rightBoundary);
        result.addAll(rightBoundary);
        
        return result;
    }
    
    private void getLeftBoundary(TreeNode node, List<Integer> result) {
        if (node == null) return;
        
        // If node is not a leaf, add to result
        if (!(node.left == null && node.right == null)) {
            result.add(node.val);
        }
        
        // Traverse left if possible, otherwise right
        if (node.left != null) {
            getLeftBoundary(node.left, result);
        } else if (node.right != null) {
            getLeftBoundary(node.right, result);
        }
    }
    
    private void getRightBoundary(TreeNode node, List<Integer> result) {
        if (node == null) return;
        
        // If node is not a leaf, add to result
        if (!(node.left == null && node.right == null)) {
            result.add(node.val);
        }
        
        // Traverse right if possible, otherwise left
        if (node.right != null) {
            getRightBoundary(node.right, result);
        } else if (node.left != null) {
            getRightBoundary(node.left, result);
        }
    }
    
    private void getLeaves(TreeNode node, List<Integer> result) {
        if (node == null) return;
        
        // If node is a leaf, add to result
        if (node.left == null && node.right == null && node != roota) {
            result.add(node.val);
            return;
        }
        
        // Traverse left and right subtrees
        getLeaves(node.left, result);
        getLeaves(node.right, result);
    }
}