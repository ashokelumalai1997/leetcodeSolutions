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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> Output = new ArrayList<>();
        Queue<TreeNode> stack = new LinkedList<>();
        if(root==null) return Output;
        stack.offer(root);
        int flag = 1;
        while(!stack.isEmpty()){
            int n =stack.size();
            List<Integer> currentList = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode currentNode = stack.poll();
                if(currentNode.left!=null) stack.offer(currentNode.left);
                if(currentNode.right!=null) stack.offer(currentNode.right);
                currentList.add(currentNode.val);
            }
            if(flag==0){
                Collections.reverse(currentList);
                flag=1;
            }
            else flag=0;
            Output.add(currentList);
        }
        return Output;
    }
}