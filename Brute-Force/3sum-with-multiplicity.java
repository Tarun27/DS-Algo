//https://leetcode.com/problems/3sum-with-multiplicity
class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int mod=1000000007;
        int tuples=0;
 
        Arrays.sort(arr);
            
        for(int i=0;i<arr.length;i++){
           
                int start=i+1;
                int end=arr.length-1;
            
            while(end>start){
                
                
              if(arr[start]+arr[end]+arr[i]>target){
                  end--;
              }else if(arr[start]+arr[end]+arr[i]<target){
                  start++;
              }else if(arr[start]!=arr[end]){
                  int left=1;
                  int right=1;
                  while(start+1<end&&arr[start]==arr[start+1]){
                      start++;
                      left++;              
                  }
                  while(end-1>start&&arr[end]==arr[end-1]){
                      end--;
                      right++;              
                  }
               
                  tuples+=left*right;
                   tuples%=mod;
                  start++;
                  end--;
              }else{
                  //nc2
                tuples+=  ((end-start+1)*(end-start))/2;
                   tuples%=mod;
                  break;
              }
                
            
           
        }
        
        }
        
        
        return tuples;
    }
}
