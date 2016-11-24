package BubbleSort;

import java.util.*;

public class BubbleSort {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int totalSwaps = 0;
        int n = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int numberOfSwaps = 0;

            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    totalSwaps++;
                    numberOfSwaps++;
                }
            }

            if (numberOfSwaps == 0) {
                break;
            }

        }
        System.out.println("Array is sorted in " + totalSwaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[n - 1]);

    }

}
