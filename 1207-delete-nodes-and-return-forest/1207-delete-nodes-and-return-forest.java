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
    private TreeNode deleteNodeUtil(TreeNode root, Set<Integer> st, List<TreeNode> result){
        if(root == null) return null;
        root.left = deleteNodeUtil(root.left, st, result);
        root.right = deleteNodeUtil(root.right, st, result);
        if(st.contains(root.val)) {
            if(root.left != null) result.add(root.left);
            if(root.right != null) result.add(root.right);
            return null;
        }
        return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode>  result = new ArrayList<>();
        Set<Integer> st = new HashSet<>();
        for(int td : to_delete) {
            st.add(td);
        }
        root = deleteNodeUtil(root, st, result);
        if(root != null) result.add(root);
        return result;
    }
}