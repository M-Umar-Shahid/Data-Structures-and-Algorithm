import java.util.Scanner;
import java.util.Stack;

public class RPNnotation {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                System.out.println("Quitting");
                break;
            }

            if (isNumber(input)) {
                int number = Integer.parseInt(input);
                stack.push(number);
                System.out.println(stack);
            } else {
                if (stack.size() < 2) {
                    System.out.println("Error: Insufficient operands");
                    continue;
                }

                int operand2;
                int operand1;

                try {
                    operand2 = stack.pop();
                    operand1 = stack.pop();
                } catch (Exception e) {
                    System.out.println("Error: Invalid operand");
                    continue;
                }

                int result;

                switch (input) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        if (operand2 == 0) {
                            System.out.println("Error: Division by zero");
                            continue;
                        }
                        result = operand1 / operand2;
                        break;
                    default:
                        System.out.println("Error: Invalid operator");
                        continue;
                }

                stack.push(result);
                System.out.println(result);
            }
        }
        scanner.close();
    }

    private static boolean isNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
