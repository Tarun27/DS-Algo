//https://leetcode.com/problems/insert-into-a-binary-search-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if(root==null){
            return new TreeNode(val);
        
        }
        
        
        if(root.val>val){
           root.left= insertIntoBST(root.left,val);
        }
        
        if(root.val<val){
            root.right=insertIntoBST(root.right,val);
        }
        
    
        return root;
        
    }
    
    /*
    class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode curr = root;
        TreeNode pre = null;
        while (curr != null) {
            pre = curr;
            if (val > curr.val) curr = curr.right;
            else curr = curr.left;
        }
        if (val > pre.val) {
            pre.right = new TreeNode(val);
        } else {
            pre.left = new TreeNode(val);
        }
        return root;
    }
}
    */
    
}
