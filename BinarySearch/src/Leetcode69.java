public class Leetcode69 {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int left = 1, right = x, res = 0;
        while (left < right) {
            int mid = left + (right - left) / 2, div = x / mid;
            if (div == mid) return mid;
            if (div < mid) {
                right = mid;
            } else {
                res = mid;
                left = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode69 Solution = new Leetcode69();

        System.out.println(Solution.mySqrt(0));

        System.out.println(Solution.mySqrt(1));

        System.out.println(Solution.mySqrt(4));

        System.out.println(Solution.mySqrt(8));

        System.out.println(Solution.mySqrt(Integer.MAX_VALUE));

    }
}
