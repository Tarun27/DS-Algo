//https://leetcode.com/problems/132-pattern/

class Solution {
    public boolean find132pattern(int[] nums) {
     
        
        
        
        
      //  int first;
        int second=Integer.MIN_VALUE;
      //  int third;
        
            //132
        
        Stack<Integer> stk= new Stack();
        
        for(int i=nums.length-1;i>=0;i--){
          
           // first=nums[i];
            
            if(second>nums[i]){return true;}
            
            while(!stk.empty()&&nums[i]>stk.peek()){
                second = stk.pop();
                //third=nums[i];
            }
            stk.push(nums[i]);
            
        }
        return false;
    }
}

/*
    public boolean find132pattern(int[] nums) {
        TreeMap<Integer, Integer> tm = new TreeMap();
        for(int num: nums) {
            tm.put(num, tm.getOrDefault(num, 0) + 1);
        }
        
        int elementI = nums[0];
        remove(elementI, tm);
        
        for(int j = 1; j < nums.length; j++) {
            int elementJ = nums[j];
            remove(elementJ, tm);
            Integer elementK = tm.floorKey(elementJ-1);
            if(elementK != null && elementI < elementK) {
                return true;
            }
            elementI = Integer.min(elementI, elementJ);
        }
        return false;
    }

	private void remove(int num, TreeMap<Integer, Integer> tm) {
        tm.put(num, tm.get(num)-1);
        if(tm.get(num) == 0) {
            tm.remove(num);
        }
    }
*/
