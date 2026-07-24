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
        if(head == null || head.next == null) return head;

        ListNode DummyNode = new ListNode(0);
        DummyNode.next = head;

        ListNode prev = DummyNode;
        for(int i= 0; i<left-1;i++){
                prev = prev.next;
        }

        ListNode con = prev;
        ListNode tail = prev.next;

        ListNode curr = prev.next;
        ListNode subPrev = null;

        for(int i =0; i<right-left+1;i++){
            ListNode nextTemp = curr.next;
            curr.next = subPrev;
            subPrev = curr;
            curr = nextTemp;
        }
        con.next = subPrev;
        tail.next = curr;

        return DummyNode.next;
    }
}