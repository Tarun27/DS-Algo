//https://leetcode.com/problems/coin-change-2/

class Solution {
    public int change(int amount, int[] coins) {
        
        if(amount==0){
            return 1;
        }
        
        int memo[]=new int[amount+1];
        
        for(int i =1;i<=coins.length;i++){
            for(int j=1;j<amount+1;j++){
                
                if(j>=coins[i-1]){
                    int rem=j-coins[i-1];
                    if(rem!=0){
                        memo[j]+=memo[rem];
                    }else{
                        memo[j]+=1;
                    }    
                }
                
            }
                
            }
            return memo[amount];
        }
    

        
    }

// using 2d memo - bottom up

/*class Solution {
    public int change(int amount, int[] coins) {
        
        if(amount==0){
            return 1;
        }
        
        int memo[][]=new int[coins.length+1][amount+1];
        
        for(int i =1;i<=coins.length;i++){
            for(int j=1;j<amount+1;j++){
                
                if(j>=coins[i-1]){
                    int rem=j-coins[i-1];
                    if(rem!=0){
                        memo[i][j]=memo[i][rem]+memo[i-1][j];
                    }else{
                        memo[i][j]=1+memo[i-1][j];
                    }    
                }else{
                    memo[i][j]=memo[i-1][j];
                }
                
            }
                
            }
            return memo[coins.length][amount];
        }
    

        
    }
*/

//recursive
/*
class Solution {
    public int change(int amount, int[] coins) {
        
        if(amount==0){
            return 1;
        }
        
      return   coinChange(amount,coins.length-1,coins);

        
    }
    
    public int coinChange(int amount,int n,int[] coins){
        if(n<0){
            return 0;
        }
        
        if(amount==0){
            return 1;
        }
        
        if(coins[n]>amount){
            return coinChange(amount,n-1,coins);
        }
        
    return coinChange(amount,n-1,coins)+coinChange(amount-coins[n],n,coins);
    }
}
*/

