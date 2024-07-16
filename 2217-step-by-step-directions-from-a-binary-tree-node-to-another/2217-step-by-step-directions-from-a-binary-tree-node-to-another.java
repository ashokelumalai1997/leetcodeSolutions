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
    private TreeNode getLCA(TreeNode root, int startValue, int destValue){
        if(root == null) return null;
        if(root.val == startValue || root.val == destValue) return root;
        TreeNode left = getLCA(root.left, startValue, destValue);
        TreeNode right = getLCA(root.right, startValue, destValue);
        if(left != null && right != null) return root;
        if(left != null) return left;
        return right;
    }

    private boolean findPath(TreeNode root, int value, List<Character> res){
        if(root == null) return false;
        if(root.val == value) return true;
        res.add('L');
        boolean left = findPath(root.left, value, res);
        if(left) return true;
        else res.remove(res.size() - 1);
        res.add('R');
        boolean right = findPath(root.right, value, res);
        if(right) return true;
        else res.remove(res.size() - 1);
        // res.remove(res.size() - 1);
        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LCA = getLCA(root, startValue, destValue);
        if(LCA.val == startValue) {

        }
        if(LCA.val == destValue) {

        }
        List<Character> pts = new ArrayList<>();
        findPath(LCA, startValue, pts);
        List<Character> pte = new ArrayList<>();
        findPath(LCA, destValue, pte);
        // List<Character> result = pathToStart.get(0);
        
        for(int i = 0; i < pts.size(); i++) {
            pts.set(i, 'U');
        }
        pts.addAll(pte);
        StringBuilder sb = new StringBuilder();
        for(Character ch : pts) {
            sb.append(ch);
        }
        return sb.toString();
    }
}