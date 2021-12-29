import java.util.Arrays;
/**
 * Leetcode 80 - Remove Duplicates from Sorted Array II
 */
public class Leetcode80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int slow = 2, fast = 2;
        while (fast < nums.length) {
            if (nums[slow - 1] == nums[fast] && nums[slow - 2] == nums[fast]) {
                fast++;
            } else {
                swap(nums, slow++, fast++);
            }
        }
        return slow;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Leetcode80 Solution = new Leetcode80();

        int[] test1Array = new int[]{0, 1, 2, 2, 3, 3, 3, 4, 5, 5, 5, 5};
        System.out.println(Solution.removeDuplicates(test1Array));
        System.out.println(Arrays.toString(test1Array));

        int[] test2Array = new int[]{1, 2, 2, 3, 3, 3, 4, 5, 7, 7, 9, 9};
        System.out.println(Solution.removeDuplicates(test2Array));
        System.out.println(Arrays.toString(test2Array));
    }
}
