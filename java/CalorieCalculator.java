import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalorieCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        Map<String, Double> metValues = new HashMap<>();
        metValues.put("Running", 10.0);
        metValues.put("Cycling", 8.9);
        metValues.put("Swimming", 8.0);
        metValues.put("Basketball", 8.0);
        metValues.put("Pilates", 3.0);
        metValues.put("Rock Climbing", 7.5);
        metValues.put("Hiking", 6.5);
        metValues.put("Kickboxing", 7.0);
        metValues.put("Rowing", 7.5);
        metValues.put("Elliptical", 7.0);

        
        System.out.print("Enter activity name: ");
        String activity = scanner.nextLine();

        System.out.print("Enter duration in minutes: ");
        double duration = scanner.nextDouble();

        
        if (metValues.containsKey(activity)) {
            double met = metValues.get(activity);
            double caloriesBurned = met * duration;

           
            System.out.println("Calories Burned: " + Math.round(caloriesBurned));
        } else {
            System.out.println("Activity not found! Please enter a valid activity.");
        }

        scanner.close();
    }
}