import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        final int pin = 1234; // Set your correct PIN
        int attempts = 3; // Maximum attempts allowed
        Scanner scanner = new Scanner(System.in);
        
        while (attempts > 0) {
            System.out.print("Enter your PIN: ");
            int enteredPin = scanner.nextInt();
            
            if (enteredPin == pin) {
                System.out.println("PIN Verified. Access Granted!");
                return; // Exit the program
            } else {
                attempts--;
                if (attempts > 0) {
                    System.out.println("Incorrect PIN. You have " + attempts + " attempts left.");
                } else {
                    System.out.println("Incorrect PIN. Your account is locked.");
                }
            }
        }
    }
}
