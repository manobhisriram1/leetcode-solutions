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
    public ListNode removeElements(ListNode head, int val) {
        
    if(head==null) return head;
    ListNode prev = null , current = head;
    while(current!=null){
        if(current.val==val){
            if(prev==null)head=current.next;
            else prev.next =current.next;
        }
        else 
        prev = current;
        current = current.next;

        }
        return head;
    }

    }
