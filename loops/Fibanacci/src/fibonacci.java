public class fibonacci {
    public static void main(String[] args) {
        int num1 = 0, num2 = 1;

        System.out.println(num1);
        System.out.println(num2);

        for (int i = 0; i < 8; i++) {
            int sum = num1 + num2;
            System.out.println(sum);

            num1 = num2;
            num2 = sum;
        }
}
}
