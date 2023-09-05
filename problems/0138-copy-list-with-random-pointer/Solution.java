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
        if (head == null) {
            return null;
        }

        Node node = head;

        while (node != null) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;

            node = newNode.next;
        }

        node = head;
        while (node != null) {
            if(node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }  

        Node res = head.next;
        node = head;
        while (node != null) {
            Node next = node.next.next;

            if (next != null) {
                node.next.next = next.next;
            }
            node.next = next;
            node = next;
        }

        return res;
    }
}
