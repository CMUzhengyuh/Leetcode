import java.util.Arrays;

/**
 * Leetcode 88 - Merge Sorted Array
 */
public class Leetcode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, p = nums1.length - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums2[p2] > nums1[p1]) {
                nums1[p--] = nums2[p2--];
            } else {
                nums1[p--] = nums1[p1--];
            }
        }
        if (p2 >= 0) {
            /**
             * System.arraycopy(Object[] srcArr, int srcPos, Object[] destArr, int destPos, int copyLength)
             * p2 is index - copyLength = p2 + 1
             */
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }

    public static void main(String[] args) {
        Leetcode88 Solution = new Leetcode88();

        int[] test1Array1 = new int[]{0};
        int[] test1Array2 = new int[]{1};

        Solution.merge(test1Array1, 0, test1Array2, 1);
        System.out.println(Arrays.toString(test1Array1));

        Solution.merge(test1Array2, 0, test1Array1, 1);
        System.out.println(Arrays.toString(test1Array1));

        int[] test2Array1 = new int[]{1, 3, 5, 7, 9, 0, 0, 0, 0};
        int[] test2Array2 = new int[]{2, 4, 6, 8};
        Solution.merge(test2Array1, 5, test2Array2, 4);
        System.out.println(Arrays.toString(test2Array1));
    }
}
