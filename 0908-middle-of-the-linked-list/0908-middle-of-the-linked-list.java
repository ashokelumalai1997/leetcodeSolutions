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
// class Solution {
//     public ListNode middleNode(ListNode head) {
        
//     }
// }


class Solution {
	ListNode middleNode(ListNode head) {
		ListNode first = head;
		ListNode second = head;
		if(second == null) return second;
		if(second.next == null) return first;
		while(second != null) {
			if(second.next == null) return first;
			if(second.next.next == null) return first.next;
			first = first.next;
			second = second.next.next;
			
}

return null;
}
}
