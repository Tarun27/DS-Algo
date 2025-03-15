package Amazon;

import java.util.Arrays;


/**
 *
 * At a high-paced analytics platform, efficiently scheduling tasks within designated time constraints is crucial. The system consists of n
   mandatory tasks and n optional tasks. Two arrays, mandatoryTasks and optionalTasks, specify the duration in hours of each task.
   Here, mandatoryTasks[i] indicates the time required for the i-th mandatory task, while optionalTasks[i] represents the duration of the i-th 
   optional task.
 * Each workday has a strict limit of maxDailyHours, within which tasks must be scheduled. It is required that exactly one mandatory task is
   scheduled each day. If time permits, at most one optional task can also be included on the same day. The total time spent on a day cannot
   exceed maxDailyHours. The challenge is to determine the highest number of optional tasks that can be scheduled over the course of n days
    while adhering to these constraints.
    
 * Function Description
 
 * Complete the function computeMaxScheduledTasks in the editor below.
 * computeMaxScheduledTasks has the following parameters:
 * 1. int maxDailyHours: the maximum number of hours available each day.
 * 2. int mandatoryTasks[n]: an array representing the duration of mandatory tasks.
 * 3. int optionalTasks[n]: an array representing the duration of optional tasks.
 * Returns
 * int: the highest number of optional tasks that can be completed within the given constraints.
 * Example 1:
 * Input:  maxDailyHours = 7, mandatoryTasks = [4, 5, 2, 4], optionalTasks = [5, 6, 3, 4]
 * Output: 2
 * Explanation:
 *
 *       Day 1: Schedule the first mandatory task (4 hours) and the third optional task (3 hours). Total: 4 + 3 = 7 hours.
 *       Day 2: Schedule the second mandatory task (5 hours). No optional task can be added. Total: 5 hours.
 *       Day 3: Schedule the third mandatory task (2 hours) and the first optional task (5 hours). Total: 2 + 5 = 7 hours.
 *       Day 4: Schedule the fourth mandatory task (4 hours). No optional task can be added. Total: 4 hours.
 *       After optimizing task scheduling, the maximum number of optional tasks that can be included is 2.
 *
 *
 */

public class MaxScheduledTasks {


    public static int computeMaxScheduledTasks(int maxDailyHours, int[] mandatoryTasks, int[] optionalTasks) {
        // write your code here

        Arrays.sort(mandatoryTasks);
        Arrays.sort(optionalTasks);

        int ans =0;

        int o = 0;

        for(int i = mandatoryTasks.length-1; i>=0;i--){

            if(mandatoryTasks[i] + optionalTasks[o] <=maxDailyHours){
                ans++;
                o++;
            }

        }

        return ans;

    }

    public static void main(String args[]){

           // Declare test cases in a 2D Object array.
        // Each inner array: {maxDailyHours, mandatoryTasks, optionalTasks, expectedOutput}
        Object[][] testCases = {
                {7, new int[]{4, 5, 2, 4}, new int[]{5, 6, 3, 4}, 2},
                {5, new int[]{4, 4, 4}, new int[]{2, 2, 2}, 0},
                {10, new int[]{5, 5, 5}, new int[]{1, 2, 3}, 3},
                {8, new int[]{3, 7, 5, 2}, new int[]{4, 2, 3, 4}, 3},
                {5, new int[]{1, 2, 3}, new int[]{3, 2, 1}, 3},
                {6, new int[]{6, 1, 2, 3}, new int[]{3, 2, 1, 2}, 3}
        };

        // Iterate over each test case and print the output.
        for (int i = 0; i < testCases.length; i++) {
            int maxDailyHours = (Integer) testCases[i][0];
            int[] mandatoryTasks = (int[]) testCases[i][1];
            int[] optionalTasks = (int[]) testCases[i][2];
            int expected = (Integer) testCases[i][3];

            int result = computeMaxScheduledTasks(maxDailyHours, mandatoryTasks, optionalTasks);
            System.out.println("Test Case " + (i + 1) + ": Expected: " + expected + ", Got: " + result);
        }
        
    }

}
