/**
 * Leetcode 91 - Decode Ways
 */
public class Leetcode91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Leetcode91 Solution = new Leetcode91();

        String test1String = "123123";
        System.out.println(Solution.numDecodings(test1String));

        String test2String = "122123";
        System.out.println(Solution.numDecodings(test2String));
    }
}
