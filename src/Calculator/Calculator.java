package Calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calc calc = null;
        String errorMsg = null;

        while (errorMsg == null) {
            System.out.print("Enter the equation (only integer): ");
            String input = scanner.nextLine();

            Pattern pattern = Pattern.compile("(-?\\d+)([+\\-*/])(-?\\d+)");
            Matcher matcher = pattern.matcher(input);

            if (!matcher.matches()) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }

            int a = Integer.parseInt(matcher.group(1));
            String operator = matcher.group(2);
            int b = Integer.parseInt(matcher.group(3));

            switch (operator) {
                case "+":
                    calc = new Add();
                    break;
                case "-":
                    calc = new Sub();
                    break;
                case "*":
                    calc = new Mul();
                    break;
                case "/":
                    calc = new Div();
                    break;
                default:
                    System.out.println("Unknown operator. Please try again.");
                    continue;
            }

            calc.setValue(a, b);
            int result = calc.calculate();

            if (calc instanceof Div) {
                errorMsg = ((Div) calc).getErrorMsg();
            }

            if (errorMsg == null) {
                System.out.println("Result: " + result);
            } else {
                System.out.println("Progrma exit.");
            }
        }

        scanner.close();
    }
}