/**
Fast and slow pointers pattern
Starting with the given number n, replace the number with the sum of the squares of its digits.
Repeat the process until:
The number equals  1, which will depict that the given number  n is a happy number.
The number enters a cycle, which will depict that the given number n is not a happy number.
*/


public class SumOfSquares {

    // Method to calculate the sum of squares of the digits of a number
    public static int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    // Method to check if a number converges to 1 or falls into a cycle
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = sumOfSquares(n); // move fast pointer one step initially

        // Continue until fast and slow pointers meet, or slow reaches 1
        while (fast != 1 && slow != fast) {
            slow = sumOfSquares(slow);          // move slow pointer one step
            fast = sumOfSquares(sumOfSquares(fast)); // move fast pointer two steps
        }

        return fast == 1; // if the fast pointer reaches 1, the number is happy
    }

    public static void main(String[] args) {
        int num = 19;
        if (isHappy(num)) {
            System.out.println(num + " converges to 1 and is a happy number.");
        } else {
            System.out.println(num + " falls into a cycle and is not a happy number.");
        }
    }
}
