import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 4th - Leetcode 56 - Merge Intervals
 */
public class MergeIntervals {
    /**
     * Solution: Sorting
     * TC: O(nlogn)
     * SC: O(n)
     */
    public int[][] merge(int[][] intervals) {
        /**
         * Sort the srcArray by the start time
         */
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> list = new ArrayList<>();
        /**
         * Initialize the left pointer at index = 0 and right pointer at index = 1
         */
        int leftStart = intervals[0][0], leftEnd = intervals[0][1];
        int right = 1;
        while(right < intervals.length){
            /**
             * Left & right intervals overlap - update the leftEnd
             */
            if (intervals[right][0] <= leftEnd) {
                leftEnd = Math.max(leftEnd, intervals[right][1]);
            }
            /**
             * Non-overlap intervals - add to list
             */
            else {
                list.add(new int[]{leftStart, leftEnd});
                /**
                 * Left = right
                 */
                leftStart = intervals[right][0];
                leftEnd = intervals[right][1];
            }
            right++;
        }
        list.add(new int[]{leftStart, leftEnd});
        /**
         * Convert List<int[]> to int[][]
         */
        int[][] res = new int[list.size()][];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }
}
