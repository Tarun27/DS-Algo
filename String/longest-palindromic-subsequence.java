//https://leetcode.com/problems/longest-palindromic-subsequence
// similar ques; https://www.youtube.com/watch?v=lDYIvtBVmgo
class Solution {
    public int longestPalindromeSubseq(String s) {
        int l = s.length();

        Integer t[][] = new Integer[l][l];      
        return  lpsBU(s);

    
    
    }

  public int lpsBU(String s){
        char[] str = s.toCharArray();
        int[][] table = new int[str.length][str.length];
        
        for(int i=0; i<str.length; i++) {
            table[i][i] = 1; // Base case
        }


        for(int winSize=2; winSize<=str.length; winSize++) {
            for (int startIndex=0; startIndex<=str.length-winSize; startIndex++) {
                int endIndex = startIndex+winSize-1;
                if(str[startIndex] == str[endIndex]) {
                    table[startIndex][endIndex] = 2 + table[startIndex+1][endIndex-1];
                } else {
                    table[startIndex][endIndex] = Math.max(table[startIndex+1][endIndex],table[startIndex][endIndex-1]);
                }
            }
        }
        return table[0][str.length-1];

  }

//top down
    public int lpsTD(String s, int i, int j, Integer t[][]){
        if(i>j)return 0;
        if(i==j) return 1;
        if(t[i][j]!=null)return t[i][j];
        if(s.charAt(i)==s.charAt(j)) return 2+ lps(s,i+1,j-1);
        else{
            return Math.max(lps(s,i+1,j),lps(s,i,j-1));
        }


    }  



    public int lps(String s, int i, int j){
        if(i>j)return 0;
        if(i==j) return 1;
        if(s.charAt(i)==s.charAt(j)) return 2+ lps(s,i+1,j-1);
        else{
            return Math.max(lps(s,i+1,j),lps(s,i,j-1));
        }


    }
}
