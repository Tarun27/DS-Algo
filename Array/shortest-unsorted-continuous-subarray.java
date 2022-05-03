//https://leetcode.com/problems/shortest-unsorted-continuous-subarray

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int n= nums.length, start=-1, end=-1, prevLow=0,prevHigh=n-1;
        
        for(int i=1;i<n;i++){
            if(nums[i]<nums[prevLow]){
           end=i;     
            }else{prevLow=i;}
        }
       
        
          for(int i=n-2;i>=0;i--){
            if(nums[i]>nums[prevHigh]){
           start=i;     
            }else{prevHigh=i;}
        }
       
        
        return start!=-1&&end!=-1?end-start+1:0;
    }
    
    
}
