package JPMorgan;


/**
 *
 * Start with an initial string of zeros. Choose any digit to flip. When a digit is flipped, its value and those 
 * to the right switch state between 0 and 1. Given a target string of binary digits, determine the minimum number
 * of flips required to achieve the target.
 * 
 * Function Description
 * 
 * Complete the function minimumFlips in the editor below.
 * 
 * minimumFlips has the following parameter(s):
 * string target: a string of 0s and 1s to match
 * Returns
 * int: the minimum number of flips needed to obtain the target string
 * Example 1:
 * Input:  target = "01011"
 * Output: 3 
 * Explanation:

 *       Start with a string of 5 zeros, the same length as the target.
 *       Initial String -> 00000
 *        Flip the 3rd digit -> 00111
 *       Flip the 2nd digit -> 01000
 *       Flip the 4th digit -> 01011
 *       3 flips are required to reach the target. The return value is 3.
 *       
 */
public class MinimumFlips {

    public static void main(String[] args) {

        String target = "01011";

        int flips = minimumFlips(target);

        System.out.println(flips);
    }

    private static int minimumFlips(String target) {

        int flips =0;

        char prev = '0';

        for(char c: target.toCharArray()){

            if(c!=prev){
                prev = c;
                flips++;
            }

        }

        return flips;

    }
}
