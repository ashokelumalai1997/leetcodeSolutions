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
    private List<Integer> inorderTraversalHelp(TreeNode root){
        if(root==null) return new ArrayList<>();
        List<Integer> result=new ArrayList<>();
        List<Integer> left = inorderTraversalHelp(root.left);
        
        List<Integer> right = inorderTraversalHelp(root.right);
        if(left!=null) result.addAll(left);
        result.add(root.val);
        if(right!=null) result.addAll(right);
        return result;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversalHelp(root);
    }
}