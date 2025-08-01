package Methods;

import java.util.Scanner;

public class SimpleConverter {

    public void convertKmToMiles() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Welcome to your distance converter =====");
        System.out.println("Enter a value in km");
        double km = scanner.nextDouble();

        double miles = km * 0.62137;
        System.out.println("Miles :" + miles);
    }

    public void convertKgToPounds() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Welcome to yor weight converter =====");
        System.out.println("Enter a value in kg");
        double kg = scanner.nextDouble();

        double pounds = kg * 2.20462;
        System.out.println("pounds :" + pounds);
    }

    public void convertCelsiusToFahrenheit() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Welcome to your temperature converter =====");
        System.out.println("Enter a value in celsius");
        double celsius = scanner.nextDouble();

        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println("Fahrenheit :" + fahrenheit);
    }

    public void showMenu() {
        System.out.println("====== Converter Menu ======");
        System.out.println("Choose a conversion");
        System.out.println("1. Convert km to miles");
        System.out.println("2. Convert kg to pounds");
        System.out.println("3. Convert celsius to fahrenheit");
        System.out.println("4. Exit");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            SimpleConverter cnv = new SimpleConverter();
            cnv.showMenu();

            System.out.println("Choose a choice 1- 4");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // simpleConverter cnv = new simpleConverter();
                cnv.convertKmToMiles();
            } else if (choice == 2) {
                //   simpleConverter cnv = new simpleConverter();
                cnv.convertKgToPounds();
            } else if (choice == 3) {
                //    simpleConverter cnv = new simpleConverter();
                cnv.convertCelsiusToFahrenheit();
            } else if (choice == 4) {
                System.out.println("Goodbye...Thank you for using our system");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }
}
