/**
 * Leetcode 727 - Minimum Window Subsequence ***
 */
public class Leetcode727 {
    public String minWindow(String s1, String s2) {
        int start = -1;
        String res = "";
        while (true) {
            /**
             * Check s1 the existence of all characters in s2 from index = start + 1
             */
            for (char c: s2.toCharArray()) {
                start = s1.indexOf(c, start + 1);
                if (start == -1) return res;
            }
            /**
             * The s1 index of last character in s2
             */
            int end = ++start;
            for (int j = s2.length() - 1; j >= 0; j--) {
                start = s1.lastIndexOf(s2.charAt(j), start - 1);
            }
            if (res == "" || res.length() > end - start) res = s1.substring(start++, end);
        }
    }

    public static void main(String[] args) {
        Leetcode727 Solution = new Leetcode727();

        String test1String1 = "abcdebdde", test1String2 = "bde";
        System.out.println(Solution.minWindow(test1String1, test1String2));

        String test2String1 = "jmeqksfrsdcmsiwvaovztaqenprpvnbstl", test2String2 = "u";
        System.out.println(Solution.minWindow(test2String1, test2String2));
    }
}