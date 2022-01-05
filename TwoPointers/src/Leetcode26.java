import java.util.Arrays;
/**
 * Leetcode 26 - Remove Duplicates from Sorted Array
 */
public class Leetcode26 {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                swap(nums, ++slow, fast);
            }
            fast++;
        }
        return ++slow;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Leetcode26 Solution = new Leetcode26();

        int[] test1Array = new int[]{0, 1, 2, 2, 3, 3, 3, 4, 5, 5, 5, 5};
        System.out.println(Solution.removeDuplicates(test1Array));
        System.out.println(Arrays.toString(test1Array));

        int[] test2Array = new int[]{1, 2, 2, 3, 3, 3, 4, 5, 7, 7, 9, 9};
        System.out.println(Solution.removeDuplicates(test2Array));
        System.out.println(Arrays.toString(test2Array));
    }
}
