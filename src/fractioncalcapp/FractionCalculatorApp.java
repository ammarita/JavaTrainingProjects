package fractioncalcapp;

import java.util.Scanner;

public class FractionCalculatorApp {

    private static String getOperation(Scanner input) {
        String operator = input.nextLine();

        while (!operator.equals("+") && !operator.equals("-") && !operator.equals("/") && !operator.equals("*") && !operator.equals("=") && !operator.equalsIgnoreCase("q")) {
            System.out.println("Invalid input (+, -, /, *, = or Q to quit): ");
            operator = input.nextLine();
        }
        return operator;
    }

    private static boolean validFraction(String input) {
        boolean isValid = false;

        if(input.contains("/")) {
            String num = input.substring(0, input.indexOf("/"));
            String den = input.substring(input.indexOf("/") + 1);

            if(isNumber(num) && isNumber(den)) {
                isValid = true;
            }
        } else if(isNumber(input)) {
            isValid = true;
        }

        return isValid;
    }

    private static boolean isNumber(String input) {
        boolean isNum = false;
        String regex = "[-]?\\d+";

        if(input.matches(regex)) {
            isNum = true;
        }

        return isNum;
    }

    private static Fraction getFraction(Scanner input) {
        int num;
        int den;
        System.out.print("Please enter a fraction (a/b) or an integer (a): ");
        String fraction = input.nextLine();

        while (!validFraction(fraction)) {
            System.out.print("Invalid fraction. Please enter a fraction (a/b) or an integer (a), where a and b are integers and b is not zero: ");
            fraction = input.nextLine();
        }

        if(fraction.contains("/")) {
            num = Integer.parseInt(fraction.substring(0, fraction.indexOf("/")));
            den = Integer.parseInt(fraction.substring(fraction.indexOf("/") + 1));
        } else {
            num = Integer.parseInt(fraction);
            den = 1;
        }

        return new Fraction(num, den);
    }

    public static void main(String[] args) {
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");

        while (true) {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("Please choose an operation (+, -, /, *, = or Q to quit): ");
            String operation = getOperation(new Scanner(System.in));

            if (operation.equalsIgnoreCase("q")) {
                System.exit(0);
            }

            Fraction fraction1 = getFraction(new Scanner(System.in));
            Fraction fraction2 = getFraction(new Scanner(System.in));

            switch (operation) {
                case "+":
                    Fraction answer = fraction1.add(fraction2);
                    answer.toLowestTerms();
                    System.out.println(fraction1.toString() + " + " + fraction2.toString() + " = " + answer.toString());
                    break;
                case "-":
                    System.out.println(fraction1.toString() + " - " + fraction2.toString() + " = " + fraction1.subtract(fraction2));
                    break;
                case "/":
                    System.out.println(fraction1.toString() + " / " + fraction2.toString() + " = " + fraction1.divide(fraction2));
                    break;
                case "*":
                    System.out.println(fraction1.toString() + " * " + fraction2.toString() + " = " + fraction1.multiply(fraction2));
                    break;
                case "=":
                    System.out.println(fraction1.toString() + " = " + fraction2.toString() + " is " + fraction1.equals(fraction2));
                    break;
                default:
                    System.out.println("Something went wrong. Try again!");
            }
        }
    }//end main
}