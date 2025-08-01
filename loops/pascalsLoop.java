package loops;

public class pascalsLoop {
    public static void main(String[] args) {
        int rows = 6;
        for (int i = 0; i < rows; i++) {
            // Print leading spaces for alignment
            for (int k = 0; k < rows - i; k++) {
                System.out.print(" ");
            }
            int number = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(number + " ");
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}
