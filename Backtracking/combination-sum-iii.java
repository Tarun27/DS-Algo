//https://leetcode.com/problems/combination-sum-iii/

class Solution {
        
    public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> list = new ArrayList<>();
    backtrack(list, new ArrayList<Integer>(), k, n, 1);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> subList, int k, int target, int start) {
    
    if(target<0){return;}
    if(target==0&&subList.size()==k){
       list.add(new ArrayList(subList)); 
    }
    
    for(int i =start;i<=9;i++){
        subList.add(i);
           backtrack(list, subList, k, target-i, i+1);
        subList.remove(subList.size()-1);
 
    }
    
}
   
}
