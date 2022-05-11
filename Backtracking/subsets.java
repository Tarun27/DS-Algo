//https://leetcode.com/problems/subsets/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
          List<List<Integer>> list = new LinkedList();        
                if(nums == null || nums.length == 0){return list;}
        
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
        
        // not include nums[i]
        subList.remove(subList.size()-1);
        dfs(list,subList,nums,i+1);     
        
    }
}

/* iterative

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if(nums == null || nums.length == 0){
            return result;
        }
        int s = 0;
        for(int n:nums){
            s = result.size();
            for(int i = 0;i<s;i++){
                List<Integer> set = new ArrayList<>(result.get(i));
                set.add(n);
                result.add(set);
            }
        }
        return result;
    }
}
*/
