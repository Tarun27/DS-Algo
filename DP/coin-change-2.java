//https://leetcode.com/problems/coin-change-2/
class Solution {
    public int change(int target, int[] nums) {
        
          int n = nums.length;
        int[][] memo= new int[n+1][target+1];
        
        for(int i=1;i<=n;i++){
            memo[i][0]=1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(nums[i-1]<=j){
                    memo[i][j]= memo[i-1][j]+memo[i][j-nums[i-1]];
                }else{
                    memo[i][j]=memo[i-1][j];
                }
            }
        }
        
        // for(int i=0;i<=n;i++){
        //     System.out.println();
        //     for(int j=0;j<=target;j++){
        //         System.out.print(memo[i][j]+" ");
        //     }
        // }
        
        return memo[n][target];


        
    }
    
}



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

