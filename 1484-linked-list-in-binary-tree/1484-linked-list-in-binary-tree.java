/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private boolean verifySubPath(ListNode head, TreeNode root, ListNode headTracker) {
        if(headTracker == null) return true;
        if(root == null) return false;
        if(headTracker.val != root.val) {
            headTracker = head;
            if(root.val == headTracker.val) headTracker = headTracker.next;
        } else {
            headTracker = headTracker.next;
        }
        boolean left = verifySubPath(head, root.left, headTracker);
        if(left) return left;
        return verifySubPath(head, root.right, headTracker);

    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head == null) return true;
        if(root == null) return false;
        ListNode headTracker = head;
        if(verifySubPath(head, root, headTracker) == true) return true;
        return  isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}