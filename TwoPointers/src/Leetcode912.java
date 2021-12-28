import java.util.Arrays;
import java.util.PriorityQueue;
/**
 * Leetcode 912 - Sort an Array
 */
public class Leetcode912 {

    /**
     * HeapSort - In-place & Unstable
     * Time Complexity: Average - O(nlogn), Worst - O(nlogn), Best - O(nlogn)
     * Space Complexity: O(1)
     */
    public int[] heapSort(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = pq.poll();
        }
        return nums;
    }

    /**
     * MergeSort - Out-place & Stable
     * Time Complexity: Average - O(nlogn), Worst - O(nlogn), Best - O(nlogn)
     * Space Complexity: O(n)
     */
    public int[] mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, right);
    }

    private void merge(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid || j <= right) {
            if (i > mid || j <= right && nums[i] > nums[j]) {
                temp[k++] = nums[j++];
            } else {
                temp[k++] = nums[i++];
            }
        }
        System.arraycopy(temp, 0, nums, left, right - left + 1);
    }

    /**
     * QuickSort - In-place & Unstable
     * Time Complexity: Average - O(nlogn), Worst - O(n^2), Best - O(nlogn)
     * Space Complexity: O(logn)
     */
    public int[] quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = partition(nums, left, right);
        quickSort(nums, left, mid);
        quickSort(nums, mid + 1, right);
    }
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        Leetcode912 Solution = new Leetcode912();

        int[] test1Array = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(Solution.heapSort(test1Array)));
        System.out.println(Arrays.toString(Solution.mergeSort(test1Array)));
        System.out.println(Arrays.toString(Solution.quickSort(test1Array)));

    }
}
