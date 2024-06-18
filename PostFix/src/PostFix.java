import java.util.Scanner;
import java.util.Stack;

public class PostFix {
    public static int precedence(char operator) {
        if (operator == '+')
            return 1;
        if (operator == '-')
            return 1;
        if (operator == '*')
            return 2;
        else
            return 2;
    }

    public static int operation(int var1, int var2, char operator) {
        if (operator == '+')
            return var1 + var2;
        if (operator == '-')
            return var1 - var2;
        if (operator == '*')
            return var1 * var2;
        else
            return var1 / var2;
    }

    public static void main(String[] args) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an infix expression : ");
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                operands.push((ch - '0'));
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.peek() == '(') {
                    int var2 = operands.pop();
                    int var1 = operands.pop();
                    char operator = operators.pop();
                    int result = operation(var1, var2, operator);
                    operands.push(result);
                }
                operators.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() > 0 && operators.peek() != '(' && precedence(ch) <= precedence(operators.peek())) {
                    int var2 = operands.pop();
                    int var1 = operands.pop();
                    char operator = operators.pop();
                    int result = operation(var1, var2, operator);
                    operands.push(result);
                }
                operators.push(ch);
            }
        }
        while (operators.size() != 0) {
            int var2 = operands.pop();
            int var1 = operands.pop();
            char operator = operators.pop();
            int result = operation(var1, var2, operator);
            operands.push(result);
        }
        System.out.println(operands.pop());
    }
}