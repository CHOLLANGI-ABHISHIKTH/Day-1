public class AddStrings {
    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;
            int sum = digit1 + digit2 + carry;

            carry = sum / 10;
            result.append(sum % 10);

            i--; 
            j--;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println("Sum: " + addStrings(num1, num2));
    }
}