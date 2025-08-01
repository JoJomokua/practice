package loops;

public class reversedStarLoop {
    public static void main(String[] args) {
        int j;
        for (int i = 5;i >= 1;i-- ){
            for (j = 1;j <= i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
