import java.util.ArrayList;
import java.util.List;
/**
 * Leetcode 1352 - Product of the Last K Numbers
 */
public class Leetcode1352 {

    List<Integer> list;

    int prev;

    public Leetcode1352() {
        list = new ArrayList();
        list.add(1);
        prev = 1;
    }

    public void add(int num) {
        if (num > 0) {
            /**
             * Store current product of existing list
             */
            prev *= num;
            list.add(prev);
        }
        else {
            /**
             * Multiple 0
             */
            list = new ArrayList();
            list.add(1);
            prev = 1;
        }
    }

    public int getProduct(int k) {
        int N = list.size();
        return (k < N) ? prev / list.get(N - 1 - k) : 0;
    }

    public static void main(String[] args) {
        Leetcode1352 Solution = new Leetcode1352();

        Solution.add(3);
        Solution.add(0);
        Solution.add(2);
        Solution.add(5);
        Solution.add(4);
        System.out.println(Solution.getProduct(2));
        System.out.println(Solution.getProduct(3));
        System.out.println(Solution.getProduct(4));
        Solution.add(8);
        System.out.println(Solution.getProduct(2));

    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */