package Queues;

import java.util.Scanner;

public class BankQueuingSystem {

    // ================= NODE =================
    static class BankCustomerNode {
        String customerID;
        String customerName;
        String serviceType;
        int tokenNumber;
        BankCustomerNode next;

        public BankCustomerNode(String customerID, String customerName,
                                String serviceType, int tokenNumber) {
            this.customerID = customerID;
            this.customerName = customerName;
            this.serviceType = serviceType;
            this.tokenNumber = tokenNumber;
            this.next = null;
        }
    }

    // ================= QUEUE =================
    static class BankQueue {
        private BankCustomerNode front;
        private BankCustomerNode rear;
        private int size;
        private int nextToken = 1001;

        public void joinQueue(String customerName, String serviceType) {
            int token = nextToken++;
            BankCustomerNode newCustomer =
                    new BankCustomerNode("C" + token, customerName, serviceType, token);

            if (front == null) {
                front = rear = newCustomer;
            } else {
                rear.next = newCustomer;
                rear = newCustomer;
            }

            size++;
            System.out.println("Customer " + customerName +
                    " joined queue. Token: " + token);
        }

        public void serveCustomer() {
            if (front == null) {
                System.out.println("No customers in queue");
                return;
            }

            BankCustomerNode served = front;
            front = front.next;

            if (front == null) rear = null;

            size--;
            System.out.println("\nServing: " + served.customerName +
                    " | Token: " + served.tokenNumber +
                    " | Service: " + served.serviceType + "\n");
        }

        public void displayQueue() {
            if (front == null) {
                System.out.println("Queue is empty");
                return;
            }

            BankCustomerNode current = front;
            int pos = 1;

            System.out.println("\nQueue Status:");
            while (current != null) {
                System.out.println(pos++ + ". " +
                        current.customerName + " (" + current.serviceType + ")");
                current = current.next;
            }
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankQueue bankQueue = new BankQueue();

        while (true) {
            System.out.println("\n1. New Customer");
            System.out.println("2. Serve Customer");
            System.out.println("3. View Queue");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Customer name: ");
                    String name = scanner.nextLine();
                    bankQueue.joinQueue(name, "General Service");
                    break;

                case 2:
                    bankQueue.serveCustomer();
                    break;

                case 3:
                    bankQueue.displayQueue();
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
