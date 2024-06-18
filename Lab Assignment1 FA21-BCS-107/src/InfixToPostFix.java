import java.util.Scanner;
import java.util.Stack;

class PostFix {
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

    public static void main(String[] args) {
        Stack<Character> operators = new Stack<>();
        String postfix = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an infix expression : ");
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                postfix += ch - '0';
                postfix += " ";
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.peek() == '(') {
                    postfix += operators.pop();
                    postfix += " ";
                }
                operators.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() > 0 && operators.peek() != '('
                        && precedence(ch) <= precedence(operators.peek())) {
                    postfix += operators.pop();
                    postfix += " ";

                }
                operators.push(ch);
            }
        }
        while (operators.size() != 0) {
            postfix += operators.pop();
            postfix += " ";

        }
        System.out.println(postfix);
    }
}