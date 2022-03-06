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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
         List<List<Integer>> list = new LinkedList();
        if(root==null){
            return list;
         }
        
        levelHelper(root,list,0);
        
        return list;
    }
    
    
    public void levelHelper(TreeNode node,List<List<Integer>> list, int lvl){
        
        if(list.size()==lvl){    
            list.add(0,new LinkedList<Integer>());
        }
        
      
        
        if(node.left!=null){
            levelHelper(node.left,list,lvl+1);
        }
        if(node.right!=null){
            levelHelper(node.right,list,lvl+1);
        }
        
          list.get(list.size()-lvl-1).add(node.val);
        
    }
    
   
        /* solution-2/DFS
        List<List<Integer>> list = new LinkedList();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        if(root==null){
            return list;
        }
        
        q.offer(root);
        
        while(!q.isEmpty()){
            
            int len = q.size();
            
            LinkedList<Integer> subList = new LinkedList<Integer>();
            
            while(len>0){
            subList.add(q.peek().val);
            if(q.peek().left!=null){
            q.offer(q.peek().left);
            }
             if(q.peek().right!=null){
            q.offer(q.peek().right);
            }
            q.poll();
            len--;
            }
                list.add(0,subList);   
        }
    
        return list;
        */
    }
}
