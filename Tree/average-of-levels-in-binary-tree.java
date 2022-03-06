//https://leetcode.com/problems/average-of-levels-in-binary-tree/

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new LinkedList<Double>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        if(root==null){
            return list;
        }
        
        q.offer(root);
        
        while(!q.isEmpty()){
            int len=q.size();
            List<Integer> subList=new LinkedList<Integer>();
           Double avg=0.0;
            for(int i=0;i<len;i++){
         
              
                if(q.peek().left!=null){
                    q.offer(q.peek().left);
                }
                
                if(q.peek().right!=null){
                    q.offer(q.peek().right);
                }
                   avg+=q.poll().val;
           } 
            list.add(avg/len);
        }
        
        return list;
    }
}
