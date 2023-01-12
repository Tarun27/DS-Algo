
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

class Solution {
    public int maxProfit(int[] prices) {

    /* 
    formula 1

        T[i][j] = Max(T[i][j-1], 
                    price[j]-price[m] + T[i-1][m]  where m = 0....j-1  )

        i -> no of transacations
        j -> day       

        T[i][j] -> max profit for a given i,j     
          
    */
      
      
  class Solution {
    public int maxProfit(int[] prices) {

    /* 
    formula
        T[i][j] = Max(T[i][j-1], 
                    price[j]-price[m] + T[i-1][m]  where m = 0....j-1  )

        i -> no of transacations
        j -> day       

        T[i][j] -> max profit for a given i,j      

    */
       int d = prices.length;
       int t = 2;
   
       int  maxp[][] = new int [t+1][d];

       for(int i =1;i<=t;i++){

       for(int j=1;j<d;j++) {

            int currMax=0;

            for(int k=0;k<j;k++){
           currMax = Math.max(currMax, prices[j]-prices[k] + maxp[i-1][k] );

            }

            maxp[i][j] = Math.max(maxp[i][j-1],currMax);
  //     System.out.println(currMax+" "+i+","+" "+j);     

       }

       }
       return maxp[t][d-1];
    }
}
      
      

    /* 
    formula 2
    
        T[i][j] = Max(T[i][j-1], 
                    price[j] + maxdiff, where maxdiff = max(maxdiff, T[i-1][j]- price[j]) )

        i -> no of transacations
        j -> day       

        T[i][j] -> max profit for a given i,j      

    */


       int d = prices.length;
       int t = 2;
   
       int  maxp[][] = new int [t+1][d];

       for(int i =1;i<=t;i++){

         int maxDiff =-prices[0];
       for(int j=1;j<d;j++) {

         maxp[i][j] = Math.max(maxp[i][j-1], prices[j] + maxDiff);

            maxDiff = Math.max(maxDiff, maxp[i-1][j] - prices[j]);


   //    System.out.println( maxp[i][j]+" "+i+","+" "+j);     

       }

       }
       return maxp[t][d-1];
    }
}
