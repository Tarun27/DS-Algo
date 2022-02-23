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
 
 //https://leetcode.com/problems/middle-of-the-linked-list/
 
 
class Solution {
    public ListNode middleNode(ListNode head) {
        
        // solution 1
        
        ListNode node=head;
        int count=0;
        int  mid;
        
        if(node==null||node.next==null){
            return node;
        }
        
        while(node!=null){
            node=node.next;
            count++;
        }
        mid=count/2;
        
        while(mid!=0){
            mid--;
            head=head.next;
        }
        
        return head;
        
        /* solution 2
        
        ListNode fast=head;
        ListNode slow=head;
        

        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        }
        
        return slow;
        
        
        */
        
        
    }
}
