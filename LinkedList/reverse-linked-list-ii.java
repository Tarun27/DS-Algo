//https://leetcode.com/problems/reverse-linked-list-ii/

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(head ==null||head.next==null||left==right){
            return head;
        }
        
        ListNode node= head;
        ListNode start=null;
        int count=1;
      
        while(count!=left){
            count++;
            start= node;
            node=node.next;
        }
        
        ListNode prev=null;
        ListNode nxt=null;
        
        while(count!=right){
            count++;
            nxt=node.next;
            node.next=prev;
            prev=node;
            node=nxt;
            
        }
            nxt=node.next;
            node.next=prev;
        
        if(start!=null){
            prev=start.next;
            start.next=node;
            prev.next=nxt;
        }else{
            start = head;
            head = node;
            start.next=nxt;
        }
            
        
        
        return head;
    }
}
