import java.util.Scanner;

public class Remember {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name? ");
        String name = scanner.nextLine();
        System.out.println("What is your age?");
        int age = scanner.nextInt();
        System.out.println("Hello " +name+ " Welcome aboard");
        System.out.println("You are "+ age + " years old.");

        if (age>20) {
            System.out.println("Welcome to our program");
        } else {
            System.out.println("your age is below the limit...you cannot access our program");
        }




    }
}
