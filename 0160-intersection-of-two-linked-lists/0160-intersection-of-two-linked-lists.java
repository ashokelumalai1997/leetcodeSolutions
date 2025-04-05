/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode Apointer = headA;
        ListNode Bpointer = headB;

        while(Apointer != Bpointer) {
            
            
            if(Apointer == null) Apointer = headB;
            else Apointer = Apointer.next;
            if(Bpointer == null) Bpointer = headA;
            else Bpointer = Bpointer.next;
        }

        return Apointer;
    }
}