//https://leetcode.com/problems/next-permutation/

class Solution {
    public void nextPermutation(int[] nums) {
        
        
        // new no> original no, next greater no
        // find rightmost peak 
        // if there is any element to right of peak which is lesser than previous element, swap these
        // if not swapped in previous step, swap peak with previous
        //sort elements after new previous
        
        int l =nums.length;
        int i=1;
        int peak=-1;
        if(l==1){
            return;
        }
        
        while(i<l){
            if(nums[i]>nums[i-1]){
                peak=i;
            }
            i++;
        }
        
        if(peak==-1){
            Arrays.sort(nums);
            return;
        }
        
        int prev=nums[peak-1];
        int j=peak;
        i=peak;
        while(j<nums.length){
            if(nums[j]>prev&&nums[j]<nums[i]){
                i=j;
            }
            j++;
        }
       
        swap(nums,peak-1,i);
           
        Arrays.sort(nums,peak,nums.length);
        
    }
    
    public void swap(int[] nums,int i, int j){
        int tmp= nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
