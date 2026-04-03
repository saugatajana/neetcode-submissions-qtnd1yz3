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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp = dummy;
        while(temp!=null && n!=0) {
            temp = temp.next;
            n--;
        }
        ListNode temp1 = dummy;
        while(temp!=null && temp.next!=null) {
            temp1 = temp1.next;
            temp = temp.next;
        }
        temp1.next = temp1.next.next;
        return dummy.next;
    }
}
