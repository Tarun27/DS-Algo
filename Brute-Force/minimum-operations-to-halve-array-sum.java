//https://leetcode.com/problems/minimum-operations-to-halve-array-sum/

class Solution {
    public int halveArray(int[] nums) {
        
        double sum= 0;
        int ans=0;
        Queue<Double> q= new PriorityQueue<Double>(Collections.reverseOrder());
        double newSum=0;
        
        for(int i:nums){
            sum+=i;
            q.offer((double)i);
        }
        sum=sum/2;
        while(sum>newSum){
         double x=  q.poll();
            x/=2;
            newSum+=x;
            ans++;
            q.offer(x);
         
        }
        
        return ans;
    }
}
