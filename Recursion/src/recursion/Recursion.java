package recursion;

public class Recursion {
    
    /**
     *
     * @param n
     * @return
     */
    public static int summation (int n){
        // Base case: We are at the end
        if (n <= 0){
            return 0;
        }
        //Recursive case: Keep Going!
        else {
            return n + summation(n-1);
        }
    }
    
    public static int factorial(int n) {
        //Base case:
        if (n<=1){
            return 1;
        }
        //Recursive case
        else{
            return n * factorial(n-1);
        }
    }
    
    public static int exponentiation(int n, int p ){
        //Base case:
        if (p <= 0){
            return 1;
        }
        //recursive case:
        else{
            return n * exponentiation(n, p-1);
        }
    }

    public static void main(String[] args) {
        
        int x = summation(3);
        System.out.println(x);
        
        int y = factorial(4);
        System.out.println(y);
        
        int z = exponentiation(5, 4);
        System.out.println(z);
        
    }
    

    
}
