//https://leetcode.com/problems/fizz-buzz/

class Solution {
    public List<String> fizzBuzz(int n) {
        
    List<String> list = new LinkedList();
        
    LinkedHashMap<Integer,String> hm= new LinkedHashMap();
        
      hm.put(3,"Fizz");
      hm.put(5,"Buzz");

        
        for(int i=1;i<=n;i++){
           list.add(calc(i,hm));     
        }
        return list;
    }
    
    public String calc(int i,Map<Integer,String> hm){
       
        String ans="";
        for(Integer key:hm.keySet()){
            if(i%key==0){
                ans+=hm.get(key);
            }              
        }
        
        if(ans.equals("")){
            ans+=Integer.valueOf(i);
        }
        return ans;
    }
}
