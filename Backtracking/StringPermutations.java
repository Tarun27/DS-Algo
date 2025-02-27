import java.util.*;

class StringPermutations {
    public static void main(String[] args) {
        String str = "ABC";  // Example input
        List<String> result = permute(str);
        System.out.println(result);
    }

    public static List<String> permute(String str) {
        List<String> res = new ArrayList<>();
        boolean[] visited = new boolean[str.length()];

        // Convert string to character array
        char[] chars = str.toCharArray();
        Arrays.sort(chars); // Sorting ensures duplicate handling works

        backtrack(res, chars, new StringBuilder(), visited);
        return res;
    }

    private static void backtrack(List<String> res, char[] chars, StringBuilder sb, boolean[] visited) {
        // Base case: If the current string is complete, add it to results
        if (sb.length() == chars.length) {
            res.add(sb.toString());
            return;
        }

        // Iterate over each character
        for (int i = 0; i < chars.length; i++) {
            // Skip used characters
            if (visited[i]) continue;

            // Skip duplicates: Ensure the first occurrence is used before the duplicate
            if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) continue;

            // Mark as used and add to current permutation
            visited[i] = true;
            sb.append(chars[i]);

            // Recur to build the next part of the permutation
            backtrack(res, chars, sb, visited);

            // Backtrack: Remove last character and mark as unused
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
