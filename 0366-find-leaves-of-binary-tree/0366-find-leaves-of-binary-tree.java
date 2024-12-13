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


    private int traverse(TreeNode root, List<List<Integer>> res) {
        if(root == null) return 0;

        int lh = traverse(root.left, res);
        int rh = traverse(root.right, res);

        int h = 1 + Math.max(lh, rh);

        if(h > res.size()) res.add(new ArrayList<>());

        res.get(h-1).add(root.val);

        return h;

    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        int h = traverse(root, res);

        return res;
    }
}


    //         1
    //     2       3
    // 4       6