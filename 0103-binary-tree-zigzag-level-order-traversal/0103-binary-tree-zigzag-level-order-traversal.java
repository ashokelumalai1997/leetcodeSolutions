class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        
		
		Queue<TreeNode> qNode = new LinkedList<>();
		List<List<Integer>> result = new LinkedList<>();

        if(root == null) return result;


		qNode.offer(root);


		boolean flag = true;

		while(!qNode.isEmpty()) {

			int n = qNode.size();

			List<Integer> currentL  = new LinkedList<>();

			for(int i = 0; i < n; i++) {
				TreeNode current  = qNode.poll();
				if(current.left != null) {
					qNode.offer(current.left);
}
if(current.right != null) {
					qNode.offer(current.right);
}

if(flag) {
	currentL.addLast(current.val);
} else {
currentL.addFirst(current.val);
}
}

flag = (flag ? false : true);
			result.add(currentL);
			

			
}

return result;
		
		
}
}
