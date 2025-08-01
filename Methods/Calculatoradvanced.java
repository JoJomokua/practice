package Methods;

import java.util.Scanner;

public class Calculatoradvanced {

    //Method to add two numbers
    public static double add(double a,double b){
        return a + b;
    }
    //Method to subtract two numbers
    public static double subtract(double a,double b) {
        return a - b;
    }
    //Method to multiply two numbers
    public static double multiply(double a,double b) {
        return a * b;
    }
    //Method to divide two numbers
    public static double divide(double a,double b) {

        if (b == 0){
            System.out.println("Error;2nd double cannot be 0");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

       while (keepRunning) {
           System.out.println("=".repeat(30));
           System.out.println("WELCOME TO OUR SIMPLE CALCULATOR");
           System.out.println("1. Add");
           System.out.println("2. Subtract");
           System.out.println("3. Multiply");
           System.out.println("4. Divide");
           System.out.println("5. Exit");

           System.out.println("Enter choice (1 -5):");
           int choice = scanner.nextInt();

           if (choice == 5) {
               keepRunning = false;
               System.out.println("Goodbye");
               break;
           }

           System.out.println("Enter first number");
           double num1 = scanner.nextDouble();

           System.out.println("Enter first number");
           double num2 = scanner.nextDouble();

           double result = 0;

           switch (choice) {
               case 1:
                   result = add(num1, num2);
                   break;
               case 2:
                   result = subtract(num1, num2);
                   break;
               case 3:
                   result = multiply(num1, num2);
                   break;
               case 4:
                   result = divide(num1, num2);
                   break;
               default:
                   System.out.println("Invalid choice");
           }
           System.out.println("result:" + result);

           scanner.close();
       }
    }
}
