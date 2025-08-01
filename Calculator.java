import java.util.Scanner;

public class Calculator {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to the Calculator!");
            System.out.println("This program can perform basic arithmetic operations: addition, subtraction, multiplication, and division.");
            System.out.println("Please follow the prompts to enter your numbers and the operation you wish to perform.");
            System.out.println("Let's get started!");

            System.out.print("Enter the first number: ");
            Double a = scanner.nextDouble();

            System.out.print("Choose an operation (+, -, *, /): ");
            char operation = scanner.next().charAt(0);

            System.out.print("Enter the second number: ");
            Double b = scanner.nextDouble();

            Double result;

            switch (operation) {
                case '+':
                    result = a + b;
                    System.out.println("Result: " + result);
                    break;

                case '-':
                    result = a - b;
                    System.out.println("Result: " + result);
                    break;

                case '*':
                    result = a * b;
                    System.out.println("Result: " + result);
                    break;

                case '/':
                    if (b != 0) {
                        result = a / b;
                        System.out.println("Result: " + result);
                    } else {
                        System.out.println("Error... second number cannot be zero.");
                    }
                    break;

                default:
                    System.out.println("Invalid operator");
            }

            scanner.close();
        }
    }

