package Methods;

import java.util.Scanner;
public class SimpleConverterRefactored {
    // Shared Scanner instance
        static Scanner scanner = new Scanner(System.in);

        // Converts kilometers to miles
        public static void convertKmToMiles() {
            System.out.println("===== Distance Converter =====");
            System.out.print("Enter a value in km: ");
            double km = scanner.nextDouble();
            double miles = km * 0.62137;
            System.out.println("Miles: " + miles);
        }

        // Converts kilograms to pounds
        public static void convertKgToPounds() {
            System.out.println("===== Weight Converter =====");
            System.out.print("Enter a value in kg: ");
            double kg = scanner.nextDouble();
            double pounds = kg * 2.20462;
            System.out.println("Pounds: " + pounds);
        }


        // Converts Celsius to Fahrenheit
        public static void convertCelsiusToFahrenheit() {
            System.out.println("===== Temperature Converter =====");
            System.out.print("Enter a value in Celsius: ");
            double celsius = scanner.nextDouble();
            double fahrenheit = (celsius * 9 / 5) + 32;
            System.out.println("Fahrenheit: " + fahrenheit);
        }

        // Displays the menu
        public static void showMenu() {
            System.out.println("\n====== Converter Menu ======");
            System.out.println("1. Convert km to miles");
            System.out.println("2. Convert kg to pounds");
            System.out.println("3. Convert Celsius to Fahrenheit");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1–4): ");
        }

        // Main method
        public static void main(String[] args) {
            while (true) {
                showMenu();
                int choice = scanner.nextInt();

                if (choice == 1) {
                    convertKmToMiles();
                } else if (choice == 2) {
                    convertKgToPounds();
                } else if (choice == 3) {
                    convertCelsiusToFahrenheit();
                } else if (choice == 4) {
                    System.out.println("Goodbye... Thank you for using our converter!");
                    break;
                } else {
                    System.out.println("Invalid choice. Please select between 1 and 4.");
                }
            }

            scanner.close();
}
    }


