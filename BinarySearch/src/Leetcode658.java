import java.util.ArrayList;
import java.util.List;
/**
 * Leetcode 658 - Find K Closest Elements
 */
public class Leetcode658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        List<Integer> res = new ArrayList<>();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        for (int i = left; i < left + k; i++) {
            res.add (arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Leetcode658 Solution = new Leetcode658();

        int[] test1Nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Solution.findClosestElements(test1Nums, 4,-1).toString());
        System.out.println(Solution.findClosestElements(test1Nums, 4,5).toString());
        System.out.println(Solution.findClosestElements(test1Nums, 4,9).toString());


    }
}
