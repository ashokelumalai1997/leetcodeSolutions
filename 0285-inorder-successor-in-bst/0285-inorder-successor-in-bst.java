/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode findMin(TreeNode root){
        if(root==null) return null;
        if(root.left!=null) return findMin(root.left);
        return root;
    }
    public TreeNode ios(TreeNode root, TreeNode p, TreeNode parent){
        if(root==null) return null;
        if(root==p){
            if(root.right!=null) return findMin(root.right);
            else return parent;
        }
        if(p.val<root.val) return ios(root.left,p,root);
        return ios(root.right,p,parent);
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode parent=null;
        return ios(root,p,parent);
    }
}