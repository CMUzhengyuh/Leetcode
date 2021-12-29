import java.util.Arrays;
/**
 * Leetcode 283 - Move Zeroes
 */
public class Leetcode283 {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left++, right);
            }
            right++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Leetcode283 Solution = new Leetcode283();

        int[] test1Array = new int[]{0, 0, 2, 1, 3, 0, 3, 4, 1, 5, 0, 5};
        Solution.moveZeroes(test1Array);
        System.out.println(Arrays.toString(test1Array));

        int[] test2Array = new int[]{0};
        Solution.moveZeroes(test1Array);
        System.out.println(Arrays.toString(test2Array));

        int[] test3Array = new int[]{3, 2, 1};
        Solution.moveZeroes(test1Array);
        System.out.println(Arrays.toString(test3Array));
    }
}
