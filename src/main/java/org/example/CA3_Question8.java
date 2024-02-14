package org.example;

import java.util.Scanner;
import java.util.*;

/**
 * Name:
 * Class Group:
 */
public class CA3_Question8 {

    /*
    can use arrayDegue<Integer>
        Reads in an equation from the user
     */
    public static void main(String[] args) {
        String equation = "";

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter equation, (For example, The equation format is (3 4 5 + *), make sure enter a space between each number or symbol):");
//        equation = in.nextLine().trim();
        equation = in.nextLine();

        Stack<Integer> results = new Stack<>();

        int result = 0;
        System.out.println("Process:");
        for (String token : equation.split(" ")) { //represents one or more whitespace characters (such as spaces, tabs, or line breaks).
            if (Character.isDigit(token.charAt(0))) {
                results.push(Integer.parseInt(token));
            } else {
                int number2 = results.pop();
                int number1 = results.pop();
                switch (token) {
                    case "+":
                        result = number1 + number2;
                        break;
                    case "-":
                        result = number1 - number2;
                        break;
                    case "*":
                        result = number1 * number2;
                        break;
                    case "/":
                        result = number1 / number2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }
                results.push(result);
                System.out.println("Popped " + number1 + " and " + number2 + " from the stack. -->  'Symbol' " + token + ". -- > Pushed result " + result + " to the stack.");
            }
        }
        if (!results.isEmpty()) {
            System.out.println("Result: " + results.pop());
        } else {
            System.out.println("No equation provided.");
        }
    }
}

