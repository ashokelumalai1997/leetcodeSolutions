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

	static class Result{
		TreeNode node;
		boolean flag;
		public Result(TreeNode n, boolean f) {
			node = n;
			flag = f;
}
}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Result r = findLCA(root, p, q);
        if(r.flag == false) return null;
		return r.node;
}



public Result findLCA(TreeNode root, TreeNode p, TreeNode q) {
	Result res = new Result(null, false);
	if(root == null) return res;

	Result l = findLCA(root.left, p, q);
	Result r = findLCA(root.right, p, q);

	if(l.flag) return l;
	if(r.flag) return r;

	if(l.node != null && r.node != null) {
		res.node = root;
		res.flag = true;
		return res;
}

	if(root.val == p.val || root.val == q.val) {
		res.node = root;
		if(l.node != null || r.node != null)  {
			res.flag  = true;
			return res;
}
}
    if(l.node != null) return l;
    if(r.node != null) return r;
	
	return res;
	
}

}
