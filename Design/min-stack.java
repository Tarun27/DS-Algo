//https://leetcode.com/problems/min-stack/

class MinStack {
    
    ListNode top;

    public MinStack() {
        
    }
    
    public void push(int val) {
        ListNode node = new ListNode(val,null);
        if(top==null){
            top =node;
            node.min=val;
        }else{
            
            node.min = val<top.min?val:top.min;
            node.next=top;
            top=node;
        }
        //System.out.println(node.val+" "+node.min);
        
    }
    
    public void pop() {
        
        top= top!=null?top.next:top;
    }
    
    public int top() {
    
        return top!=null?top.val:0;
    
    }
    
    public int getMin() {
        
        
        return top!=null?top.min:0;
    }
}


class ListNode {
    int val;
    int min;
    ListNode next;
    public ListNode( int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
    

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
