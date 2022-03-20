//https://leetcode.com/problems/coin-change/

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
