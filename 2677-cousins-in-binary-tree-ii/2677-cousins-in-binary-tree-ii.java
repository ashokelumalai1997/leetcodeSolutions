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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return null;

        q.offer(root);

        int previousLevelSum = root.val;
        int currentLevelSum = 0;
        while(!q.isEmpty()) {
            int size = q.size(); //2
            currentLevelSum = 0;
            for(int i = 0; i < size; i++) { //0 < 2
                TreeNode node = q.poll(); //13
                int sibilingSum = 0; 
                if(node.left != null) {
                    currentLevelSum += node.left.val; //1
                    sibilingSum += node.left.val; //1
                }
                if(node.right != null) {
                    currentLevelSum += node.right.val; // 14
                    sibilingSum += node.right.val; // 13
                }
                
                node.val = previousLevelSum - node.val; //0
                if(node.left != null) { 
                    node.left.val = sibilingSum; //13
                    q.offer(node.left); //13
                }
                if(node.right != null) {
                    node.right.val = sibilingSum; //13
                    q.offer(node.right); //13
                }
            }
            previousLevelSum = currentLevelSum; // 13
        }
        return root;
    }
}


//                                 0 levelSum = 14, sibiling sum = 14
//                         0               0 levelSum = 18
//                 7           7                 11 


// put root into a FIFO queue
// currentSum = 0;
// for the current size of queue
//     pull a node
//     currentSum += node.left + node.right
//     node.left = node.left+node.right
//     node = previousLevelSum - node.val
//     push left
//     push right
// previous level sum = currentlevel sum
// currentlevel sum = 0
    
