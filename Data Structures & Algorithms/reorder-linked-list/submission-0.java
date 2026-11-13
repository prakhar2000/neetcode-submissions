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
        if(head== null || head.next==null)return;
        List<ListNode> nodes= new ArrayList<>();
        ListNode temp= head;

        while(temp!=null){
            nodes.add(temp);
            temp=temp.next;

        }

        int l= 0;
        int r= nodes.size()-1;

        while(l<r){
            nodes.get(l).next= nodes.get(r);
            l++;

            if(l==r)break;

            nodes.get(r).next=nodes.get(l);
            r--;
        }

        nodes.get(l).next=null;
    }
}
