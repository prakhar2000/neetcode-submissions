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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null ) return null;

        ListNode temp=head;
        int size=0;

        while(temp!=null){
            temp=temp.next;
            size++;
        
        }
        if (size == n) {
            return head.next;
        }
        temp=head;
        int len=size-n;

        while(len-1!=0){
            len--;
            temp=temp.next;

        }
        ListNode toRemove= temp.next;
        temp.next= toRemove.next;
        toRemove.next= null;

        return head;

    }
}
