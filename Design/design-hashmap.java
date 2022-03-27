https://leetcode.com/problems/design-hashmap/

class MyHashMap {
    
    ListNode[]  hmp ; 
    int size = 1000000;
    int random= 927;
    
    public MyHashMap() {
           this.hmp = new ListNode[size]; 

    }
    
    public int hash(int key){
            return (int)((long)(key * random)%size);        
    }
    
    
    public void put(int key, int value) {
        
     int hashKey=hash(key);
        
        ListNode curr =hmp[hashKey];
        
        if(curr!=null){ 
          
           ListNode prev = curr;

          while(curr!=null){
              if(curr.key==key){
                  curr.val=value;
               return;
              }
              prev=curr;
              curr = curr.next;
          }
           prev.next = new ListNode(key,value,null);
        }else{
            hmp[hashKey]=new ListNode(key,value,null);;
        }
       
        
    }
    
    public int get(int key) {
        
      int  hashKey = hash(key);
        
        if(hmp[hashKey]!=null){
            
       ListNode list = hmp[hashKey];
      
            while(list!=null){
                if(list.key==key){
                    return list.val;
                }
                list=list.next;
            }
        
        }
        return -1;
    }
    
    public void remove(int key) {
        
       int   hashKey = hash(key);
        
           if(hmp[hashKey]!=null){
            
            ListNode head = hmp[hashKey];
            ListNode curr=head;
            while(curr!=null){
                if(curr.key==key){
                 hmp[hashKey] =  curr.remove(head,curr);
                    return;
                }
                 curr=curr.next;
            }
        
        }
    }
}

class ListNode {
    int key;
    int val;
    ListNode next;
    public ListNode(int key, int val, ListNode next) {
        this.key=key;
        this.val = val;
        this.next = next;
    }
    
    public ListNode remove(ListNode head, ListNode curr){
        
        ListNode prev = null;
        ListNode node =head;
        
        while(node!=curr){
            prev=node;
            node=node.next;
        }
        if(prev==null){
            return curr.next;
        }else{
            prev.next= curr.next;
        }
           return head;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
