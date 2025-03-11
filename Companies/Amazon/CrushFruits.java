package Amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/***
 * Breaking! 🚀🚀🔥🔥 Amazon has recently introduced an exciting new game called 🍇🍉🍊Let's Play Crush Fruit Together🍉🥝🥑!
   In this game, players can select any two distinct types of fruits and crush them together. Each fruit type is represented as a 
   unique integer within an array.
 * Your task is to determine the minimum possible number of fruits remaining after repeatedly performing this operation.
   That means, as long as there exist at least two different fruit types in the array, you can keep picking and removing them.
 * Function Description
 * Complete the function getMinimumFruits in the editor.
 * getMinimumFruits has the following parameter(s):
 * int fruitsArray[n]: an array of n integers where each integer represents a specific type of fruit.
 * Returns The function should return a single integer, which represents the smallest number of fruits left in the array after performing
   the "crush operation" as many times as possible.
 *
 * Example 1:
 *
 * Input:  fruitsArray = [3, 3, 1, 1, 2]
 * Output: 1
 * Explanation:
 *
 *
 * We can first crush fruit type 1 (e.g., banana) with fruit type 2 (e.g., pineapple).
 *
 * Next, we crush the remaining fruit type 1 (banana) with one fruit type 3 (orange).
 *
 * Now, only one fruit type 3 (orange) remains in the array.
 *
 * Since there are no distinct fruit types left to crush, the minimum number of remaining fruits is 1.
 *
 * 
 * Input:  fruitsArray = [1, 2, 5, 6]
 * Output: 0 
 * Explanation:
 *
 *
 * We can first crush fruit type 1 with fruit type 2.
 *
 * Next, we can crush fruit type 5 with fruit type 6.
 *
 * Since all fruit types have been successfully removed through crushing, the final number of fruits left is 0.
 *
 *
 */

public class CrushFruits {


    public static int getMinimumFruits(int[] fruitsArray) {
        // write your code here

        Map<Integer,Integer> map = new HashMap<>();

        for( int i: fruitsArray){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        int curr = 0;
        for(int i: map.values()) {

            if(curr<=0) curr +=i;
            else curr -= i;

        }

        return Math.abs(curr);

    }


    public static void main(String args[]){

        int[][] input = {{  3, 3, 1, 1, 2 },{ 1, 2, 5, 6 }, {1, 1, 1, 1},  {1, 1, 1, 2}, };

        Arrays.stream(input).forEach(arr-> System.out.println( getMinimumFruits(arr) ));

    }

}
