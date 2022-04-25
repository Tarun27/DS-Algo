//https://leetcode.com/problems/longest-common-subsequence/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int memo[][] = new int[text1.length()+1][text2.length()+1];
    
        for(int i =1;i<=text1.length();i++){
        
        for(int j =1;j<=text2.length();j++){
        if(text1.charAt(i-1)==text2.charAt(j-1)){
            memo[i][j]=memo[i-1][j-1]+1;
        }else{
            memo[i][j]= Math.max(memo[i-1][j],memo[i][j-1]);
        }
        
            // System.out.print(memo[i][j]+"  ");
            
        }
            // System.out.println();
        }
          getSequenceCharacters(memo,text1,text2);
        
            return memo[text1.length()][text2.length()];
    }
    
        
public void getSequenceCharacters(int[][] memo, String text1, String text2){
    StringBuilder sb = new StringBuilder();
    int i=text1.length(); 
    int j=text2.length();
    
    while(i>0&&j>0){ 
        
        if(memo[i][j]==memo[i-1][j-1]+1){
              i--;
              j--;
            sb.append(text1.charAt(i));
          
        }
         else if (memo[i][j] == memo[i-1][j]){
            i--;
        } else{
            j--;
      }
    }
    
    System.out.println(sb.reverse().toString());
    
}
    
}
