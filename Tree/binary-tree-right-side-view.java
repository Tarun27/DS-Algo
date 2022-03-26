//https://leetcode.com/problems/binary-tree-right-side-view/

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

//iterative

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> right= new LinkedList();
        
        if(root==null){
            return right;
        }
        
        Queue<TreeNode> que = new LinkedList();
        
        que.offer(root);
        
        while(!que.isEmpty()){
            
            int lvlLength = que.size();
            
            while(lvlLength>0){
                lvlLength--;
                
                if(que.peek().left!=null){
                    que.offer(que.peek().left);    
                }
                
                if(que.peek().right!=null){
                    que.offer(que.peek().right);    
                }
                
                if(lvlLength==0){
                    right.add(que.peek().val);
                }
                que.poll();
                
            }
            
        }
        
       return right; 
    }
}


/*
//recursive
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result= new LinkedList();
        
        if(root!=null){
            result.add(root.val);
        }
      
        rightView(root,result,0);
        
       return result; 
    }
    
    public void rightView(TreeNode root, List<Integer> result, int lvl){
        
        if(root==null){
            return;
        }
        
        if(result.size()==lvl){
            result.add(root.val);
            
        }
        
        rightView(root.right,result,lvl+1);
        rightView(root.left,result,lvl+1);
        
    }
}


*/


