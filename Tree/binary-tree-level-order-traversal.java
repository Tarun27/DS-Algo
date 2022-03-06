//https://leetcode.com/problems/binary-tree-level-order-traversal/

// DFS solution by preorder 

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
  
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> list = new LinkedList();
  
        if(root==null){
            return list;
        }
        
    levelHelper(root,list,0);
    return list;
        
    }
    
    
    public void levelHelper(TreeNode node, List<List<Integer>> list,int lvl){
            
        if(list.size()==lvl){
            list.add(new LinkedList<Integer>());     
        }
        
  
            list.get(lvl).add(node.val);  
            if(node.left!=null){
                levelHelper(node.left,list,lvl+1);
            }
        
            if(node.right!=null){
                levelHelper(node.right,list,lvl+1);
            }
        
        
    }
}

