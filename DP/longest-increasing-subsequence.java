//https://leetcode.com/problems/longest-increasing-subsequence/




// O(n2) square solution
class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int lis=1;
        int memo[] = new int[nums.length];
        memo[0]=1;
        for(int i=0;i<nums.length;i++){
        
     lis = Math.max(lis,calcLis(i,nums,memo));
         
        }   
        
        return lis;
    }

    int calcLis(int i,int[] nums, int memo[]){
        
        if(i==0){
            return 1;
        }
    
      int  maxLis=1;
        
        for(int j=0;j<i;j++){
            
            if(nums[i]>nums[j]){
            maxLis = Math.max(maxLis,memo[j]+1);
            }
        }
        memo[i]=maxLis;
        return maxLis;
    }
    
}





// recursive solution


class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int lis=1;
        for(int i=0;i<nums.length;i++){
        
     lis = Math.max(lis,calcLis(i,nums));
         
        }   
        
        return lis;
    }

    int calcLis(int i,int[] nums){
        
        if(i==0){
            return 1;
        }
    
      int  maxLis=1;
        
        for(int j=0;j<i;j++){
            
            if(nums[i]>nums[j]){
            maxLis = Math.max(maxLis,calcLis(j,nums)+1);
            }
        }
        return maxLis;
    }
    
}

