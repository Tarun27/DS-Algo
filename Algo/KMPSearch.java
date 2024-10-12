class Solution {

  
    public List<String> stringMatching(String[] words) {
        // Using a set to store unique substrings found
        Set<String> substrs = new HashSet<>();

        // Compare each pair of words only once
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int m = words[i].length();
                int n = words[j].length();

                // If word j is longer, check if word i is a substring of word j
                if (n > m) {
                    if (isSubstring(words[j], words[i])) substrs.add(words[i]);
                }
                // If word i is longer, check if word j is a substring of word i
                else if (m > n) {
                    if (isSubstring(words[i], words[j])) substrs.add(words[j]);
                }
                // If they are the same length, check for equality (no need for KMP)
                else if (words[i].equals(words[j])) {
                    substrs.add(words[i]);
                }
            }
        }

        // Convert the set to a list and return it
        return new ArrayList<>(substrs);
    }

    // Function to check if 'pttrn' is a substring of 'txt' using KMP algorithm
    private boolean isSubstring(String txt, String pttrn) {
        int m = pttrn.length();
        int n = txt.length();
        // Preprocess pattern to create longest prefix suffix (LPS) array
        int[] lps = new int[m];
        computeLPS(pttrn, lps);

        int i = 0; // index for txt
        int j = 0; // index for pttrn

        // Loop over the text
        while (i < n) {
            char a = txt.charAt(i);
            char b = pttrn.charAt(j);

            // If characters match, move both pointers forward
            if (a == b) {
                i++;
                j++;
            }

            // If we reach the end of the pattern, we found a match
            if (j == m) {
                return true;
            }
            // If characters do not match and j > 0, move j based on LPS array
            else if (i < n && a != b) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++; // If j == 0, just move to the next character in txt
                }
            }
        }

        return false; // No match found
    }

    // Function to compute LPS (Longest Prefix Suffix) array for KMP
    private void computeLPS(String pttrn, int[] lps) {
        int len = 0; // Length of the previous longest prefix suffix
        int i = 1;
        lps[0] = 0; // LPS[0] is always 0

        // Build the LPS array for the pattern
        while (i < pttrn.length()) {
            // If characters match, extend the length of the current LPS
            if (pttrn.charAt(i) == pttrn.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // If there is no match, fall back in the LPS array
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0; // No proper prefix found
                    i++;
                }
            }
        }
    }
}
