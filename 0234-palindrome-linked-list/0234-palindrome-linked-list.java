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
    public boolean isPalindrome(ListNode head) {


        //create a deepcopy of the list first and then reverse it:

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode curr = head;

        while(curr != null){
            tail.next = new ListNode(curr.val);
            tail = tail.next;
            curr = curr.next;
        }

        //reverse the list first and then traverse the original and the reverse at once and check if the values are the same;
        ListNode prev = null;
        ListNode copyHead = dummy.next;

        while(copyHead != null){
            ListNode newNode = copyHead.next;
            copyHead.next = prev;
            prev = copyHead;
            copyHead = newNode;
        }

        //prev is the head of the new reversed list;

        while(head != null){
            if(head.val != prev.val){
                return false;
            }
            head = head.next;
            prev = prev.next;
        }

        return true;
    }
}