//https://leetcode.com/problems/n-queens-ii/

class Solution {
    public int totalNQueens(int n) {
        boolean d1[] = new boolean[2*n];
        boolean d2[]= new boolean[2*n];
        boolean col[]=new boolean[n];
        int count[]=new int[1];
        
        backtrack(d1,d2,col,n,0,count);
        return count[0];
    }
    
    public void backtrack( boolean d1[], boolean d2[], boolean col[],int row,int n,int[] count){
        if(row==n){count[0]++;}
        
        for(int i=0;i<n;i++){
            if(col[i]||d1[row+i]||d2[row-i]){
            }else{
                col[i]=true;
                d1[row+i]=true;
                d2[row-i+n]=true;
                
                backtrack(d1,d2,col,row+1,n,count);
                
                col[i]=false;
                d1[row+i]=false;
                d2[row-i+n]=false;
            }
        }
    } 
}
