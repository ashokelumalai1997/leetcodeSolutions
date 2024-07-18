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
    int[] getV(TreeNode root, int distance, int[] result) {
        int[] v = new int[distance + 1];
        if(root == null) return v;
        if(root.left == null && root.right == null) {
            v[0] = 1;
            return v;
        }
        int[] vL = getV(root.left, distance, result);
        int[] vR = getV(root.right, distance, result);
        for(int i = distance; i >= 1; i--) {
            vL[i] = vL[i-1];
            vR[i] = vR[i-1];
            v[i] = vL[i] + vR[i];
        }
        // vL[0] = 0;
        // vR[0] = 0;
        for(int i = 1; i <= distance; i++) {
            for(int j = 1; j <= distance; j++) {
                if(i+j <= distance) {
                    result[0] += vL[i]*vR[j];
                }
            }
        }
        return v;
    }
    public int countPairs(TreeNode root, int distance) {
        int[] result = new int[1];
        int[] v = getV(root, distance, result);
        return result[0];
    }
}