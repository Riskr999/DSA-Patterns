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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int length = 0;

        while(curr!=null && k>length){
            curr = curr.next;
            length++;
        }
        if(length == k){
            ListNode prev = null;
            ListNode nextTemp = null;
            curr = head;
            for(int i =0;i<k;i++){
                nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            head.next = reverseKGroup(curr,k);
            return prev;

        }




        return head;

    }
}