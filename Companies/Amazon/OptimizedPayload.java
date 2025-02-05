package Amazon;

import java.util.*;

/**
 *
 *
 *
 * You are given an array payload of size n, where payload[i] represents the size of the (i)-th event
 * payload. The task is to select a subset of events and rearrange them into a new array optimizedPayload
 * that satisfies the following conditions:
 *
 *
 * The first segment is strictly increasing.
 * The second segment is strictly decreasing.
 * The third segment is strictly increasing.
 * The goal is to maximize the number of events included in optimizedPayload.
 *
 * Function Specification:
 *
 * Function Name: getMaximumEvents
 * Input:
 * int payload[n]: Array of payload sizes.
 * Output:
 * int: Maximum number of events that can be selected.
 * Constraints:
 *
 * 2 ≤ n ≤ 2×10^5
 * 1 ≤ payload[i] ≤ 10^9
 * payload contains at least 2 distinct elements.
 *
 *
 * solution:
 *
 *  max <-  /\     / -> max
 *  	     /  \   /
 *  min<- /    \ / -> min
 *
 *
 * Explanation of the Approach:
 *
 * Counting Frequencies:
 *
 * We use a HashMap to count the occurrences of each number in the payload.
 *
 * Handling minVal and maxVal:
 *
 * The minimum value (minValue) can appear at most twice: once in the increasing part and once in the decreasing part.
 * The maximum value (maxValue) can also appear at most twice: once in the decreasing part and once in the increasing part.
 * We add the counts of minValue and maxValue to the answer, capped at 2.
 *
 * Handling Middle Values:
 *
 * All other numbers in the middle can appear up to three times, once in each of the three segments: increasing, decreasing, and again in the increasing part.
 * We sum up the count of each middle value, capped at 3.
 * Returning the Result:
 * Finally, the answer (ans) is the sum of all valid elements counts.
 *
 *
 */

public class OptimizedPayload {

    public static int maxOptimizedPayload(int[] payload) {
        // Step 1: Count occurrences of each element
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : payload) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find the minimum and maximum values in the map
        int minValue = Collections.min(count.keySet());
        int maxValue = Collections.max(count.keySet());

        int ans = 0;

        // Step 3: Add the count for minValue and maxValue, capped at 2
        ans += Math.min(count.get(minValue), 2);
        ans += Math.min(count.get(maxValue), 2);

        // Step 4: For all other middle values, add their count capped at 3
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int value = entry.getKey();
            if (value != minValue && value != maxValue) {
                ans += Math.min(entry.getValue(), 3);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] payload1 = {1, 3, 5, 4, 2, 6, 8, 7, 9};
        System.out.println(maxOptimizedPayload(payload1)); // Output: 9

        int[] payload2 = {4, 4, 4, 4, 4};
        System.out.println(maxOptimizedPayload(payload2)); // Output: 2 (min and max are the same)

        int[] payload3 = {1, 1, 1, 2};
        System.out.println(maxOptimizedPayload(payload3)); // Output: 3

        int[] payload4 = {1, 2, 1, 2, 4, 4, 5, 5};
        System.out.println(maxOptimizedPayload(payload4)); // Output: 8

        int[] payload5 = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4};
        System.out.println(maxOptimizedPayload(payload5)); // Output: 10
    }
}
