//https://leetcode.com/problems/range-sum-of-bst/

class Solution {
    

    
    public int rangeSumBST(TreeNode root, int low, int high) {
        
       return postorder(root,low,high);
      
    }
    
    public int postorder(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        int left=   postorder(root.left,low,high);
        int right=   postorder(root.right,low,high);
        int current=  root.val>=low&&root.val<=high?root.val:0;
        return current+left+right;
    }
       
}
