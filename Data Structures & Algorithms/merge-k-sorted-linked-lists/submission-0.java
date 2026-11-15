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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        Comparator<ListNode> comp = ((a, b) -> Integer.compare(a.val, b.val));

        PriorityQueue<ListNode> pq = new PriorityQueue<>(comp);
        ListNode ans= new ListNode(0);
        ListNode curr= ans;

        for (ListNode head : lists) {
            if(head!=null){
                pq.offer(head);
            }
        }

        while(!pq.isEmpty()){
            ListNode small= pq.poll();

            curr.next=small;
            curr=curr.next;

            if(small.next!=null){
                pq.offer(small.next);
            }


        }
        return ans.next;
    }
}
