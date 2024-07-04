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
class Solution {
    public ListNode mergeNodes(ListNode head) {
        if(head == null) return null;
        ListNode traverser = head.next;
        ListNode valueAssigner = head;
        ListNode end = null;
        int currentSum = 0;
        while(traverser != null) {
            if(traverser.val == 0) {
                if( currentSum != 0 ) {
                    valueAssigner.val = currentSum;
                    end = valueAssigner;
                    valueAssigner = valueAssigner.next;
                    currentSum = 0;
                }
            }
            currentSum += traverser.val;
            traverser = traverser.next;
        }
        end.next = null;
        return head;
    }
}