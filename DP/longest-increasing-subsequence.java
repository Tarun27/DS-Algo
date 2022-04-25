//https://leetcode.com/problems/longest-increasing-subsequence/




// O(n2) square solution
class Solution {
    public int lengthOfLIS(int[] nums) {
    
        if(nums.length<=1){
            return 1;
        }
        
        int memo[]= new int[nums.length];
        int max=1;
        
        
        Arrays.fill(memo,1);
        
        for(int i=1;i<nums.length;i++){
            
            int j=0;
            
            while(i>j){
                if(nums[i]>nums[j]){
                memo[i]=Math.max(memo[i],memo[j]+1);
                }
                if(memo[i]>max){
                    max=memo[i];
                }
                j++;
                if(j>=nums.length){break;}
            }
            
        }
   return max;
    
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

