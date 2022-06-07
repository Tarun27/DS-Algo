https://leetcode.com/problems/subarray-sum-equals-k/

public class Solution {
    public int subarraySum(int[] nums, int k) {
        
        
        // currSum ==k
        // currSum-k = val
        // k= currSum-val; -> subarray starting from val = k, if we are getting val in multiple subarrays, then its count is added to the map
        // [1,-1,0,-1,0,1]    0
        
        int count = 0;
       Map<Integer,Integer> sum = new HashMap();
        
        sum.put(0,1);
        int currSum=0;
        
        for (int i = 0; i < nums.length; i++) {
                    
            currSum+=nums[i];
            
       
            
            if(sum.containsKey(currSum-k)){
                count+=sum.get(currSum-k);
                            
            }
            
            sum.put(currSum,sum.getOrDefault(currSum,0)+1);
            
        }
        return count;
    }
}

