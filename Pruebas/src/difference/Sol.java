package difference;


import java.util.Scanner;

class Difference {
    private int[] elements;
    public int maximumDifference;
    // Add your code here
    Difference(int[] arr){
        this.elements = arr;
    }

    public void computeDifference(){
        int diff = 0;
        maximumDifference = 0;
        for (int i = elements.length -1; i > 0; i--){    
            for (int j = 0; j < elements.length; j++){
               diff = Math.abs(elements[i] - elements[j]);
                if (diff > maximumDifference){
                    maximumDifference = diff;
                } 
            }
        }
    } 
}

public class Sol {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}