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
    private TreeNode buildTree(int parent, Map<Integer, int[]> parentChildMap) {
        if(parent == -1) return null;
        TreeNode root = new TreeNode(parent);
        int[] childs = parentChildMap.get(parent);
        root.left = buildTree(childs[0], parentChildMap);
        root.right = buildTree(childs[1], parentChildMap);
        return root;
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, int[]> parentChildMap = new HashMap<>();
        Map<Integer, Boolean> isAChild = new HashMap<>();
        for(int[] des : descriptions) {
            if(!isAChild.containsKey(des[0])) {
                isAChild.put(des[0], false);
            }
            isAChild.put(des[1], true);
            // int[] temp = new int[]{-1, -1};
            // int[] temp1 = new int[]{-1, -1};
            parentChildMap.putIfAbsent(des[0], new int[]{-1, -1});
            parentChildMap.putIfAbsent(des[1], new int[]{-1, -1});
            if(des[2] == 1) parentChildMap.get(des[0])[0] = des[1];
            else parentChildMap.get(des[0])[1] = des[1];
        }
        int parent = 0;
        for(Map.Entry<Integer, Boolean> e : isAChild.entrySet()) {
            if(e.getValue() == false) {
                parent = e.getKey();
                break;
            }
        }
        TreeNode root = buildTree(parent, parentChildMap);
        return root;
    }
}