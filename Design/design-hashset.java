//https://leetcode.com/problems/design-hashset/

class MyHashSet {
    
    ListNode hs;

    public MyHashSet() {
        
    }
    
    public void add(int key) {
        
        if(hs==null){
            hs = new ListNode(key,null);
        }else{
            
            if(!contains(key)){
                ListNode node = hs;
                
                while(node.next!=null){
                    node=node.next;
                }
                node.next=new ListNode(key,null);
            }
            
        }
        
        
    }
    
    public void remove(int key) {
           ListNode node = hs;
           ListNode prev = null;

            boolean exists= false;
        
        while(node!=null){
            if(node.val==key){
                exists=true;
                break;
            }
            prev=node;
            node=node.next;
        }
        
        if(exists){
        if(prev==null){
            hs=hs.next;
        }else{
        prev.next=prev.next.next;
        }
        }
    }
    
    public boolean contains(int key) {
        
        ListNode node = hs;
        while(node!=null){
            if(node.val==key){
                return true;
            }
            node=node.next;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val, ListNode next) {
        this.val=val;
        this.next = next;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
