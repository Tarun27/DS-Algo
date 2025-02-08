package Amazon;

import java.util.*;


/**
 * A general store at Hackerland sells n items with the price of the ith item represented by price[i]. The store adjusts the price of the items based on inflation as queries of two types:
 * 1 x v: Change the price of the xth item to v.
 * 2 v v: Change any price that is less than v to v.
 * Given an array price of n integers and the price adjustment queries are in the form of a 2-d array where query[i] consists of 3 integers, find the final prices of all the items.
 *
 * Function Description
 *
 * Complete the function finalPrices in the editor.
 *
 * public int[] finalPrices(int n, int[] price, int q, int[][] queries) {
 *
 * }
 *
 * finalPrices has the following parameters:
 * n: an integer, the number of items
 * int price[n]: an array of integers representing the prices
 * q: an integer, the number of queries
 * int queries[q][3]: a 2D array of price adjustment queries
 *
 * Returns
 * int[]: an array of integers representing the final prices
 *
 *
 */

public class HackerlandStore {


    public static int[] finalPrices(int n, int[] price, int q, int[][] queries) {
        for (int[] query : queries) {
            if (query[0] == 1) {
                // Update the x-th item to v (1-based index)
                price[query[1] - 1] = query[2];
            } else if (query[0] == 2) {
                // Update all prices less than v to v
                int minVal = query[1];
                for (int i = 0; i < n; i++) {
                    if (price[i] < minVal) {
                        price[i] = minVal;
                    }
                }
            }
        }
        return price;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] price = {3, 5, 2, 8, 6};
        int[][] queries = {
                {1, 3, 10}, // Update index 3 (2-based index) to 10 -> {3, 5, 10, 8, 6}
                {2, 6, 6},  // Update all < 6 to 6 -> {6, 6, 10, 8, 6}
                {1, 1, 4}   // Update index 1 to 4 -> {4, 6, 10, 8, 6}
        };

        int[] result = finalPrices(n, price, queries.length, queries);
        System.out.println(Arrays.toString(result)); // Output: [4, 6, 10, 8, 6]


    }
}
