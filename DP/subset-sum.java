
//https://www.interviewbit.com/problems/subset-sum-problem/

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {

        boolean memo[][]= new boolean[A.size()+1][B+1];

        for(int i=0;i<=A.size();i++){
            memo[i][0]=true;
        }

        for(int i=1;i<=A.size();i++){
            for(int j=1;j<=B;j++){
                if(A.get(i-1)<=j){
               
                       memo[i][j]=memo[i-1][j]||memo[i][j-A.get(i-1)];
                             
                }else{
                    memo[i][j]=memo[i-1][j];
                }
            }
        }

        if(memo[A.size()][B]){
            return 1;
        }
        return 0;
    }
}
