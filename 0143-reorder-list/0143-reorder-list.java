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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;// break into two halves

        ListNode prev = null;
        while(second!=null ){
            ListNode nextTemp = second.next;
            second.next = prev;
            prev = second;
            second = nextTemp;
        }
        ListNode first = head;
        ListNode secondHalf = prev;

        while(secondHalf!=null){
            ListNode tmp1 =first.next;
            ListNode tmp2 = secondHalf.next;

            first.next = secondHalf;
            secondHalf.next = tmp1;

            first = tmp1;
            secondHalf = tmp2;
        }


    }
}