/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidreyespucheta.calc;

/**
 *
 * @author davidreyespucheta
 */
public class Model {
    
    public long calculate(long number1, long number2, String operator){
        switch(operator){
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 == 0){
                    return 0; //Or division by 0 exception
                }
                return number1 / number2;
        }
        
        System.out.println("Unknown operator - " + operator);
        return 0;
    }
    
    
}
