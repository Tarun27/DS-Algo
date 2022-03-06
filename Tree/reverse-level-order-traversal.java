//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

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
        
        List<List<Integer>> list = new LinkedList();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Stack<List<Integer>> stk = new Stack();
        
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
                stk.push(subList);    
        }
    
        while(!stk.isEmpty()){
            list.add(stk.pop());
        }
        return list;
    }
}
