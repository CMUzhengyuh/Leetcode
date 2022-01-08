import java.util.ArrayList;
import java.util.List;
/**
 * Leetcode 163 - Missing Ranges
 */
public class Leetcode163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(lower);
            if (lower != upper) {
                sb.append("->").append(upper);
            }
            res.add(sb.toString());
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && lower < nums[i]) {
                StringBuilder sb = new StringBuilder();
                sb.append(lower);
                if (lower - nums[i] != -1) {
                    sb.append("->").append(nums[i] - 1);
                }
                res.add(sb.toString());
            }
            if (i > 0 && nums[i] - nums[i - 1] != 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i - 1] + 1);
                if (nums[i] - nums[i - 1] != 2) {
                    sb.append("->").append(nums[i] - 1);
                }
                res.add(sb.toString());
            }
            if (i == nums.length - 1 && upper > nums[i]) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i] + 1);
                if (upper - nums[i] != 1) {
                    sb.append("->").append(upper);
                }
                res.add(sb.toString());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode163 Solution = new Leetcode163();

        int[] test1Num = new int[]{0, 1, 2, 3, 5, 8, 50, 75};
        System.out.println(Solution.findMissingRanges(test1Num, 0, 76));
        System.out.println(Solution.findMissingRanges(test1Num, -1, 99));

        int[] test2Num = new int[]{};
        System.out.println(Solution.findMissingRanges(test2Num, 0, 0));
        System.out.println(Solution.findMissingRanges(test2Num, 0, 9));

    }
}
