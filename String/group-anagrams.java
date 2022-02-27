//https://leetcode.com/problems/group-anagrams/

class Solution {
    
  // sorting solution 
       
        Map<String, List<String>> mp= new HashMap();
        
        for(String s: strs){
            
            // char[] arr = s.toCharArray();
            // Arrays.sort(arr); 
            
            //sorting alternative
             
           char[] arr = new char[26];
            for(int i = 0;i<s.length();i++){
                arr[s.charAt(i) - 'a']++;
            }
            String key = String.valueOf(arr);
                
            if(!mp.containsKey(key)){
                mp.put(key,new LinkedList());
            }
            
            mp.get(key).add(s);
            
            
        }
        
         return new LinkedList<>(mp.values());
       
    
  
  
  /*
  brute force solution
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> grpA  = new LinkedList();
        boolean flag[] = new boolean[strs.length];
        
        
        for(int  i =0;i<strs.length;i++){
            
            if(!flag[i]){
            
            List<String> ana = new LinkedList();
            ana.add(strs[i]);
            
            for(int j =i+1;j<strs.length;j++){
                
               if(!flag[j] && isAnagram(strs[i],strs[j]) ){
                   ana.add(strs[j]);
                   flag[j]=true;
               }
            }
            
            grpA.add(ana);
            
            }
            
        }
        
        return grpA;
        
    }
    
 public boolean isAnagram(String s, String t) {
        
          char arr[] = new char[26];
          int l = s.length();
          int m = t.length();
    
        if(l!=m){
            return false;
        }
        
        for(int i=0;i<l;i++){
            arr[s.charAt(i)-97]++;
        }
        
    
        for(int i=0;i<m;i++){
            
            int x=t.charAt(i)-97;
            
            if(arr[x]==0){
             return false;    
            }
            
            arr[x]--;
            
        }
        
        return true;
        
    }
    
    */
}
