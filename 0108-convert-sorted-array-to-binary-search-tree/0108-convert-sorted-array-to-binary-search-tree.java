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
    private TreeNode buildTree(int left, int right, int[] nums) {
        if(left > right) return null;

        int mid = left + (right - left)/2;

        TreeNode node = new TreeNode(nums[mid]);

        if(left == right) return node;

        node.left = buildTree(left, mid-1, nums);
        node.right = buildTree(mid+1, right, nums);


        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(0, nums.length-1, nums);
    }
}