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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return new ArrayList<>();
        }
        if(root.right == null && root.left == null) {
            if(root.val == targetSum) {
                List<Integer> l = new ArrayList<>();
                l.add(root.val);
                List<List<Integer>> n = new ArrayList<>();
                n.add(l);
                return n;
            } else {
                return new ArrayList<>();
            }
        }
        List<List<Integer>> left = new ArrayList<>();
        if(root.left != null)
        left = pathSum(root.left, targetSum - root.val);
        List<List<Integer>> right = new ArrayList<>();
        if(root.right != null)
        right = pathSum(root.right, targetSum - root.val);

        List<List<Integer>> res = new ArrayList<>();

        // if(left.size() != 0 || (root.left == bull)) {
            for(List<Integer> l : left) {
                List<Integer> n = new ArrayList<>();
                n.add(root.val);
                n.addAll(l);
                res.add(n);
            }
        // }

        // if(right.size() != 0) {
            for(List<Integer> l : right) {
                List<Integer> n = new ArrayList<>();
                n.add(root.val);
                n.addAll(l);
                res.add(n);
            }
        // }

        return res;
    }
}

