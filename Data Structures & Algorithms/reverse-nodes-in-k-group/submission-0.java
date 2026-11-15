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


    public void reverse(ListNode start, ListNode end){
        ListNode prev= null;
        ListNode curr= start;
        ListNode stop= end.next;

        while(curr!=stop){
            ListNode nextTemp= curr.next;
            curr.next= prev;
            prev= curr;
            curr= nextTemp;
        }



    }
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy= new ListNode(0);
        dummy.next=head;
        ListNode groupPrev= dummy;
    

        while(true){
            ListNode kth= groupPrev;

            int count =0;
            while(kth!=null && count<k){
                kth= kth.next;
                count++;
            }
            if(kth== null) break;

            ListNode groupStart= groupPrev.next;
            ListNode groupNext= kth.next;

            reverse(groupStart, kth);

            groupPrev.next=kth;
            groupStart.next= groupNext;

            groupPrev= groupStart;


        }
        return dummy.next;




        
    }
}
