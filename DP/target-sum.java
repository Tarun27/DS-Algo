//https://leetcode.com/problems/target-sum/






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
