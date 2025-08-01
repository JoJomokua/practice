package Arrays;

import java.util.Arrays;

public class OneDArray {
    public static void main(String[] args) {
        int[] marks = {45,46,56,78};

        System.out.println("Student 1: " + marks[0]);
        System.out.println("Student 2: " + marks[1]);
        System.out.println("Student 3: " + marks[2]);
        System.out.println("Student 4: " + marks[3]);

      // double sum = marks[0] + marks[1] + marks[2] + marks[3];
       //double average = sum/4;*
        double average = Arrays.stream(marks).average().orElse(0);

        System.out.println();
        System.out.println("Average = " + average);
    }
}
