//https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    int maxLength=0;
      int startIndex=0;  
    public String longestPalindrome(String s) {  
        
      if(s.length()<2){
          return s;
      }
            
      for(int i=0;i<s.length()-1;i++){
          checkPalindrome(s,i,i);
         checkPalindrome(s,i,i+1);

      }  
      return s.substring(startIndex,startIndex+maxLength);  
    }
    
    public void checkPalindrome(String s,int left, int right){

        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        
        if(right-left-1>maxLength){
                maxLength=right-left-1;
                startIndex=left+1;
        }
        
    }
    
    
}
