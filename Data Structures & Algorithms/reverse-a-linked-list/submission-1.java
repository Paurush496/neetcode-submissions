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
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode curr = new ListNode(head.val, head.next);
        curr.next = null;
        ListNode nextNode = head.next;
        while (nextNode != null) {
            ListNode next = nextNode.next;
            curr = new ListNode(nextNode.val, curr);
            nextNode = next;
        }
        return curr;
    }
}
