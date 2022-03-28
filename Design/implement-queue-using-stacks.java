//https://leetcode.com/problems/implement-queue-using-stacks/

class MyQueue {

    Stack<Integer> q ;
    Stack<Integer> stk ;
    
    public MyQueue() {
    q = new Stack();
    stk = new Stack();
    }
    
    public void push(int x) {
        stk.push(x);        
    }
    
    public int pop() {
        this.empty();
        return q.pop();
        
    }
    
    public int peek() {
        this.empty();
        return q.peek();
    }
    
    public boolean empty() {
           if(q.empty()){
        
        while(!stk.empty()){
            q.push(stk.pop());
        }
        }
       return (q.empty()&&stk.empty())?true:false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
