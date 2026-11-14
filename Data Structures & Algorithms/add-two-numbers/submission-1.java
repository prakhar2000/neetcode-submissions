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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode f = l1;
        ListNode s = l2;
        ListNode dummy = new ListNode(0);
        ListNode ansIt = dummy;
        int carry = 0;

        while (f != null || s != null) {
            int val1 = (f != null) ? f.val : 0;
            int val2 = (s != null) ? s.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            ListNode res = new ListNode(sum%10);
            ansIt.next = res;
            ansIt = ansIt.next;
            if (f != null) f = f.next;
            if (s != null) s = s.next;
        }

        if (carry == 1) {
            ListNode lastn = new ListNode(carry);
            ansIt.next = lastn;
            ansIt = ansIt.next;
        }
        return dummy.next;
    }
}
