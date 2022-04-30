https://leetcode.com/problems/evaluate-division/

class Solution {
   
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String,Map<String,Double>> map = new HashMap();
        
        double[] result= new double[queries.size()];
        
        
        buildMap(equations,values,map);
        
        query(queries,map,result);
    
    return result;    
        
    }
    
    public void buildMap(List<List<String>> equations, double[] values,Map<String,Map<String,Double>> map ){
        
        for(int i=0;i<values.length;i++){
            
            String start=equations.get(i).get(0);
            String end=equations.get(i).get(1);
            
            map.putIfAbsent(start,new HashMap());
            map.putIfAbsent(end,new HashMap());
            
            map.get(start).put(end,values[i]);
            map.get(end).put(start,1.0/values[i]);
        }
        
    }
    
    public void query(List<List<String>> queries, Map<String,Map<String,Double>> map, double[] result){
        
        for(int i=0;i<queries.size();i++){
            
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            
            if(map.containsKey(start)&&map.containsKey(end)){
               result[i]= dfs(map,start,end,new HashSet());
            }else{
                result[i]=-1;
            }
            
        
    }

    }

    public double dfs(Map<String,Map<String,Double>> map, String start,String end, HashSet<String> visited){
        
        if(map.get(start).containsKey(end)){
            return map.get(start).get(end);
        }
        visited.add(start);
        for(String key: map.get(start).keySet()){
            if(!visited.contains(key)){
                double res=dfs(map,key,end,visited);
                if(res!=-1.0){
                return res*map.get(start).get(key);
                }
            }
        }
        return -1;
    }
    
}
