//https://leetcode.com/problems/container-with-most-water
class Solution {
    public int maxArea(int[] height) {
        
        int start = 0;
        int end=height.length-1;
        int max=0;
        while(end>start){
            int area = (end-start)*(Math.min(height[end],height[start]));
            
            if(area>max){
                max=area;
            }
            
            if(height[end]>height[start]){                
            start++;
            }else{
            end--;
            }
        }
        return max;
    }
}
