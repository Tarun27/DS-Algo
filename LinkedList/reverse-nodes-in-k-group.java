//https://leetcode.com/problems/reverse-nodes-in-k-group/

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
    public ListNode reverseKGroup(ListNode head, int k) {
   
        if(head==null){
            return head;
        }
        
        int n=0;
        ListNode tmp=head;
        
        while(tmp!=null&&n<k){
            tmp=tmp.next;
            n++;
        }
        
        if(n<k){
            return head;
        }
        
        ListNode curr =head;
        ListNode nxt  = null;
        ListNode prev = null;
        
        int count=0;
        
        while(curr!=null&&count<k){
            nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;    
            count++;
        }
        
        
            head.next=reverseKGroup(nxt,k);
             
        
        return prev;
        
        
    }
}
