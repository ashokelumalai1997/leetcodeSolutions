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
    private TreeNode insertNodeToBST(TreeNode root, int val){
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }
        if(val < root.val) root.left = insertNodeToBST(root.left, val);
        else root.right = insertNodeToBST(root.right, val);
        return root;
    }
    public TreeNode[] splitBST(TreeNode root, int target) {
        TreeNode left = null;
        TreeNode right = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode current = q.poll();
            if(current.val <= target) left = insertNodeToBST(left, current.val);
            else right = insertNodeToBST(right, current.val);
            if(current.left != null)
                q.offer(current.left);
            if(current.right != null)
                q.offer(current.right);
        }
        return new TreeNode[]{left, right};
    }
}