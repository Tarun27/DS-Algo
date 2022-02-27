//https://leetcode.com/problems/is-subsequence/

class Solution {
    public boolean isSubsequence(String s, String t) {
      
        int j =0;
        int i=0;
      
 
        while(i<s.length()&&j<t.length()){
            
            while(s.charAt(i)!=t.charAt(j)){
            j++;
            if(j==t.length()){
                return false;
            }
            }
            if(j<t.length()&&s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }          
        }
     
        if(i==s.length()){
        return true;
        }
        
        return false;
        
  
    /* solution 2
    
            if(s.length()==0){
            return true;
        }
        if(s.length()>t.length()){
            return false;
        }
        
        while(j<t.length()){
            
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            
            if(i==s.length()){
                return true;
            }
            j++;
              
        }
    
        return false; 
    */
      
      /* sol3
      
             
        int id=-1;
     for(char c: s.toCharArray()){
         
         id= t.indexOf(c,id+1);
             if(id<0){
                 return false;
             }
     }   
        return true;
      
      */
    
    
    }
  
  
  
}
