/**
 * 12th - Leetcode 3 - Longest Substring Without Repeating Characters
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Solution: HashTable
     * TC: O(n)
     * SC: O(n)
     */
    public int lengthOfLongestSubstring(String s) {
        /**
         * Serve as HashMap to store visited substring
         */
        boolean[] visited = new boolean[255];
        char[] ch = s.toCharArray();
        /**
         * Left pointer to record the start point of current non-repeating substring ends with right
         */
        int left = 0, right = 0, res = 0;
        for (right = 0; right < ch.length; right++) {
            if (visited[ch[right] - 0]) {
                /**
                 * Move left pointer until repeated character is excluded
                 */
                while (ch[left] != ch[right]) {
                    visited[ch[left++] - 0] = false;
                }
                left++;
            } else {
                visited[ch[right] - 0] = true;
            }
            /**
             * Find maximum length
             */
            res = Math.max(right - left + 1, res);
        }
        return res;
    }
}
