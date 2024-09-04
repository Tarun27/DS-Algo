/**

Generate a string of n balanced parentheses

n = 4

output

((()))
(()())
(())()
()(())
()()()

*/

import java.util.*;

public class BalancedParentheses {
    public static List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesesHelper(result, "", 0, 0, n);
        return result;
    }

    private static void generateParenthesesHelper(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            generateParenthesesHelper(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            generateParenthesesHelper(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> parentheses = generateParentheses(n);

        for (String p : parentheses) {
            System.out.println(p);
        }
    }
}
