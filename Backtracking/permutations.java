//https://leetcode.com/problems/permutations/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
         List<List<Integer>> list = new LinkedList();
        
        boolean[] visited = new boolean[nums.length];
        backtrack(list,nums,visited,new LinkedList());
        
        return list;
    }
    
    public void backtrack( List<List<Integer>> list,int[] nums, boolean[] visited, List<Integer> permutation ){
        
        if(permutation.size()==nums.length){
            list.add(new LinkedList<>(permutation));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                permutation.add(nums[i]);
                visited[i]=true;
                backtrack(list,nums,visited,permutation);
        
                visited[i]=false;
                permutation.remove(permutation.size()-1);
            }
        }
        
    }

// another way to do this


       private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!tempList.contains(nums[i])){
                    tempList.add(nums[i]);
                    backtrack(result, tempList, nums);
                    tempList.remove(tempList.size() - 1);
                    
                } // Skip duplicates
              
            }
        }
    }
    
}
