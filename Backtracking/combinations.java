//https://leetcode.com/problems/combinations/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> list = new ArrayList();
        
        backtrack(list,new ArrayList(),n, k, 1);
        return list;
    }
    
    public void backtrack(List<List<Integer>>  list, List<Integer> subList, int n, int k, int start){
        if(subList.size()==k){
            list.add(new ArrayList(subList));
            return;
        }        
        
        for( int i=start;i<=n;i++){
            subList.add(i);
                 backtrack(list,subList,n, k, i+1);
            subList.remove(subList.size()-1);
                
        }
    }
    
}
