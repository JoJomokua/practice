package Methods;

import java.util.Scanner;

public class ATMsimulator {
    private  double balance = 0;

    public void checkBalance(){
        System.out.println("Your balance is:" + balance);
    }

    public  void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Your request cannot be processed");
        }
        else {
            balance += amount;
            System.out.println("Your deposit was successful ...New balance is:" + balance);
        }
    }

    public void withdraw(double amount){
        if (amount <= 0){
            System.out.println("Withdrawal amount cannot be below zero ");
        } else if (amount < balance) {
            System.out.println("You have insufficient funds");
        }
        else {
            balance -= amount;
            System.out.println("Withdrawal successful...New balance is:" + balance);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATMsimulator atm = new ATMsimulator();//Create an object for non-static methods

        int choice;
        do {
            System.out.println("======ATM MENU ======");
            System.out.println("1. Check balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("Choose an option 1 - 4");
             choice = scanner.nextInt();

            switch (choice){
                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.println("How much do you want to deposit ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    System.out.println("How much do ypu want to withdraw ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Goodbye ...Thank you for using the ATM");
                    break;

                default:
                    System.out.println("Invalid option choose an option 1 - 4");
            }
        }
        while (choice != 4);

        scanner.close();

    }
}
