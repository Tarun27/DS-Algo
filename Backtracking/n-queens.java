//https://leetcode.com/problems/n-queens

class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        Set<Integer> posDiag = new HashSet();
        Set<Integer> negDiag= new HashSet();
        List<List<String>> list = new ArrayList();
        char board[][] = new char[n][n]; 
        boolean col[]=new boolean[n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }        
        }
        
        permute(list,posDiag,negDiag,0,n,board,col);
        
        return list;
        
    }
    
    public void  permute( List<List<String>> list, Set<Integer> posDiag,Set<Integer> negDiag,int row, int n,  char board[][], boolean[] col){
        if(row==n){
            List<String> subList=new ArrayList<>();
            for(int i=0;i<n;i++){
                subList.add(String.valueOf(board[i]));
            }
            list.add(subList);
                    
        }
        
        for(int c=0;c<n;c++){
            if(col[c]||posDiag.contains(row+c)||negDiag.contains(row-c)){

            }else{
            
            col[c]=true;
            posDiag.add(row+c);
            negDiag.add(row-c);
            board[row][c]='Q';
     
            permute(list,posDiag,negDiag,row+1,n,board,col);
            
            col[c]=false;
            posDiag.remove(row+c);
            negDiag.remove(row-c);
            board[row][c]='.';

            }
        }
        
    }
}
