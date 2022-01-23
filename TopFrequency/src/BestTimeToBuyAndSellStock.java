import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 14th - Leetcode 121 - Best Time to Buy and Sell Stock
 */
public class BestTimeToBuyAndSellStock {
    /**
     * Solution: Traversal
     * TC: O(n)
     * SC: O(1)
     */
    public int maxProfit(int prices[]) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            /**
             * Choose the minimum price to buy
             */
            if (prices[i] < min)
                min = prices[i];
            /**
             * Choose the maximum price to sell (must keep one stock at hand)
             */
            else if (prices[i] - min > res)
                res = prices[i] - min;
        }
        return res;
    }
}
