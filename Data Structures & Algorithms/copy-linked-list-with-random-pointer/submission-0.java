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
        HashMap<Node, Node> hm = new HashMap<>();
        Node temp = head;
        Node ans = new Node(0);
        Node ansIt = ans;

        while (temp != null) {
            Node newNode = new Node(temp.val);

            hm.put(temp, newNode);
            ansIt.next = newNode;
            ansIt = ansIt.next;
            temp = temp.next;
        }
        temp = head;
        ansIt = ans.next;

        while (temp != null) {
            if (temp.random != null) {
                ansIt.random= hm.get(temp.random);
            }
            temp = temp.next;
            ansIt = ansIt.next;
        }
        return ans.next;
    }
}
