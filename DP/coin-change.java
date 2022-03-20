//https://leetcode.com/problems/coin-change/

// solution 1
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if(amount==0){
            return 0;
         }
        
        int memo[]= new int[amount+1];
      //  int coinsList[]= new int[amount+1];
      //  Arrays.fill(coinsList,-1);
        Arrays.fill(memo,99999);
            memo[0]=0;
       
     
        for(int i=0;i<coins.length;i++){
            
            for(int j=1;j<=amount;j++){
                         
                if(j>=coins[i]){
                    memo[j]=Math.min(memo[j],1+memo[j-coins[i]]);     
                    coinsList[j]=i;
                } 
            }
            
        }
        
    //    printCoins(coins,coinsList);

        return (memo[amount]==99999)? -1 : memo[amount];
    }
    
    public void printCoins(int[] coins, int coinsList[]){
             int   start = coinsList.length-1;
        if(coinsList[start]==-1){
            System.out.println("no solution possible");
            return;
        }
        
        System.out.println("coins used:   ");
        
        while(start>0){
          System.out.print(coins[coinsList[start]] + "  ");
            start = start-coins[coinsList[start]];
        }
    }
    
}

/*  solution 2
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if(amount==0){
            return 0;
         }
        
        int memo[][] = new int[coins.length+1][amount+1];
        Arrays.stream(memo).forEach(row ->{
                                    Arrays.fill(row, 99999);
                                    row[0]=0;
        });
        
        for(int i=1;i<=coins.length;i++){
            
            for(int j=1;j<=amount;j++){
                         
                if(j>=coins[i-1]){
                    memo[i][j]=Math.min(memo[i-1][j],1+memo[i][j-coins[i-1]]);              
                } else{
                    memo[i][j]= memo[i-1][j];
                }        
                
            }
            
        }
            //    Arrays.stream(memo).forEach(row ->System.out.println( Arrays.toString(row)));

        return (memo[coins.length][amount]==99999)? -1 : memo[coins.length][amount];
    }
}
*/
