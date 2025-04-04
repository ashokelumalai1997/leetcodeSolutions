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
	static class NodeOutput {
		TreeNode node;
		int depth;
		public NodeOutput(TreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
}
}


public NodeOutput findLCA(TreeNode root, int depth) {
	
	if(root == null) return new NodeOutput(null, depth);
	NodeOutput left = findLCA(root.left, depth+1);
	NodeOutput right = findLCA(root.right, depth+1);

	if(left.depth == right.depth) return new NodeOutput(root, left.depth);
	else if(left.depth > right.depth) return left;
	return right;
}

public TreeNode lcaDeepestLeaves(TreeNode root) {
	NodeOutput result = findLCA(root, 0);
	return result.node;
}
}
