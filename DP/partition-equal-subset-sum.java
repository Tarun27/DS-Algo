//https://leetcode.com/problems/partition-equal-subset-sum/

class Solution {
    public boolean canPartition(int[] nums) {
        
        int target = Arrays.stream(nums).sum();
        if(target%2!=0){
            return false;
        }
        
        target/=2;
        
         boolean memo[][]= new boolean[nums.length+1][target+1];
        
        for(int i =0;i<nums.length;i++){
            memo[i][0]=true;
        }
        
        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=target;j++){
                
                if(nums[i-1]<=j){
                    memo[i][j]=memo[i-1][j]||memo[i-1][j-nums[i-1]];
                }else{
                    memo[i][j]=memo[i-1][j];
                }
                
            }
        }
        
        return memo[nums.length][target];
        
    }
}
