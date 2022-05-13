
//https://leetcode.com/problems/permutations-ii/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
         List<List<Integer>> list = new LinkedList();
        boolean[] visited = new boolean[nums.length];
        
        Arrays.sort(nums);
        
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
                while(i+1<nums.length&&nums[i]==nums[i+1]){
               
                    i++;
                }
                permutation.remove(permutation.size()-1);
            }
        }
        
    }
}
