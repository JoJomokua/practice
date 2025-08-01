package Arrays;

import java.util.Scanner;

public class TemperatureTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many days do you want to track temperatures for?");
        int days = scanner.nextInt();

        double[] temperatures = new double[days];

        for (int i = 0;i < days; i++){
            System.out.println("Enter temperatures for day" + (i +1) + ":");
            temperatures[i] = scanner.nextDouble();
        }
        double sum = 0;
        double highest = temperatures[0];
        double lowest = temperatures[0];

        for (double i : temperatures){
            sum += i;
            if (i > highest) highest = i;
            if (i < lowest) lowest = i;
        }

        double average = sum/days;

        System.out.println("\n=== Temperature Report ===");
        System.out.println("Average temperature:" + average);
        System.out.println("Highest temperature:" + highest);
        System.out.println("Lowest temperature:" + lowest);

        scanner.close();
    }
}
