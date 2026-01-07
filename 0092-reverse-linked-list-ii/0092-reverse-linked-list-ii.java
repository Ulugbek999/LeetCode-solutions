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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null || left == right) {
            return head;
        }

         // Dummy node to handle left == 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preLeftNode = dummy;
        int pos = 1;

        // Move to node BEFORE left position
        while (pos < left) {
            preLeftNode = preLeftNode.next;
            pos++;
        }

        ListNode leftNode = preLeftNode.next;
        ListNode rightNode = leftNode;

        // Move to right position
        while (pos < right) {
            rightNode = rightNode.next;
            pos++;
        }

        ListNode destination = rightNode.next;

        // Correct prev initialization
        ListNode prev = destination;
        ListNode curr = leftNode;

        // Reverse sublist
        while (curr != destination) {
            ListNode newNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newNode;
        }

        // Reconnect
        preLeftNode.next = prev;

        return dummy.next;
        
    }
}