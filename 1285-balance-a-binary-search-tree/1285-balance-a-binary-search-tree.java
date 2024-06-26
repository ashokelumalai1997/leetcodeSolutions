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
    private void preOrderTraversal(TreeNode root, List<Integer> list){
        if(root == null) return;
        preOrderTraversal(root.left, list);
        list.add(root.val);
        preOrderTraversal(root.right, list);
    }
    private TreeNode buildBalancedBST(List<Integer> list, int start, int end){
        if(start > end) return null;
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildBalancedBST(list, start, mid - 1);
        root.right = buildBalancedBST(list, mid + 1, end);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderTraversal(root, list);
        TreeNode newRoot = buildBalancedBST(list, 0, list.size() - 1);
        return newRoot;
    }
}