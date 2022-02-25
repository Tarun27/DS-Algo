//https://leetcode.com/problems/valid-anagram

class Solution {
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
}
