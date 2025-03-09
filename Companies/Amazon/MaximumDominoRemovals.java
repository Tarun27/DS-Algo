package Amazon;


/**
 * Amazon Games has introduced an exciting new game that revolves around dominoes! 🎲 The game consists of n dominoes, each having a 
   distinct size represented by an array tiles.
 * In this game, the "order" of the dominoes is defined as the length of the longest strictly increasing subsequence (LIS) formed by their sizes.
 * Additionally, there is another array removalOrder, which contains integers ranging from 0 to n-1. These integers indicate the positions
   of dominoes that can be removed one by one in the specified sequence.
 * Your objective is to determine the maximum number of removals that can be performed while ensuring that the order (LIS) of the 
   remaining dominoes remains at least a given threshold minOrder.
   
 * Parameters -
 
 * int tiles[n] – an array of n integers representing the sizes of dominoes.
 
 * int removalOrder[n] – an array specifying the sequence in which the dominoes should be removed.
 
 * int minOrder – an integer representing the minimum required LIS that must be maintained after removals.
 
 * Return -
 * The function should return a single integer, which represents the maximum number of removals possible while keeping the longest 
   strictly increasing subsequence at least minOrder.
 * 
   Example 1:
 * Input:  tiles = [1, 4, 4, 2, 5, 3], removalOrder = [2, 1, 4, 0, 5, 3], minOrder = 3
 * Output: 3 
 * Explanation:
 *
 * In this example, the player can remove dominoes in the order specified by remove. After each removal, the length of the LIS
   of the remaining dominoes should be at least min_order. The task is to find out the maximum number of such removals possible.
 *
 * 
 */



public class MaximumDominoRemovals {

// time complexity ( O(logn) * n^2)
// time complexity can be improved by doing nlogn LIS implementation  
    public static int maximumDominoRemovals(int[] tile, int[] removalOrder, int minOrder) {

        // write your code here

            int start = 0;

            int end = removalOrder.length-1;

            while(start<=end){

                int mid = start + (end-start)/2;

                int currLis = maxLis(tile,mid,removalOrder);

                if(currLis >= minOrder){
                    start = mid + 1;
                }else{
                    end = mid-1;
                }
            }

            return start;

    }

  
    public static int maxLis(int[] nums, int mid,int[] removalOrder) {
        if (nums.length == 0) return 0;



        int n = nums.length;
        int[] dp = new int[n];  // dp[i] = LIS ending at index i
        int maxLIS = 1;

        boolean[] skip  = new boolean[n];

        for(int i=0;i<=mid;i++) skip[removalOrder[i]] = true;

        for (int i = 0; i < n; i++) dp[i] = 1; // Initialize all LIS lengths as 1

        for (int i = 1; i < n; i++) { // Outer loop - Current element
            if(skip[i]) continue;
            for (int j = 0; j < i; j++) { // Inner loop - Checking previous elements
                if(skip[j]) continue;
                if (nums[i] > nums[j]) { // Can we extend LIS at j?
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]); // Update max length found so far
        }
        return maxLIS;
    }



    public static void main(String[] args) {

        int[] tiles = {1, 4, 4, 2, 5, 3};
        int[] removalOrder = {2, 1, 4, 0, 5, 3};
        int minOrder = 3;

        System.out.println(maximumDominoRemovals(tiles, removalOrder, minOrder));

    }

}
