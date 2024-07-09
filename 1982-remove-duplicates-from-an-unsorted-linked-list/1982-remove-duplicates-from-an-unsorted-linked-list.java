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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        ListNode temp = head;
        while(temp != null) {
            numbers.putIfAbsent(temp.val, 0);
            numbers.put(temp.val, numbers.get(temp.val)+1);
            temp = temp.next;
        }
        while(head != null && numbers.get(head.val) > 1) {
            head = head.next;
        }
        if(head == null) return null;
        ListNode prev = head;
        ListNode current = head.next;
        if(current == null) return head;
        ListNode next = current.next;
        while(current != null) {
            if(numbers.get(current.val) > 1) {
                prev.next = current.next;
                current = current.next;
            } else {
                prev = current;
                current = current.next;
            }
        }
        // if(numbers.get(current.val) > 1) prev.next = next;
        return head;
    }
}