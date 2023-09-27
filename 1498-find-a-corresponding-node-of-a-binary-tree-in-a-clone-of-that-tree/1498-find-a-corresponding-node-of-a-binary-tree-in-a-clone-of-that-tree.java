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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> originalQueue = new LinkedList<>();
        Queue<TreeNode> cloneQueue = new LinkedList<>();
        originalQueue.offer(original);
        cloneQueue.offer(cloned);
        TreeNode clonedTarget = null;
        while(!originalQueue.isEmpty()){
            TreeNode current = originalQueue.poll();
            TreeNode currentCloned = cloneQueue.poll();
            if(current == target){
                clonedTarget = currentCloned;
                break;
            }
            if(current.left!=null){
                originalQueue.offer(current.left);
                cloneQueue.offer(currentCloned.left);
            }
            if(current.right!=null){
                originalQueue.offer(current.right);
                cloneQueue.offer(currentCloned.right);
            }
        }
        return clonedTarget;
        
    }
}