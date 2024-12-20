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
    private void dfs(TreeNode l, TreeNode r, Boolean skipFlag) {
        if(l == null && r == null) return;
        if(!skipFlag) {
            int temp = l.val;
            l.val = r.val;
            r.val = temp;
        }
        dfs(l.left, r.right, !skipFlag);
        dfs(l.right, r.left, !skipFlag);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        Boolean skipFlag = false;
        dfs(root.left, root.right, skipFlag);
        return root;
    }
}