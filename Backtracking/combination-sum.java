
//https://leetcode.com/problems/combination-sum/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> list = new ArrayList();
        
        backtrack(list,candidates,new ArrayList(),target,0);
        return list;
        
    }
    
    public void  backtrack(List<List<Integer>> list, int[] candidates,List<Integer> subList,int target, int start){
       
        if(target<0){return;}
        if(target==0){
            list.add(new ArrayList(subList));
        }
        
        for(int i=start;i<candidates.length;i++){
                            subList.add(candidates[i]);
            backtrack(list,candidates,subList,target-candidates[i],i);
                subList.remove(subList.size()-1);
            
        }
        
    }
}
