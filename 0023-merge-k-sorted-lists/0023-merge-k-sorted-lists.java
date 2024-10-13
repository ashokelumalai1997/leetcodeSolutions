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

class CustomComparator implements Comparator<ListNode> {
    public int compare(ListNode a, ListNode b) {
        return a.val - b.val;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new CustomComparator());
        for(ListNode l : lists) {
            if(l != null) pq.offer(l);
        }

        ListNode res = null;
        ListNode temp = res;

        while(!pq.isEmpty()) {
            ListNode current = pq.poll();
            if(temp == null) {
                res = current;
                temp = current;
            } else {
                temp.next = current;
                temp = temp.next;
            }
            if(current.next != null) pq.offer(current.next);
        }
        return res;
    }
}