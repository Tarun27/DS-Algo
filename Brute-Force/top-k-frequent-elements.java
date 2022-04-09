//https://leetcode.com/problems/top-k-frequent-elements/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
          if (k == nums.length) {
            return nums;
        }

        Map<Integer,Integer> map= new HashMap();
        
     for(int i:nums){
         map.put(i,map.getOrDefault(i,0)+1);
     }
       
        PriorityQueue<Map.Entry<Integer,Integer>> maxq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            maxq.offer(entry);
         
        }
        
        
        
        int[] arr= new int[k];
        for(int i=0;i<k;i++){
            Map.Entry<Integer, Integer> entry = maxq.poll();
            arr[i]=entry.getKey();
        }
            
        
        return arr;
    }
}

/*

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        List<Integer>[] bucket = new List[nums.length+1];
        for(int n:map.keySet()){
            int freq = map.get(n);
            if(bucket[freq]==null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(n);
        }
        
        int arr[]=new int[k];
        int j=0;
        k--;
        for(int i=bucket.length-1; i>0 && k>=0; --i){
            if(bucket[i]!=null){
           
                
                for(int m=0;m<bucket[i].size()&&k>=0;m++){
                    arr[k]=bucket[i].get(m);
                    k--;
                }
               
            }
        }
        
        return arr;
    }
}

*/

