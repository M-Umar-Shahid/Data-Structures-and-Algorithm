import java.util.Stack;

class InfixToPostfixConverter {
    // Function to check if a character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // Function to get the precedence of an operator
    private static int getPrecedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    // Function to convert infix expression to postfix expression
    public static String convertToPostfix(String infix) {
        String postfix = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (Character.isDigit(ch)) {
                postfix += ch;
                postfix += " ";
            } else if (isOperator(ch)) {
                while (!stack.empty() && getPrecedence(stack.peek()) >= getPrecedence(ch)) {
                    postfix += stack.pop();
                    postfix += " ";
                }
                stack.push(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.empty() && stack.peek() != '(') {
                    postfix += stack.pop();
                    postfix += " ";

                }
                stack.pop(); // Remove the ( from the stack
            }
        }

        while (!stack.empty()) {
            if (stack.peek() == '(' || stack.peek() == ')') {
                return "Invalid infix expression";
            }
            postfix += stack.pop();
            postfix += " ";

        }

        return postfix;
    }

    public static void main(String[] args) {
        String infix = "5 + (3 * 1) - 8 / 2";
        String postfix = convertToPostfix(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + postfix);
    }
}
