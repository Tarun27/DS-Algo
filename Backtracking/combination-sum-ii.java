//https://leetcode.com/problems/combination-sum-ii/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> list = new ArrayList();
        Arrays.sort(candidates);
        
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
            backtrack(list,candidates,subList,target-candidates[i],i+1);
                subList.remove(subList.size()-1);
            while(i+1<candidates.length&&candidates[i]==candidates[i+1]){
                i++;
            }
            
        }
        
    }
}
