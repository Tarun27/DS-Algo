//https://leetcode.com/problems/subsets-ii/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
   List<List<Integer>> list = new LinkedList();        
                if(nums == null || nums.length == 0){return list;}
        
        Arrays.sort(nums);
        
        dfs(list,new ArrayList<>(),nums,0);
       
        return list;
        
    }
    
    public void dfs( List<List<Integer>> list,List<Integer> subList, int[] nums, int i){
                       

        if(i>=nums.length){
            list.add( new ArrayList<>(subList));
            return;
        }

                            
                             // include nums[i]
        subList.add(nums[i]);
        dfs(list,subList,nums,i+1);
                subList.remove(subList.size()-1);
        
        // not include nums[i]
                while(i+1<nums.length&&nums[i]==nums[i+1]){
                            i++;
                        }
        
        dfs(list,subList,nums,i+1);      
                        

     
        
        
    }
    
}
