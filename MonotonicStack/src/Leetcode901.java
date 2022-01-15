import java.util.Stack;
/**
 * Leetcode 901 - Online Stock Span
 */
public class Leetcode901 {

    Stack<int[]> stack;

    public Leetcode901() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            span += stack.pop()[1];
        }
        stack.add(new int[]{price, span});
        return span;
    }

    public static void main(String[] args) {
        Leetcode901 Solution = new Leetcode901();

        System.out.println(Solution.next(100));
        System.out.println(Solution.next(80));
        System.out.println(Solution.next(60));
        System.out.println(Solution.next(70));
        System.out.println(Solution.next(60));
        System.out.println(Solution.next(75));
        System.out.println(Solution.next(85));
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */