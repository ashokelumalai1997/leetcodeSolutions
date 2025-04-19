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
// class Solution {
//     public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
//     }
// }


class Solution {

// 	static class TreeNode {
// 		int val;
// 		TreeNode left;
// 		TreeNode right;

// 		public TreeNode() {
// 			//TODO :
// }
// }

	public List<Integer> boundaryOfBinaryTree(TreeNode node) {

        
		ArrayList<Integer> leftBoundary = new ArrayList<>();
		if(node.left != null) leftBoundary = getLeftBoundary(node.left);
		ArrayList<Integer> rightBoundary = new ArrayList<>();
if(node.right != null) rightBoundary = getRightBoundary(node.right);
		ArrayList<Integer> bottomBoundary = getBottomBoundary(node);

		// if(leftBoundary.size() != 0)
        // leftBoundary.remove(leftBoundary.size() - 1);

		 
		ArrayList<Integer> result = new ArrayList<>();

		result.add(node.val);

        if(node.left == null && node.right == null) return result;

		Collections.reverse(rightBoundary);
		// rightBoundary.remove(0);
		
		result.addAll(leftBoundary);
		result.addAll(bottomBoundary);
		result.addAll(rightBoundary);


		return result;

}

private ArrayList<Integer> getLeftBoundary(TreeNode node) {
	Deque<TreeNode> q = new LinkedList<>();
	q.offer(node);
	ArrayList<Integer> result = new ArrayList<>();
	while(!q.isEmpty()) {
		TreeNode current  = q.peek();
        if(!(current.left == null && current.right == null))
		result.add(current.val);

		int size = q.size();
		while(size != 0) {
			TreeNode qcurrent = q.poll();
			if(qcurrent.left != null)
			q.offer(qcurrent.left);
			else if(qcurrent.right != null)
			q.offer(qcurrent.right);
			size--;
}
}

return result;
}

private ArrayList<Integer> getRightBoundary(TreeNode node) {
	Deque<TreeNode> q = new LinkedList<>();
	q.offer(node);
	ArrayList<Integer> result = new ArrayList<>();
	while(!q.isEmpty()) {
		TreeNode current  = q.peekLast();
        if(!(current.left == null && current.right == null))
		result.add(current.val);

		int size = q.size();
		while(size != 0) {
			TreeNode qcurrent = q.poll();
			if(qcurrent.right != null)
			q.offer(qcurrent.right);
				else if(qcurrent.left != null)
			q.offer(qcurrent.left);
			size--;
}
}

return result;
}

private ArrayList<Integer> getBottomBoundary(TreeNode node) {
	ArrayList<Integer> result = new ArrayList<>();
if(node == null) return result;

	if(node.left == null && node.right == null) {
		result.add(node.val);
		return result;
}


result.addAll(getBottomBoundary(node.left));
result.addAll(getBottomBoundary(node.right));

return result;
}
}