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
    int[] getDistanceV(TreeNode root, int distance, int[] result){
        int[] distanceV = new int[distance + 1];
        if(root == null) return distanceV;
        if(root.left == null && root.right == null) {
            distanceV[0] = 1;
            return distanceV;
        }
        int[] distanceVL = getDistanceV(root.left, distance, result);
        int[] distanceVR = getDistanceV(root.right, distance, result);
        for(int i = distance; i >= 1; i --) {
            distanceVL[i] = distanceVL[i-1];
            distanceVR[i] = distanceVR[i-1];
        }
        distanceVL[0] = 0;
        distanceVR[0] = 0;
        for(int i = 1; i <= distance-1; i++) {
            result[0] += distanceVL[i]*distanceVR[distance-i];
        }
        for(int i = 0; i < distance+1; i++) {
            distanceV[i] = distanceVL[i] + distanceVR[i];
        }
        return distanceV;
    }
    private int countPair(TreeNode root, int distance) {
        int[] distanceV = new int[distance+1];
        int[] result = new int[1];
        int[] distanceVL = getDistanceV(root.left, distance, result);
        int[] distanceVR = getDistanceV(root.right, distance, result);
        // distanceVL[1] = distanceVL[0];
        // distanceVR[1] = distanceVR[0];
        for(int i = distance; i >= 1; i--) {
            distanceVL[i] = distanceVL[i-1];
            distanceVR[i] = distanceVR[i-1];
        }
        distanceVL[0] = 0;
        distanceVR[0] = 0;
        for(int i = 1; i <= distance-1; i++) {
            
            result[0] += distanceVL[i]*distanceVR[distance-i];
        }
        return result[0];
    }
    public int countPairs(TreeNode root, int distance) {
        int result = 0;
        for(int d = 1; d <= distance; d++) {
            result += countPair(root, d);
        }
        return result;
    }
}