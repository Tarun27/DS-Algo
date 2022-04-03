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

//recursive

/*
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
          if(depth==1){
            TreeNode node= new TreeNode(val,root,null);
            return node;
        }
        addRow(root,val,depth,1);
          
        return root;
    }
    
    public void addRow(TreeNode curr, int val,int depth, int lvl){

        if(curr==null){
            return;
        }
        
        if(depth==lvl+1){
            
         TreeNode   lft = curr.left;
         TreeNode   rt=curr.right;
            
            curr.left=new TreeNode(val,lft,null);
            curr.right=new TreeNode(val,null,rt);
            return ;
        }
        
        addRow(curr.left,val,depth,lvl+1);
        addRow(curr.right,val,depth,lvl+1);
    }
    
    
    
}
*/
