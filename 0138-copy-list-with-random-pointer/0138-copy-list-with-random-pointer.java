/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp1 = head;

        Map<Node,Node> map = new HashMap<>();

        while(temp1!=null){
            map.put(temp1,new Node(temp1.val));
            temp1=temp1.next;
        }

        Node temp2 = head;
        while(temp2!=null){
            if(temp2.next!=null){
                map.get(temp2).next = map.get(temp2.next);
            }
            if(temp2.random!=null){
                map.get(temp2).random = map.get(temp2.random);
            }
            temp2 = temp2.next;
        }
        return map.get(head);
    }
}