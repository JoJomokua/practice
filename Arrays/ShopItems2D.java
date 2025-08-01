package Arrays;

import java.util.Scanner;

public class ShopItems2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many days do you want to enter?");
        int days = scanner.nextInt();

        System.out.println("How many items do you want to enter?");
        int items = scanner.nextInt();

        double[][] shop = new double[days][items];

        for (int i = 0; i < days; i ++){
            System.out.println("Enter days you want to take record" + (i + 1) +": ");

            for (int j = 0; j < items; j ++){
                System.out.println("Enter items you want to record" + (j + 1) + ": ");

                shop[i][j] = scanner.nextInt();
            }
        }
        System.out.println("=== Shop stock ===");
        for (int i = 0;i < days; i++){
            System.out.println("Days" + (i + 1) +": ");

            for (int j = 0; j < items; j ++) {
                System.out.println(shop[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
