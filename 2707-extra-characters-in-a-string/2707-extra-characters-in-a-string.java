import java.util.Arrays;

class Solution {
    private int[] dp = new int[51]; // Initialize dp array with 0 values

    public int minExtraChar(String s, String[] dictionary) {
        Arrays.fill(dp, -1); // Initialize dp array with -1 values
        return minExtraCharHelper(s, dictionary, 0);
    }

    private int minExtraCharHelper(String s, String[] dictionary, int i) {
        if (i == s.length()) {
            return 0;
        }

        if (dp[i] == -1) {
            dp[i] = 1 + minExtraCharHelper(s, dictionary, i + 1); // Initialize with one extra character

            for (String w : dictionary) {
                if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = Math.min(dp[i], minExtraCharHelper(s, dictionary, i + w.length())); // Update if a word in the dictionary is found
                }
            }
        }

        return dp[i]; // Return the minimum extra characters starting from position i
    }
}
/* 
Problem Statement:
We are given a string s and a dictionary of words. The goal is to break s into one or more non-overlapping substrings such that each substring is present in the dictionary and minimize the number of extra characters left over.

Approach
Dynamic Programming Approach: We can solve this problem using dynamic programming. There are two common approaches: bottom-up (iterative) and top-down (recursive with memoization). Both approaches aim to find the minimum extra characters from the end of the string to the beginning.

Steps-
Initialization: Initialize a dynamic programming array (dp) to store the minimum number of extra characters at each position in the string. Initialize all elements in dp to a maximum value (e.g., -1 or a large number) to indicate that they haven't been calculated yet.

Bottom-Up (Iterative) Approach:

Start iterating through the string s from the end (right to left).
For each position i, initialize dp[i] with a value of 1 + dp[i + 1]. This represents breaking the string after the current character and adding one extra character to the minimum extra characters found in the next position.
Check for each word in the dictionary if it matches the substring starting from the current position i. If a match is found, update dp[i] to the minimum between its current value and dp[i + w.size()], where w.size() is the length of the matched word.
Continue this process for all positions in the string s, and the final value of dp[0] will represent the minimum number of extra characters left over.
Top-Down (Recursive with Memoization) Approach:

-** Define a recursive** function that starts from the beginning of the string s and calculates the minimum extra characters.

Use an array (dp) to memoize intermediate results to avoid redundant calculations. Initialize all elements in dp to a special value (e.g., -1) to indicate that they haven't been calculated yet.
In the recursive function, **if dp[i] is not yet calculated **(equals -1), calculate it as follows:
a-> Initialize dp[i] with a value of 1 + minExtraChar(s, dict, i + 1), representing breaking the string after the current character and adding one extra character to the minimum extra characters found in the next position.
b-> Check for each word in the dictionary if it matches the substring starting from the current position i. If a match is found, update dp[i] to the minimum between its current value and 1 + minExtraChar(s, dict, i + w.size()), where w.size() is the length of the matched word.
Return dp[0], which represents the minimum extra characters starting from position 0.
Result: The result of either approach is the minimum number of extra characters left over when optimally breaking up the string into substrings from the dictionary.

Complexity
Bottom-Up (Iterative) Approach:

Time Complexity (TC): O(NML), where N is the length of the input string s, M is the number of words in the dictionary, and L is the average length of words in the dictionary.
Space Complexity (SC): O(N), where N is the length of the input string s. We use an array dp of size N to store the minimum extra characters at each position.
Top-Down (Recursive with Memoization) Approach:

Time Complexity (TC): O(NML), where N is the length of the input string s, M is the number of words in the dictionary, and L is the average length of words in the dictionary. This is because each position in the string is visited once for each word in the dictionary.
Space Complexity (SC): O(N), where N is the length of the input string s. We use an array dp of size N for memoization, and the recursive call stack can go up to a depth of N.
*/