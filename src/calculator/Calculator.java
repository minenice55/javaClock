/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.Scanner;

/**
 *
 * @author minenice
 */
public class Calculator {
    private double num1;
    private double num2;
    private double operator;

    public Calculator() {
        this.num1 = Double.NaN;
        this.num2 = Double.NaN;
        this.operator = 0;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getOperator() {
        return operator;
    }

    public void setOperator(double operator) {
        this.operator = operator;
    }
    
    public void inputNum() {
        Scanner input = new Scanner(System.in);
        if (num1 == Double.NaN) {
            System.out.print("Input the first number: ");
            setNum1(input.nextDouble());
        }
        else if (operator == 0) {
            System.out.print("Input the operator: ");
            setOperator(input.nextLine().charAt(0));
        }
        else {
            System.out.print("Input the second number: ");
            setNum2(input.nextDouble());
        }
    }
}