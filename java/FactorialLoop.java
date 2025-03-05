public class FactorialLoop {
    public static void main(String[] args) {
        System.out.println("Factorials (Using Loop):");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "! = " + factorial(i));
        }
    }

    static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
