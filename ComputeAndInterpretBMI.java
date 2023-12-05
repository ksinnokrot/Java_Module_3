import java.util.Scanner;

public class ComputeAndInterpretBMI {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter weight in pounds
        System.out.print("Enter weight in pounds: ");
        double weightInPounds = scanner.nextDouble();

        // Prompt the user to enter feet and inches
        System.out.print("Enter feet: ");
        int feet = scanner.nextInt();

        System.out.print("Enter inches: ");
        int inches = scanner.nextInt();

        // Close the Scanner to avoid resource leak
        scanner.close();

        // Convert feet and inches to meters
        double heightInMeters = convertToMeters(feet, inches);

        // Calculate BMI
        double bmi = calculateBMI(weightInPounds, heightInMeters);

        // Display the result
        System.out.println("BMI is " + bmi);
        interpretBMI(bmi);
    }

    // Method to convert feet and inches to meters
    private static double convertToMeters(int feet, int inches) {
        final double INCHES_TO_METERS_CONVERSION = 0.0254;
        double totalInches = feet * 12 + inches;
        return totalInches * INCHES_TO_METERS_CONVERSION;
    }

    // Method to calculate BMI
    private static double calculateBMI(double weightInPounds, double heightInMeters) {
        final double KILOGRAMS_PER_POUND = 0.45359237;
        return weightInPounds * KILOGRAMS_PER_POUND / (heightInMeters * heightInMeters);
    }

    // Method to interpret BMI and display the corresponding category
    private static void interpretBMI(double bmi) {
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi < 25) {
            System.out.println("Normal");
        } else if (bmi < 30) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}
