package fractioncalcapp;

import java.util.Scanner;

public class FractionCalculatorApp {

    private static String getOperation(Scanner input) {
        System.out.print("Please choose an operation (+, -, /, *, = or Q to quit): ");
        String operator = input.nextLine();

        while (!operator.equals("+") && !operator.equals("-") && !operator.equals("/") && !operator.equals("*") && !operator.equals("=")) {
            System.out.println("Invalid input (+, -, /, *, = or Q to quit): ");
            operator = input.nextLine();
        }
        return operator;
    }

    private boolean validFraction(String input) {
        boolean isValid = false;

        if(input.contains("/")) {
            String num = input.substring(0, input.indexOf("/"));
            String den = input.substring(input.indexOf("/"));

            if(isNumber(num) && isNumber(den)) {
                isValid = true;
            }
        } else if(isNumber(input)) {
            isValid = true;
        }

        return isValid;
    }

    private boolean isNumber(String input) {
        boolean isNum = false;
        String regex = "[-]?\\d+";

        if(input.matches(regex)) {
            isNum = true;
        }

        return isNum;
    }

    private Fraction getFraction(Scanner input) {
        int num = 0;
        int den = 0;
        System.out.print("Please enter a fraction (a/b) or an integer (a): ");
        String fraction = input.nextLine();

        while (!validFraction(fraction)) {
            System.out.print("Invalid fraction. Please enter a fraction (a/b) or an integer (a), where a and b are integers and b is not zero: ");
            fraction = input.nextLine();
        }

        if(fraction.contains("/")) {
            num = Integer.parseInt(fraction.substring(0, fraction.indexOf("/")));
            den = Integer.parseInt(fraction.substring(fraction.indexOf("/")));
        } else {
            num = Integer.parseInt(fraction);
        }

        return new Fraction(num, den);
    }

    public static void main(String[] args) {
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        System.out.println("--------------------------------------------------------------------------------");

    }//end main
}
