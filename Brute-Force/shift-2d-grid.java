//https://leetcode.com/problems/shift-2d-grid/

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        List<List<Integer>> list = new LinkedList();
        
        for(int i=0;i<k;i++){
            int right=grid[grid.length-1][grid[0].length-1];
            for(int p=0;p<grid.length;p++){
                for(int q=0;q<grid[0].length;q++){
                                  
                    int tmp = grid[p][q];
                    grid[p][q]=right;
                    right=tmp;             
                }
            }
        }
            
        for(int[] array:grid){
                        List<Integer> subList = new LinkedList();
            for(int i:array){
            subList.add(i);    
            }
            list.add(subList);
        }
        
        return list;
    }
}
