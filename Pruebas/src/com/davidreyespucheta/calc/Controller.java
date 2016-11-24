/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidreyespucheta.calc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 *
 * @author davidreyespucheta
 */
public class Controller {
    
    private String operator = "";
    private long number1 = 0;
    private long number2 = 0;
    private Model model;
    private boolean start = true;
    
    @FXML
    private Text output;

    public Controller() {
        this.model = new Model();
    }
    
    @FXML
    private void processNumpad(ActionEvent event) {
        
        if(start){
            output.setText("");
            start = false;
        }
        
        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);
        
    }
    
    @FXML
    private void processOperator(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        
        if (!"=".equals(value)){
            if(!operator.isEmpty()){
                return;
            }
            operator = value;
            number1 = Long.parseLong(output.getText());
            output.setText("");
        } else {
            if(operator.isEmpty()){
                return;
            }
            number2 = Long.parseLong(output.getText());
            output.setText(String.valueOf(model.calculate(number1, number2, operator)));
            operator = "";
            start = true;
        }
        
    }
}
