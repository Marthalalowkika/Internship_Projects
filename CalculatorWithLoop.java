import java.util.Scanner;

public class CalculatorWithLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculation = true;

        while (continueCalculation) {
            System.out.println("Enter first number: ");
            double num1 = scanner.nextDouble();

            System.out.println("Enter second number: ");
            double num2 = scanner.nextDouble();

            System.out.println("Select operation: +, -, *, /");
            char operation = scanner.next().charAt(0);

            double result = 0;

            switch (operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error! Division by zero is not allowed.");
                        continue;  // Skip the rest and start over
                    }
                    break;
                default:
                    System.out.println("Invalid operation. Please try again.");
                    continue;  // Skip the rest and start over
            }

            System.out.println("The result is: " + result);

            System.out.println("Do you want to perform another calculation? (yes/no)");
            String response = scanner.next();

            if (response.equalsIgnoreCase("no")) {
                continueCalculation = false;
            }
        }

        System.out.println("Calculator closed.");
    }
}