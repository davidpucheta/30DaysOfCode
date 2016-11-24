/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OddEven;

import java.util.Scanner;

/**
 *
 * @author davidreyespucheta
 */
public class OddEven {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        String[] palabras = new String[q];
        
        for (int i = 0; i < q; i++){
           palabras[i] = scanner.next();
        }
        
        for (int i = 0; i < q; i++){
           String odd = "";
           String even = "";
           char[] p = palabras[i].toCharArray();
            
            for (int j = 0; j < p.length; j++){
                if ( j%2 == 0 ){
                    odd += p[j];
                }else{
                    even += p[j];
                }
                
            }
            System.out.println(odd + " " + even);
        }
        
    }

    
}
