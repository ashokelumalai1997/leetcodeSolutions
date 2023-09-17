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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode list=null;
        if(list1.val>list2.val){
            list = list1;
            list1=list2;
            list2=list;
        }
        ListNode t = list1;
        while(t.next!=null){
            if(list2!=null&&t.next.val>list2.val){
                ListNode t2=list2;
                list2=list2.next;
                t2.next=t.next;
                t.next=t2;
            }
            t=t.next;
        }
        t.next=list2;
        return list1;

    }
}