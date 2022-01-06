import java.util.Arrays;

/**
 * Leetcode 287 - Find the Duplicate Number ***
 */
public class Leetcode287 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        Leetcode287 Solution = new Leetcode287();

        int[] test1Array = new int[]{1, 4, 2, 4, 3};
        System.out.println(Solution.findDuplicate(test1Array));

        int[] test2Array = new int[]{3, 1, 3, 4, 2};
        System.out.println(Solution.findDuplicate(test2Array));
    }
}
