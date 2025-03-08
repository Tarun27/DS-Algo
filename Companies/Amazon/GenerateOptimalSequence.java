package Amazon;
import java.util.*;


/***
 * Your development team has been assigned the task of designing a dynamic array generator tool to support software testing workflows. This generator service is designed to create an array that adheres to specific selection and unlocking rules.
 * The function takes the following parameters:
 * elements[n]: an array of n positive integers.
 * availability: a string of n characters where:
 * Each character is either '0' or '1'.
 * If availability[i] = '1', the corresponding elements[i] is selectable.
 * If availability[i] = '0', the corresponding elements[i] is initially locked.
 * To construct an output array, resultSet, the following process is executed exactly operations times.
 * Initially, resultSet is empty.
 * Choose any available element elements[i], where availability[i] = '1'. Elements can be selected multiple times.
 * Append the chosen value to resultSet.
 * For any availability[i] = '0' where availability[i-1] = '1', update availability[i] to '1'.
 * For instance, if availability was '0100101' before selection, it would become '0110111' after selection.
 * The goal is to generate the lexicographically largest possible sequence resultSet after operations selections.
 * Note: A sequence x is considered lexicographically larger than sequence y if there exists an
 * index i (0 ≤ i < operations) where x[i] > y[i], and for any j (0 ≤ j < i), x[j] = y[j].
 * 
 * Example 1:
 * Input:  elements = [10, 5, 7, 6], availability = "0101", operations = 2
 * Output: [6, 7]
 * Explanation:
 *
 * This test case was added on March 1, 2025, for your testing convenience. Relevant information is included in the source image section below.
 *
 *
 * Step 1: Initially, only {6} is available since availability[3] = '1'.
 *
 *
 * Step 2: Select 6. This unlocks availability[2], making {7} available.
 *
 *
 * Step 3: Select 7. We have now performed operations = 2 selections.
 *
 *
 * Example 2:
 * Input:  elements = [4, 9, 1, 2, 10], availability = "10010", operations = 4
 * Output: [4, 9, 10, 10]
 * Explanation:
 *
 * This test case was added on March 1, 2025, for your testing convenience. Relevant information is included in the source image section below.
 *
 *
 * Step 1: Initially available elements: {4, 10}.
 *
 *
 * Step 2: Select 4, unlocking availability[1] → {4} → {9}.
 *
 *
 * Step 3: Select 9, unlocking availability[2] → {9} → {1}.
 *
 *
 * Step 4: Select 10, unlocking availability[3] → {10} → {2}.
 *
 *
 * Step 5: Select 10 again.
 */

public class GenerateOptimalSequence {

    /**
     * Generates the lexicographically largest sequence resultSet by performing exactly 'operations' selections.
     * After each selection, the availability is updated concurrently:
     *   for each index i (from 1 to n-1), if the snapshot of availability has availability[i-1] == '1'
     *   and availability[i] == '0', then availability[i] is set to '1'.
     *
     * Elements may be selected multiple times.
     *
     * @param elements     an array of positive integers.
     * @param availability a binary string of length n ('1' means available; '0' means locked).
     * @param operations   the number of selections to perform.
     * @return an array representing the lexicographically largest resultSet.
     */
    public static int[] generateSequence(int[] elements, String availability, int operations) {
        int n = elements.length;
        int[] result = new int[operations];
        // Convert availability string to a char array.
        char[] state = availability.toCharArray();

        for (int op = 0; op < operations; op++) {
            int chosenValue = Integer.MIN_VALUE;
            // Choose the maximum element among indices where state[i]=='1'
            for (int i = 0; i < n; i++) {
                if (state[i] == '1' && elements[i] > chosenValue) {
                    chosenValue = elements[i];
                }
            }
            if (chosenValue == Integer.MIN_VALUE) {
                throw new IllegalStateException("No available element to select at operation " + (op + 1));
            }
            result[op] = chosenValue;

            // Update availability concurrently using a snapshot of the current state.

            // we can also Update availability concurrently by iterating from n-1 to 1.

            char[] snapshot = state.clone(); // snapshot version is easier to understand.
            for (int i = 1; i < n; i++) {
                if (snapshot[i-1] == '1' && snapshot[i] == '0') {
                    state[i] = '1';
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example 1:
        // Input: elements = [10, 5, 7, 6], availability = "0101", operations = 2
        // Expected Output: [6, 7]
        int[] elements1 = {10, 5, 7, 6};
        String availability1 = "0101";
        int operations1 = 2;
        System.out.println("Test Case 1 Output: " + Arrays.toString(generateSequence(elements1, availability1, operations1)));

        // Test Case 2:
        // Input: arr = [5, 3, 4, 6], availability = "1100", operations = 5
        // Expected Output: [5, 5, 6, 6, 6]
        int[] elements2 = {5, 3, 4, 6};
        String availability2 = "1100";
        int operations2 = 5;
        System.out.println("Test Case 2 Output: " + Arrays.toString(generateSequence(elements2, availability2, operations2)));

        // Test Case 3:
        // Input: elements = [4, 9, 1, 2, 10], availability = "10010", operations = 4
        // With the above process, this method produces [4, 10, 10, 10].
        // (If a different unlocking that depends on the chosen index is desired,
        //  a modified selection strategy would be needed to yield [4, 9, 10, 10].)
        int[] elements3 = {4, 9, 1, 2, 10};
        String availability3 = "10010";
        int operations3 = 4;
        System.out.println("Test Case 3 Output: " + Arrays.toString(generateSequence(elements3, availability3, operations3)));
    }
}

