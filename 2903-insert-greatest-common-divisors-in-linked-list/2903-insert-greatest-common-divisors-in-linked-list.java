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
    private int getGCD(int a, int b)
    {
        if (a == 0)
            return b;
        return getGCD(b % a, a);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode headResult = head;
        if(headResult == null) return headResult;
        ListNode next = head.next;
        while(next != null) {
            int gcd = getGCD(head.val, next.val);
            ListNode newNode = new ListNode(gcd, next);
            head.next = newNode;
            head = next;
            next = head.next;
        }
        return headResult;
    }
}