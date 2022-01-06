/**
 * Leetcode 50 - Pow(x, n)
 */
public class Leetcode50 {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0){
            /**
             * Prevent overflow
             */
            return 1 / x * myPow(1 / x, - (n + 1));
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        Leetcode50 Soltution = new Leetcode50();

        System.out.println(Soltution.myPow(2.000, Integer.MIN_VALUE));
        System.out.println(Soltution.myPow(1.125, 80));
    }

}

