//https://leetcode.com/problems/target-sum/




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
