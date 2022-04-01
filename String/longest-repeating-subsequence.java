//https://www.geeksforgeeks.org/longest-repeating-subsequence/

public class Solution {
    public int lrs(String text) {

        int memo[][] = new int[text.length()+1][text.length()+1];
    
        for(int i =1;i<=text.length();i++){
        
        for(int j =1;j<=text.length();j++){
        if(text.charAt(i-1)==text.charAt(j-1)&&i!=j){
            memo[i][j]=memo[i-1][j-1]+1;
        }else{
            memo[i][j]= Math.max(memo[i-1][j],memo[i][j-1]);
        }
        
            // System.out.print(memo[i][j]+"  ");
            
        }
           //  System.out.println();
        }
        
        
            return memo[text.length()][text.length()];

    }
}
