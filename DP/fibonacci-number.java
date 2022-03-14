//https://leetcode.com/problems/fibonacci-number/

class Solution {
    public int fib(int n) {
        int memo[] = new int[n+1];
        return calcFib(memo,n);       
    }

    int calcFib(int[] memo,int n){
        if(n==0||n==1){
            return n;
        }
        
        if(memo[n]!=0){
            return memo[n];
        }
        
        memo[n]=calcFib(memo,n-1)+calcFib(memo,n-2);
        
        return memo[n];
    }
}
