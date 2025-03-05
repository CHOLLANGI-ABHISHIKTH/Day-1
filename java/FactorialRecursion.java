public class FactorialRecursion {
    public static void main(String[] args) {
        System.out.println("Factorials (Using Recursion):");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "! = " + factorial(i));
        }
    }

    static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }
}
