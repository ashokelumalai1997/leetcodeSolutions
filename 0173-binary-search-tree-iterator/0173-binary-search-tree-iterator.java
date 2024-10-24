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
class BSTIterator {
    
    Stack<TreeNode> nodeStack;

    public BSTIterator(TreeNode root) {
        this.nodeStack = new Stack<>();
        initNodeStack(root);        
    }

    private void initNodeStack(TreeNode node) {
        TreeNode temp = node;
        while(temp != null) {
            nodeStack.push(temp);
            temp = temp.left;
        }
    }
    
    public int next() {
        TreeNode nextOnLine = nodeStack.pop();
        if(nextOnLine.right != null) initNodeStack(nextOnLine.right);
        return nextOnLine.val;
    }
    
    public boolean hasNext() {
        return !nodeStack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */



