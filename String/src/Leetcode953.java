/**
 * Leetcode 953 - Verifying an Alien Dictionary
 */
public class Leetcode953 {
    public boolean isAlienSorted(String[] words, String order) {
        /**
         * Array of int to stimulate HashMap
         */
        int[] map = new int[26];
        int index = 0;
        for (char c : order.toCharArray()) {
            map[c - 'a'] = index++;
        }
        for (int i = 0; i < words.length - 1; i++) {
            int m = words[i].length(), n = words[i + 1].length(), j = 0;
            for (j = 0; j < m && j < n; j++) {
                int a = map[words[i].charAt(j) - 'a'], b = map[words[i + 1].charAt(j) - 'a'];
                if (a < b) {
                    break;
                } else if (a > b) {
                    return false;
                }
            }
            if (j == n && j < m) {return false;}
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode953 Solution = new Leetcode953();

        String[] test1Words = new String[]{"hello", "leetcode"};
        String test1Order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(Solution.isAlienSorted(test1Words, test1Order));

        String[] test2Words = new String[]{"apple", "app"};
        String test2Order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(Solution.isAlienSorted(test2Words, test2Order));
    }
}
