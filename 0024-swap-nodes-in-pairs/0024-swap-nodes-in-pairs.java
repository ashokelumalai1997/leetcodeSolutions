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
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode newN = head.next;
		
		ListNode current = head;
        ListNode prev = null;
		while(current != null && current.next != null) {
            if(prev != null) prev.next = current.next;
			ListNode temp = current.next.next;
			current.next.next = current;
			current.next = temp;
                        prev = current;
			current = current.next;

            if(current != null)
            System.out.println(current.val);
}

return newN;
}
}


// 1,2,3,4

            
    //   2 ->     1 ->       3        <-      4


    //                       c                                  t