import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * Leetcode 350 - Intersection of Two Arrays II
 */
public class Leetcode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int index = 0;
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                nums1[index++] = num;
                map.put(num, map.get(num) - 1);
            }
        }
        /**
         * Arrays.copyOfRange(int[] srcArr, int startIndex, int endIndex)
         * A copy of srcArr index range: [startIndex, endIndex)
         */
        return Arrays.copyOfRange(nums1, 0, index);
    }

    public static void main(String[] args) {
        Leetcode350 Solution = new Leetcode350();

        int[] test1Array1 = new int[]{1, 1, 1, 2, 2, 3, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7};
        int[] test1Array2 = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(Arrays.toString(Solution.intersect(test1Array1, test1Array2)));
    }
}
