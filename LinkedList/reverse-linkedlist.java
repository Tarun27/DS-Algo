// https://leetcode.com/problems/reverse-linked-list/



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
 
 // iterative solution 
 
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head==null||head.next==null){
            return head;
        }
        
        ListNode node = null;
        ListNode prev=null;
        
        while(head!=null){
            node = head.next;
            head.next=prev;
            prev=head;
            head =node;
        }
        
        return prev;
        
        
        /* recursive solution
        
          if(head==null||head.next==null){
            return head;
        }
        
        ListNode node= reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return node;
        
        */
        
        
        
    }
}



