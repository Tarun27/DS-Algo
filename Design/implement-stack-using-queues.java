
//https://leetcode.com/problems/implement-stack-using-queues/

class MyStack {
    
    Queue q;

    public MyStack() {
        q= new LinkedList();
    }
    
    public void push(int x) {
        q.offer(x);   
        int size = q.size();
        while(size>1){
            q.offer(q.poll());
            size--;
        }
    }
    
    public int pop() {
        return (int)q.poll();
    }
    
    public int top() {
        return (int)q.peek();
    }
    
    public boolean empty() {
        
        return q.isEmpty()?true:false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
