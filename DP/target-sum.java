//https://leetcode.com/problems/target-sum/


/*
bottom up knapsack
 p-> +ve numbers
 N-> negative numbers
                 sum(P) - sum(N) = target
sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
                       2 * sum(P) = target + sum(nums)
*/
class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        
        if((total+target)%2!=0||target>total||target<-total){
           return 0; 
        }
    
       int newTarget = (total+target)>>>1;
        
        int[] memo = new int[newTarget+1];
        
        memo[0]=1;
        
    //    System.out.println(newTarget);
        
        for(int i: nums){
        
            for(int j=memo.length-1;j>=i;j--){
            
                memo[j]+=memo[j-i] ;
            
            }
        
        }
        
        
        return memo[newTarget];
       
    }
    

}


//memo + recursion

class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        //-sum --> 0 --> +sum  
        int[][] memo = new int[nums.length][2 * total + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        
        return calculate(nums,target,0,0,memo,total);
       
    }
    
    public int calculate(int[] nums,int target,int sum, int i, int memo[][], int total){
        
        if(i==nums.length){
        
        if(sum==target){
            return 1;
        }
            return 0;
        }else{
            
            if (memo[i][sum + total] != Integer.MIN_VALUE) {
                return memo[i][sum + total];
            }
      
   memo[i][sum+total]= calculate(nums,target,sum+nums[i],i+1,memo,total) +calculate(nums,target,sum-nums[i],i+1,memo,total);
            return   memo[i][sum+total];
        }
    }
}

//recursive solution
class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        
        return calculate(nums,target,0,0);
       
    }
    
    public int calculate(int[] nums,int target,int sum, int i){
        
        if(i==nums.length){
        
        if(sum==target){
            return 1;
        }
            return 0;
        }else{
      
   return calculate(nums,target,sum+nums[i],i+1) +calculate(nums,target,sum-nums[i],i+1);
        }
    }
}
