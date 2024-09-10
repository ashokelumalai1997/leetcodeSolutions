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
    private int getGCD(int b, int a) {
        if(b == 0) return a;
        return getGCD(a%b, b);
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