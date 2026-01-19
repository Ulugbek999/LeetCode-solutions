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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        

        ListNode dummy = new ListNode(0);
        dummy.next = list1;

        ListNode ref = dummy;

        for(int i = 0; i<a; i++){
            ref = ref.next;
        }

        ListNode afterb = list1;

        for(int i = 0; i<=b; i++){
            afterb = afterb.next;
        }

        ref.next = list2;
        while(ref.next != null){
            ref = ref.next;
        }

        ref.next = afterb;


        return dummy.next;


    }
}