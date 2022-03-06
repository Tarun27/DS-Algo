//https://leetcode.com/problems/minimum-depth-of-binary-tree/

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
    public int minDepth(TreeNode root) {
        
        if(root==null){
            return 0;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int lvl=1;
        while(!q.isEmpty()){
            int l = q.size();
            
            while(l>0){
                l--;
                
                if(q.peek().left==null&&q.peek().right==null){
                    return lvl;
                }
                
                if(q.peek().left!=null){
                    q.offer(q.peek().left);
                }
                
                if(q.peek().right!=null){
                    q.offer(q.peek().right);
                                   }
                 q.poll();

                
            }
            lvl++;
            
        }
        return lvl;
        
    }
    /* DFS solution
    
       public static int minDepth(TreeNode root) {
	if (root == null)	return 0;
	if (root.left == null)	return minDepth(root.right) + 1;
	if (root.right == null) return minDepth(root.left) + 1;
	return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
}
    */
    
}
