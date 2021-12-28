import java.util.Arrays;

/**
 * Leetcode 75 - Sort Colors
 */
public class Leetcode75 {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, index = 0;
        while (index <= right) {
            if (nums[index] == 0) {
                swap(nums, index, left++);
            }
            if (nums[index] == 2) {
                swap(nums, index, right--);
                index--;
            }
            index++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Leetcode75 Solution = new Leetcode75();

        int[] test1Array = new int[]{2, 0, 1, 1, 0, 2, 2};
        Solution.sortColors(test1Array);
        System.out.println(Arrays.toString(test1Array));

        int[] test2Array = new int[]{1, 0, 1, 1, 2, 1, 1, 0, 0, 2};
        Solution.sortColors(test2Array);
        System.out.println(Arrays.toString(test2Array));
    }

}
