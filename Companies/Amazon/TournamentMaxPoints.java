package Amazon;


/**
 *Explanation of the Problem
 *
 * We have a tournament represented by an array d, where each element is a sprint, and its value represents
 * the number of days in that sprint.Each day within a sprint has an increasing number of points,
 * starting from 1 and going up to the sprint length.
 *
 * Day 1 gives 1 point, Day 2 gives 2 points, Day 3 gives 3 points, etc.
 *
 * For example:
 *
 * d = [7, 4, 3, 7, 2]
 *
 * The first sprint has 7 days with points: [1, 2, 3, 4, 5, 6, 7]
 * The second sprint has 4 days with points: [1, 2, 3, 4]
 * The third sprint has 3 days with points: [1, 2, 3]
 * The fourth sprint has 7 days with points: [1, 2, 3, 4, 5, 6, 7]
 * The fifth sprint has 2 days with points: [1, 2]
 *
 * Given an integer k, which represents the number of consecutive days a participant can run,
 * we need to determine the maximum points the participant can earn by selecting an optimal starting position.
 *
 *
 *
 *
 If we fully expand these sprints, it would look like:

 * [1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 1, 2]
 *
 *
 * You can pick any k consecutive days in this sequence.
 * The goal is to find the maximum sum of points for any valid k-day window.
 * Efficient Approach
 *
 * Since the input size can be large (e.g., d length 10,000 and values even bigger),
 * we cannot fully expand the array. Instead, we use a sliding window technique to efficiently
 * compute the maximum sum for any k consecutive days.
 *
 * We maintain a sliding window where:
 *
 * start: Tracks the beginning of the window.
 * end: Expands the window.
 * startValue: Tracks the decreasing values when shifting the window.
 * value: Stores the sum of points in the current window.
 * length: Stores the number of days in the current window.
 *
 *
 *  overall time complexity is O(N)
 */


public class TournamentMaxPoints {


    public static int getMaxValue(int[] d, int k) {
        int startDayIdx = 0, currDayIdx = 0, sprintStartValue = 1;
        int totalSprintvalue = 0, windowLength = 0, maxPoints = -1;
        int noOfDays = d.length;


        while (currDayIdx < noOfDays) {
            totalSprintvalue += getTotal(d[currDayIdx]); // Add the new sprint's points
            windowLength += d[currDayIdx]; // Increase window size

            // Shrink window if it exceeds 'k' days
            while (windowLength > k) {
                totalSprintvalue -= sprintStartValue; // Remove the first day's points
                sprintStartValue++; // Move to the next day's points

                // If we finish a sprint, move 'startDayIdx' to next sprint
                if (sprintStartValue > d[startDayIdx]) {
                    sprintStartValue = 1;
                    startDayIdx++;
                }
                windowLength--; // Reduce window size
            }

            maxPoints = Math.max(maxPoints, totalSprintvalue); // Update max points found
            currDayIdx++;
        }
        return maxPoints;
    }

    // Function to get total sum of first 'n' natural numbers
    private static int getTotal(int n) {
        return (n * (n + 1)) / 2;
    }


    public static void main(String[] args) {
        System.out.println(getMaxValue(new int[]{7, 4, 3, 7, 2}, 8)); // Output: 32
        System.out.println(getMaxValue(new int[]{7, 4, 3, 7, 2}, 1)); // Output: 7
        System.out.println(getMaxValue(new int[]{7, 4, 3, 7, 2}, 3)); // Output: 6
    }
}
