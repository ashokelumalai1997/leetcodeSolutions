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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> trackingQueue = new LinkedList<>();
        trackingQueue.offer(root);
        while(!trackingQueue.isEmpty()){
            TreeNode currentNode = trackingQueue.poll();
            if(currentNode.left==null&&currentNode.right==null){
                continue;
            }
            if(currentNode.left==null){
                trackingQueue.offer(currentNode.right);
                result.add(currentNode.right.val);
                continue;
            }
            if(currentNode.right==null){
                trackingQueue.offer(currentNode.left);
                result.add(currentNode.left.val);
                continue;
            }
            trackingQueue.offer(currentNode.left);
            trackingQueue.offer(currentNode.right);
        }
        return result;
    }
}