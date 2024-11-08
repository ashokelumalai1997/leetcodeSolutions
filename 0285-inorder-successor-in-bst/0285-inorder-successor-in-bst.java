/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // public Stack<Integer> s;
    public TreeNode getMin(TreeNode root) {
        if(root.left == null) return root;
        return getMin(root.left);
    }
    public TreeNode ios(TreeNode root, TreeNode p, Stack<TreeNode> s) {
        if(root == null) return null;

        if(root.val == p.val) {
            if(root.right != null) return getMin(root.right);
            if(s.size() != 0) return s.peek();
            return null;
        }

        s.push(root);
        TreeNode l = ios(root.left , p, s);

        if(l != null) return l;
        s.pop();
        TreeNode r = ios(root.right, p, s);

        return r;

    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // if(root == null) return null;
        return ios(root, p, new Stack<>());

    }
}

        //                     a
        //                 b       c
        //             c
        //         d       e
        //             f
        //         g       h    

        // do iot
        //     if target is found,
        //         if right is not null, return min of right
        //         else return last one from ancestors 
        //             note: ancestors are added while moving left, removed while moving right


