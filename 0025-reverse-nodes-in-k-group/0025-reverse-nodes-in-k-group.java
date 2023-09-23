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
    public ListNode reverseKGroup(ListNode head, int k) {
        /*
        --> reversing first k nodes
            
            current=head
            while(current)
            prevTail=current
            kTrack=0
            next=null
            prev=null
            while(current&&kTrack!=k)
            {
                kTrack++;
                next=current->next;
                current->next=prev;
                prev=current;
                current=next;
            }
            if(prevTail==head)
                newhead=prev
            if(prevListTail)
                prevListTail->next=prev
            prevListTail=prevTail
        */
        ListNode current=head;
        ListNode prevListTail=null;
        ListNode newHead=null;
        ListNode temp=head;
        int numNodes=0;
        while(temp!=null)
        {
            numNodes++;
            temp=temp.next;
        }
        int numTurns=numNodes/k;
        while(current!=null&&numTurns!=0){
            numTurns--;
            ListNode prevTail=current;
            int kTrack=0;
            ListNode next=null;
            ListNode prev=null;
            while(current!=null&&kTrack!=k){
                kTrack++;
                next=current.next;
                current.next=prev;
                prev=current;
                current=next;
            }
            if(prevTail==head)
            {
                newHead=prev;
            }
            if(prevListTail!=null)
                prevListTail.next=prev;
            prevListTail=prevTail;
        }
        prevListTail.next=current;
        return newHead;
    }
}