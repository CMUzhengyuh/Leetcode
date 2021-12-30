/**
 * Leetcode 43 - Multiply Strings
 */
public class Leetcode43 {
    public String multiply(String num1, String num2) {
        /**
         * Corner case: num1 / num2 is "0"
         */
        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] result = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int add = 0;
            for (int j = 0; j < num2.length(); j++) {
                /**
                 * Current result is composed of three parts
                 * A. New calculated digit
                 * B. Carry digit
                 * C. Original digit (store intermediate result in circulation)
                 */
                int cur = (num1.charAt(num1.length() - 1 - i) - '0') * (num2.charAt(num2.length() - 1 - j) - '0') + result[i + j] + add;
                result[i + j] = cur % 10;
                add = cur / 10;
            }
            result[i + num2.length()] += add;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--) {
            if (i == result.length - 1 && result[i] == 0) {
                continue;
            }
            sb.append((char)(result[i] + '0'));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode43 Solution = new Leetcode43();

        String test1String1 = "269478", test1String2 = "4573928";
        System.out.println(Solution.multiply(test1String1, test1String2));

        String test2String1 = "0", test2String2 = "4573928";
        System.out.println(Solution.multiply(test2String1, test2String2));
    }
}
