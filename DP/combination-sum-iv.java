//https://leetcode.com/problems/combination-sum-iv/
//https://leetcode.com/problems/coin-change-2/

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] memo= new int[target+1];
        
       memo[0]=1;
        
        for(int i=1;i<=target;i++){
            for(int j=1;j<=n;j++){
                if(i>=nums[j-1]){
                    memo[i]+=memo[i-nums[j-1]];
               // System.out.println(memo[i]+" ,"+i+"  ");  
               // ex: input: 1,2,3 & target=4
                }
            }
        }
        
        return memo[target];
    }
}

/* backtracking solution

   public int combinationSum4(int[] nums, int target) {

        int count[]= new int[1];
        
        return count[0];
    }
    
    public void backtrack(int[] nums,int target,int[] count){
        
        if(target<0){return;}
        if(target==0){
            count[0]++;
        }
        
        for(int i=0;i<nums.length;i++){
            backtrack(nums,target-nums[i],count);
        }
        
    }
*/
