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
    private Integer count=0;
    class Pair{
        int total;
        int count;
        Pair(int total, int count){
            this.total=total;
            this.count=count;
        }
    }
    private Pair calculateNodes(TreeNode root){
        if(root==null)
            return new Pair(0,0);
        Pair left = calculateNodes(root.left);
        Pair right = calculateNodes(root.right);
        int total = left.total+right.total+root.val;
        int totalCount = left.count + right.count + 1;
        int num = (int)total/totalCount;
        if(root.val == 5){
            System.out.println("totalCount");
            System.out.println(totalCount);
            System.out.println(total);
        }
        if(num==root.val) {
            count++;
            System.out.println(num);
        }
        return new Pair(left.total+right.total+root.val,left.count+right.count+1);
    }
    public int averageOfSubtree(TreeNode root) {
        Pair p = calculateNodes(root);
        return count;
    }
}