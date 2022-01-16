/**
 * Leetcode 567 - Permutation in String
 */
public class Leetcode567 {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 > l2) return false;
        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a'] ++;
        }
        int left = 0, right = 0;
        /**
         * Counter to record characters to match
         */
        int counter = l1;
        /**
         * Initial a sliding window of length l1
         */
        while (right < l1) {
            if (count[s2.charAt(right++) - 'a']-- > 0) {
                counter--;
            }
        }
        while (right < l2 && counter != 0) {
            if (count[s2.charAt(left++) - 'a']++ >= 0) counter++;
            if (count[s2.charAt(right++) - 'a']-- > 0) counter--;
        }
        return counter == 0;
    }

    public static void main(String[] args) {
        Leetcode567 Solution = new Leetcode567();

        String test1String1 = "ab", test1String2 = "eidbaooo";
        System.out.println(Solution.checkInclusion(test1String1, test1String2));

        String test2String1 = "aba", test2String2 = "eidbaooo";
        System.out.println(Solution.checkInclusion(test2String1, test2String2));
    }
}