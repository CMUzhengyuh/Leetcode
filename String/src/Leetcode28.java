/**
 * Leetcode 28 - Implement strStr()
 */
public class Leetcode28 {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int srcLen = haystack.length(), tarLen = needle.length();
        for (int i = 0; i <= srcLen - tarLen; i++) {
            if (haystack.substring(i, i + tarLen).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Leetcode28 Solution = new Leetcode28();

        String test1Haystack = "hello", test1Needle = "ll";
        System.out.println(Solution.strStr(test1Haystack, test1Needle));

        String test2Haystack = "hello", test2Needle = "lb";
        System.out.println(Solution.strStr(test2Haystack, test2Needle));

        String test3Haystack = "", test3Needle = "";
        System.out.println(Solution.strStr(test3Haystack, test3Needle));
    }
}
