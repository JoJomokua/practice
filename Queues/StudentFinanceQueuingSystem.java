package Queues;

import java.util.Scanner;

public class StudentFinanceQueuingSystem {

    // ================= STUDENT NODE =================
    static class StudentNode {
        String studentID;
        String studentName;
        String department;
        String inquiryType;
        int priority; // 1=High, 2=Medium, 3=Low
        StudentNode next;

        public StudentNode(String studentID, String studentName,
                           String department, String inquiryType, int priority) {
            this.studentID = studentID;
            this.studentName = studentName;
            this.department = department;
            this.inquiryType = inquiryType;
            this.priority = priority;
            this.next = null;
        }
    }

    // ================= PRIORITY QUEUE =================
    static class FinanceQueue {
        private StudentNode front;
        private StudentNode rear;
        private int size = 0;

        public void addStudent(String id, String name, String dept,
                               String inquiry, int priority) {

            StudentNode newStudent =
                    new StudentNode(id, name, dept, inquiry, priority);

            if (front == null) {
                front = rear = newStudent;
            } else if (priority < front.priority) {
                newStudent.next = front;
                front = newStudent;
            } else {
                StudentNode current = front;
                while (current.next != null &&
                        current.next.priority <= priority) {
                    current = current.next;
                }
                newStudent.next = current.next;
                current.next = newStudent;

                if (newStudent.next == null) {
                    rear = newStudent;
                }
            }

            size++;
            System.out.println("Student added successfully.");
        }

        public void serveNextStudent() {
            if (front == null) {
                System.out.println("Queue is empty");
                return;
            }

            StudentNode served = front;
            front = front.next;

            if (front == null) rear = null;
            size--;

            System.out.println("\nNOW SERVING:");
            System.out.println(served.studentName +
                    " | " + served.studentID +
                    " | " + served.inquiryType);
        }

        public void searchStudent(String id) {
            StudentNode current = front;
            int pos = 1;

            while (current != null) {
                if (current.studentID.equals(id)) {
                    System.out.println("Found at position " + pos);
                    return;
                }
                current = current.next;
                pos++;
            }
            System.out.println("Student not found");
        }

        public void removeStudent(String id) {
            if (front == null) {
                System.out.println("Queue empty");
                return;
            }

            if (front.studentID.equals(id)) {
                front = front.next;
                size--;
                System.out.println("Student removed");
                return;
            }

            StudentNode current = front;
            while (current.next != null &&
                    !current.next.studentID.equals(id)) {
                current = current.next;
            }

            if (current.next == null) {
                System.out.println("Student not found");
                return;
            }

            current.next = current.next.next;
            size--;
            System.out.println("Student removed");
        }

        public void displayQueue() {
            if (front == null) {
                System.out.println("Queue is empty");
                return;
            }

            StudentNode current = front;
            int pos = 1;

            while (current != null) {
                System.out.println(pos++ + ". " +
                        current.studentName +
                        " (" + current.studentID + ")" +
                        " Priority: " + current.priority);
                current = current.next;
            }
        }

        public int getQueueSize() {
            return size;
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FinanceQueue queue = new FinanceQueue();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Serve Student");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Display Queue");
            System.out.println("6. Queue Size");
            System.out.println("7. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Department: ");
                    String dept = scanner.nextLine();
                    System.out.print("Inquiry: ");
                    String inquiry = scanner.nextLine();
                    System.out.print("Priority (1-High, 2-Medium, 3-Low): ");
                    int p = scanner.nextInt();
                    scanner.nextLine();

                    queue.addStudent(id, name, dept, inquiry, p);
                    break;

                case 2:
                    queue.serveNextStudent();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    queue.searchStudent(scanner.nextLine());
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    queue.removeStudent(scanner.nextLine());
                    break;

                case 5:
                    queue.displayQueue();
                    break;

                case 6:
                    System.out.println("Queue size: " + queue.getQueueSize());
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
