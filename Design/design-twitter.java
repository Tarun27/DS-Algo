//https://leetcode.com/problems/design-twitter/

class Twitter {
    
    Stack<Pair<Integer,Integer>> tweet ;
    ArrayList<Integer>[] following;

    public Twitter() {
        
        tweet= new Stack();
        following = new ArrayList[501];   
        
        for(int i=1;i<501;i++){
            following[i]=new ArrayList<Integer>();
            following[i].add(i);
            
        }
    }
    
    public void postTweet(int userId, int tweetId) {
        
        Pair<Integer,Integer> pair= new Pair(userId,tweetId);
 
            tweet.push(pair);         
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        List<Integer> list = new ArrayList();
        Stack<Pair<Integer,Integer>> tmpStk= new Stack();
        
        if(following[userId]!=null){
        
           
            while(!tweet.isEmpty()&&list.size()!=10){
                Pair<Integer,Integer> pair = tweet.pop();
                tmpStk.push(pair);
                if(following[userId].contains(pair.getKey())){
                list.add(pair.getValue());
                }
            }
            
        }
        while(!tmpStk.isEmpty()){
            tweet.push(tmpStk.pop());
        }
    
        return list;
    }
    
    public void follow(int followerId, int followeeId) {
               
        following[followerId].add(followeeId);
    
    }
    
    public void unfollow(int followerId, int followeeId) {
        following[followerId].remove(new Integer(followeeId));
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
