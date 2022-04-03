//https://leetcode.com/problems/add-one-row-to-tree

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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        int height=1;
     
        if(depth==1){
            TreeNode node= new TreeNode(val,root,null);
            return node;
        }
        
        while(!q.isEmpty()){
            
            
          int  size=q.size();
            
             if(depth==height+1){
                 
                 System.out.println(depth+","+height);
            
                 while(size>0){
                     
                      TreeNode lt= new TreeNode(val); 
                     
                if(q.peek().left!=null){
                  
                 lt.left=q.peek().left;
                 
               }
                        q.peek().left  =lt;
                     
                     TreeNode rt=new TreeNode(val);
                     
                if(q.peek().right!=null){
                    
                         rt.right=q.peek().right;          
               }
                     q.peek().right = rt;
                     
                     size--;
                     q.poll();
                 }
                            
                break;
            }
            
            while(size>0){
            
            if(q.peek().left!=null){
                q.offer(q.peek().left);
            }
            if(q.peek().right!=null){
                q.offer(q.peek().right);
            }
               
            q.poll();
                
            size--;
            }
            height++;
            

            
        }
    
        return root;
    }
}
