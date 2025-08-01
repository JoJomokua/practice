package loops;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {

        Random random = new Random();

        int secretNumber = random.nextInt(100) +1;
        int Guess =0;
        int count = 0;

        Scanner scanner = new Scanner(System.in);

        while (Guess!= secretNumber) {

            System.out.println("What is your guess? ");
            Guess = scanner.nextInt();
            count ++;

           // System.out.println(secretNumber);

            if (Guess > secretNumber){
                System.out.println("Too high!Try again");
            }

            else if (Guess < secretNumber) {
                System.out.println("Too low!Try again");
            }


            else if (Guess == secretNumber) {
                System.out.println("Congrats!You won\uD83C\uDF89 😁");
                System.out.println("number of tries are " + count);
            }

        }
    }
}
