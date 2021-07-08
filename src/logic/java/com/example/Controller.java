package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label lblResult;
    @FXML
    private Label lblOperation;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnSub;
    @FXML
    private Button btnMul;
    @FXML
    private Button btnDot;
    @FXML
    private Button btnDiv;
    @FXML
    private Button btnLogTen;
    @FXML
    private Button btnLogNatural;
    @FXML
    private Button btnClearOne;
    @FXML
    private Button btnEqn;



    private String operation = "=";
    private Double numberOne = 0.0;
    private Double numberTwo = 0.0;
    private Double result = 0.0;
    private String valueLog;
    private Boolean impossible = false;



    @FXML//cancella tutto
    private void onClickClear() {
        lblResult.setText("0");
        numberTwo = 0.0;
        numberOne = 0.0;
        operation = "=";
        lblOperation.setText("");

    }

    @FXML//somma
    private void onClickAdd() {
        operation();
        operation = "+";
        if(numberOne!=null) {
            lblOperation.setText(numberOne+" "+operation);
            }
    }


    @FXML//sottrazione
    private void onClickSub() {
        operation();
        operation = "-";
        if(numberOne!=null) {
            lblOperation.setText(numberOne+" "+operation);
            }
    }

    @FXML//moltiplicazione
    private void onClickMul() {
        operation();
        operation = "*";
        if(numberOne!=null) {
        lblOperation.setText(numberOne+" "+operation);
        }


    }

    @FXML//divisione
    private void onClickDiv() {
        operation();
        operation = "/";
        if(numberOne!=null) {
            lblOperation.setText(numberOne+" "+operation);
            }

    }
    @FXML
    void onClickLogNatural() {
        operation = "ln";
        valueLog= operation+" ("+lblResult.getText()+")";
        lblOperation.setText(valueLog);
        operation();
        onClickEqn();

    }

    @FXML
    void onClickLogTen() {
        operation = "log_10";
        valueLog = operation+" ("+lblResult.getText()+")";
        lblOperation.setText(valueLog);
        operation();
        onClickEqn();
    }



    @FXML//punto
    private void onClickDot() {
        if (!lblResult.getText().contains(".")) {
            lblResult.setText(lblResult.getText() + ".");
        }
    }


    @FXML
    void onClickClearOne() {
        var text = lblResult.getText();
        if(!lblResult.getText().equals("0")) {
        	lblResult.setText(text.substring(0,text.length()-1));
        }
        if(lblResult.getText().length()==0) {
        	lblResult.setText("0");
        }
    }


    private void operation() {
        var value = Double.parseDouble(lblResult.getText());

        lblResult.setText("0");
        switch (operation) {
            case "+" : numberOne = numberOne + value;break;
            case "*" : numberOne = numberOne * value;break;
            case "-" : numberOne = numberOne - value;break;
            case "/" : numberOne = numberOne / value; break;
            case "ln" :{
                if(value>0.0) {
                    numberOne = Math.log(value);
                    impossible = false;
                }
                else{
                    impossible = true;
                }
            } break;
            case "log_10" :{
                if(value>0.0) {
                    numberOne = Math.log10(value);
                    impossible = false;
                }
                else{
                    impossible = true;
                }
            }break;
            default : numberOne = value;break;
        }
    }

    @FXML//uguale
    private void onClickEqn() {
        if (!operation.equals("=")) {
            numberTwo = Double.valueOf(lblResult.getText());
            switch (operation) {
                case "+" : result = numberOne + numberTwo;break;
                case "*" : result = numberOne * numberTwo;break;
                case "-" : result = numberOne - numberTwo;break;
                case "/" : {
                    if(numberTwo!=0.0) {
                        result = numberOne / numberTwo;
                    }
                    else{
                        impossible = true;
                        lblResult.setText("0");
                        numberTwo = 0.0;
                        numberOne = 0.0;
                        operation = "=";
                        lblOperation.setText("Impossible");
                        change(true);
                    }
                }break;
                default : result = numberOne;break;
            }
            if(!impossible) {
                if(operation.equals("ln") || operation.equals("log_10")){
                    lblOperation.setText(valueLog);
                }
                else {
                    lblOperation.setText(numberOne + " " + operation + " " + numberTwo + " =");
                }

                lblResult.setText(String.valueOf(result));
                operation = "=";
            }
            else{
                impossible = false;
                lblResult.setText("0");
                numberTwo = 0.0;
                numberOne = 0.0;
                operation = "=";
                lblOperation.setText("Impossible");
                change(true);
            }

        }

    }

    private void change(Boolean value) {
        btnAdd.setDisable(value);
        btnClear.setDisable(value);
        btnDiv.setDisable(value);
        btnDot.setDisable(value);
        btnMul.setDisable(value);
        btnSub.setDisable(value);
        btnLogTen.setDisable(value);
        btnLogNatural.setDisable(value);
        btnClearOne.setDisable(value);
        btnEqn.setDisable(value);
        if(!value){
            lblOperation.setText("");
        }
    }


    @FXML
    private void onClick1() {
        insertNumber("1");
    }

    @FXML
    private void onClick2() {
        insertNumber("2");
    }

    @FXML
    private void onClick3() {
        insertNumber("3");

    }

    @FXML
    private void onClick4() {
        insertNumber("4");
    }

    @FXML
    private void onClick5() {
        insertNumber("5");

    }

    @FXML
    private void onClick6() {
        insertNumber("6");

    }

    @FXML
    private void onClick7() {
        insertNumber("7");

    }

    @FXML
    private void onClick8() {
        insertNumber("8");

    }


    @FXML
    private void onClick9() {
        insertNumber("9");
    }

    @FXML
    private void onClick0() {
        if (!lblResult.getText().equals("0")) {
            lblResult.setText(lblResult.getText() + "0");
        }
    }

    private void insertNumber(String number){
        change(false);
        if (lblResult.getText().equals("0")) {
            lblResult.setText(number);
        }  else {
            lblResult.setText(lblResult.getText() + number);
        }
    }


}
