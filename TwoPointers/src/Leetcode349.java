import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Leetcode 349 - Intersection of Two Arrays ***
 */
public class Leetcode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num) && list.indexOf(num) < 0) {
                list.add(num);
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (int i : list) {
            res[index++] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode349 Solution = new Leetcode349();

        int[] test1Array1 = new int[]{1, 1, 1, 2, 2, 3, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7};
        int[] test1Array2 = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(Arrays.toString(Solution.intersection(test1Array1, test1Array2)));
    }
}
