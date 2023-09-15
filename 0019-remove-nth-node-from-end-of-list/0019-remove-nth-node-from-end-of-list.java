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
       ListNode temp = new ListNode(); 
       temp.next = head;
       ListNode fast = temp;
       ListNode slow = temp;
       
       // Move fast n+1 nodes ahead
       for (int i = 0; i < n + 1; i++) {
           if (fast == null) {
               // Handle the case where n is greater than or equal to the list length
               return head;
           }
           fast = fast.next;
       }
     
       while (fast != null) {
           fast = fast.next;
           slow = slow.next;
       }
       
       // Now slow is pointing to the node just before the one to be removed
       slow.next = slow.next.next;
       return temp.next; // Return the new head
    }
}
