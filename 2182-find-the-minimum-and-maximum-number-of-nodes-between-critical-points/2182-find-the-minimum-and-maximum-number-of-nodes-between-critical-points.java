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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int start = Integer.MAX_VALUE;
        int end = 1;
        int min = Integer.MAX_VALUE;
        ListNode traverser = head.next;
        int prev = head.val;
        int nodeID = 1;
        int prevID = -1;
        while(traverser.next != null) {
            Boolean localMinimaCondition = traverser.val < prev && 
                                                traverser.val < traverser.next.val;
            Boolean localMaximaCondition = traverser.val > prev && 
                                                traverser.val > traverser.next.val;
            if(localMinimaCondition || localMaximaCondition) {
                start = Math.min(start, nodeID);
                if(prevID != -1)
                    min = Math.min(min, nodeID - prevID);
                prevID = nodeID;
            }
            prev = traverser.val;
            traverser = traverser.next;
            nodeID++;
        }
        if(start == Integer.MAX_VALUE || min == Integer.MAX_VALUE) return new int[]{-1, -1};
        return new int[]{min, prevID - start};
    }
}