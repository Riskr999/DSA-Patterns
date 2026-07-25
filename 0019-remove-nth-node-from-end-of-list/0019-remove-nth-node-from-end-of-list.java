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
    public ListNode get(ListNode head,int index){
        ListNode node = head;
        
        for(int i = 0;i<index;i++){
        node = node.next;
        }
        return node;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
                return null;
        }
        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            temp = temp.next;
            len++;
        }
        
        if(n==len) return head.next;
        ListNode prev = get(head,len-n-1);
        prev.next = prev.next.next;
        return head;


        
    }
}