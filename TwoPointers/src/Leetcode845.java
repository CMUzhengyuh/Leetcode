/**
 * Leetcode 845 - Longest Mountain in Array
 */
public class Leetcode845 {
    public int longestMountain(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && i < arr.length - 1 && arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i - 1, right = i + 1;
                while (left >= 1 && arr[left - 1] < arr[left]) {
                    left--;
                }
                while (right < arr.length - 1 && arr[right + 1] < arr[right]) {
                    right++;
                }
                res = Math.max(res, right - left + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode845 Solution = new Leetcode845();

        int[] test1Array = new int[]{2, 1, 4, 7, 3, 1, 5, 4, 5, 6, 7, 8, 2, 1};
        System.out.println(Solution.longestMountain(test1Array));
    }
}
