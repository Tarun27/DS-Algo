//https://leetcode.com/problems/longest-palindromic-subsequence

class Solution {
    public int longestPalindromeSubseq(String s) {
        int l = s.length();
        
        int memo[][]= new int[l][l];
        
        for(int i=0;i<l;i++){
            memo[i][i]=1;
        }
        
        for(int i=1;i<=l;i++){
            for(int j=0;j+i<l;j++){
                
                if(s.charAt(j)==s.charAt(j+i)){
                    memo[j][j+i]=memo[j+1][j+i-1]+2;
                }else{
                    memo[j][j+i]= Math.max(memo[j][j+i-1],memo[j+1][j+i]);
                }
            
            }
               
        }
        
        // for(int i=0;i<l;i++){
        //     for(int j=0;j<l;j++){
        //         System.out.print(memo[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return memo[0][l-1];
    }
}
