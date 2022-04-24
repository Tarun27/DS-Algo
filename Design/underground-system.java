//https://leetcode.com/problems/design-underground-system/

class UndergroundSystem {
    
    Map<Integer,Pair<String,Integer>> checkIn;
    Map<Pair<String,String>,Pair<Integer,Double>> time; // station1,station2-> count,avgTime
    

    public UndergroundSystem() {
        checkIn = new HashMap();
        time = new HashMap();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Pair<String,Integer> pair= new Pair<String,Integer>(stationName,t);
        checkIn.put(id,pair);
    }
    
    public void checkOut(int id, String stationName, int t) {
         Pair<String,Integer> start= checkIn.get(id);
         Pair<String,String> stations= new Pair<String,String>(start.getKey(),stationName);
         Pair<Integer,Double> avg =  time.get(stations);
         if(avg==null){
            avg = new Pair<Integer,Double>(1,(double)t-start.getValue());   
            time.put(stations,avg);

         }else{
             int key = avg.getKey();
             Double value= avg.getValue();
             value = key*value+(t-start.getValue());
             double avgTime= value/(key+1);
            Pair<Integer,Double> newAvg= new Pair<Integer,Double>(key+1,avgTime);
             time.put(stations,newAvg);
         }
        checkIn.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
     Pair<String,String> stations= new Pair<String,String>(startStation,endStation);
    return time.get(stations).getValue(); 

    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
