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
    public ListNode modifiedList(int[] nums, ListNode head) {
        if(head == null) return null;
        ListNode tHead = head;
        Set<Integer> st = new HashSet<Integer>();
        for(int num : nums) st.add(num);
        while(tHead != null && st.contains(tHead.val)) {
            tHead = tHead.next;
        }
        head = tHead;
        if(tHead == null) return tHead;
        ListNode prev = tHead;
        ListNode next = prev.next;
        while(next != null) {
            if(st.contains(next.val)) {
                prev.next = next.next;
                next = prev.next;
            } else {
                prev = next;
                if(prev == null) break;
                next = prev.next;
            }
        }
        return tHead;
    }
}