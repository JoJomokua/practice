package Methods;

import java.util.Scanner;

public class StudentGradeSAnalyzer {

    public  static String calculateGrade(int score){
        if (score >= 70 && score < 100 ){
            return "A";

        } else if (score >= 60 && score <70) {
            return "B";

        } else if (score >= 50 && score < 60) {
            return "C";

        } else if (score >= 40 && score < 50) {
            return "D";

        } else if (score < 0) {
            return "System only accepts score between 0 and 100";

        } else {
            return "F";
        }
    }
    public static void displayResult( String name,int score, String grade){
        System.out.println("Your name is:" + name);
        System.out.println("Your score is:" + score);
        System.out.println("your grade is:" + grade);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many students do you want to enter?");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        for (int i =1;i <= numberOfStudents; i++) {
            System.out.println("\nStudent" + i + ":");

            System.out.println("Enter your name");
           String name = scanner.nextLine();

        System.out.println("Enter your score");
        int score = scanner.nextInt();
        scanner.nextLine();

        String grade = calculateGrade( score);
        displayResult(name, score,grade);
        }
        scanner.close();

    }
}